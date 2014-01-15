package app.mkp.backing.scheduler;

import app.mkp.backing.mail.MailUtilities;

import commonj.timers.*;

import java.io.Serializable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Arrays;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;

public class SendQueueEventMail implements Serializable, TimerListener,
                                           CancelTimerListener {

    @SuppressWarnings("compatibility")
    private static final long serialVersionUID = 5890787544151725181L;

    public void timerExpired(Timer timer) {
        //System.out.println("Send event mail queue called on " + timer);

        Connection conn = null;
        Integer idNotifikasi = null;
        String nmNotifikasi = "";
        String mailSubject = "";
        String mailBody = "";
        String mailRecipient = "";
        String parameter = "";
        String varParam = "";
        try {
            //System.out.println("STARTING SEND EVENT NOTIFICATION...");

            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("jdbc/MKPConnectionDS");
            conn = ds.getConnection();
            PreparedStatement statement =
                conn.prepareStatement("SELECT NQ.ID_NOTIFIKASI_QUEUE,  " +
                                      "       NQ.NAMA_NOTIFIKASI,  " +
                                      "       NQ.RECIPIENT,  " +
                                      "       NQ.PARAMETER, " +
                                      "       MT.MAIL_SUBJECT, " +
                                      "       MT.MAIL_BODY, " +
                                      "       LISTAGG(MIP.INPUT_NM, ',') WITHIN GROUP (ORDER BY MIP.ID) AS VAR_PARAM " +
                                      "FROM NOTIFIKASI_QUEUE NQ, NOTIFIKASI_CFG NC, MAIL_TEMPLATE MT, MAIL_INPUT_PARAM MIP, INPUT_PARAM IP " +
                                      "WHERE NQ.NAMA_NOTIFIKASI = NC.NAMA_NOTIFIKASI " +
                                      "AND NC.MAIL_TEMPLATE_NM = MT.MAIL_NM " +
                                      "AND NC.NOTIFICATION_TYPE = 'E' " +
                                      "AND NQ.ID_NOTIFIKASI_QUEUE NOT IN (SELECT NL.QUEUE_NO FROM NOTIFIKASI_LOG NL WHERE NL.NAMA_NOTIFIKASI = NC.NAMA_NOTIFIKASI AND TIPE_NOTIFIKASI = 'E') " +
                                      "AND MT.MAIL_ID = MIP.MAIL_ID " +
                                      "AND IP.PARAM_ID = MIP.INPUT_NM " +
                                      "GROUP BY NQ.ID_NOTIFIKASI_QUEUE,  " +
                                      "       NQ.NAMA_NOTIFIKASI,  " +
                                      "       NQ.RECIPIENT,  " +
                                      "       NQ.PARAMETER,MT.MAIL_NM, " +
                                      "       MT.MAIL_SUBJECT, MT.MAIL_BODY " +
                                      "ORDER BY NQ.ID_NOTIFIKASI_QUEUE");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                idNotifikasi =
                        Integer.valueOf(rs.getString("ID_NOTIFIKASI_QUEUE"));
                nmNotifikasi = rs.getString("NAMA_NOTIFIKASI");
                mailSubject = rs.getString("MAIL_SUBJECT");
                mailBody = rs.getString("MAIL_BODY");
                mailRecipient = rs.getString("RECIPIENT");
                parameter = rs.getString("PARAMETER");
                varParam = rs.getString("VAR_PARAM");

                /*
                System.out.println("--------------------------------------");
                System.out.println("ID_NOTIFIKASI_QUEUE: " + mailRecipient);
                System.out.println("NAMA_NOTIFIKASI    : " + nmNotifikasi);
                System.out.println("MAIL_SUBJECT       : " + mailSubject);
                System.out.println("MAIL_BODY          : " + mailBody);
                System.out.println("RECIPIENT          : " + mailRecipient);
                System.out.println("PARAMETER          : " + parameter);
                System.out.println("VAR_PARAM          : " + varParam);
                System.out.println("--------------------------------------");
                */

                // Send the Email
                String result = null;

                ArrayList<String> recipient =
                    new ArrayList<String>(Arrays.asList(mailRecipient.split(",")));

                //Add body content
                mailBody = replaceBodyMailParam(mailBody, parameter, varParam);
                String bodyContent = mailBody;

                //Invoke mail utility package
                MailUtilities util = new MailUtilities();
                result = util.sendMail(mailSubject, recipient, bodyContent);

                // Write success to notification log
                writeSuccessNotificationLog(conn, nmNotifikasi, idNotifikasi);
            }
            statement.close();
            rs.close();
            conn.close();
        } catch (Exception exc) {
            //exc.printStackTrace();

            // Write failed to notification log
            writeFailedNotificationLog(conn, nmNotifikasi, idNotifikasi);
        } finally {
            //System.out.println("FINISHED SEND EVENT NOTIFICATION...");
        }
    }

    public void timerCancel(Timer timer) {
        System.out.println("Send event mail queue cancelled called on " +
                           timer);

    }

    private void writeSuccessNotificationLog(Connection conn,
                                             String nmNotifikasi,
                                             Integer queueNo) {
        try {
            PreparedStatement insertlogstat =
                conn.prepareStatement("INSERT INTO NOTIFIKASI_LOG(NAMA_NOTIFIKASI, EXECUTE_DT, STATUS, TIPE_NOTIFIKASI, QUEUE_NO) VALUES (?, SYSDATE, 'S', 'E', ?)");
            insertlogstat.setString(1, nmNotifikasi);
            insertlogstat.setInt(2, queueNo);
            insertlogstat.executeUpdate();
            insertlogstat.close();
        } catch (SQLException e) {
            try {
                PreparedStatement updatelogstat =
                    conn.prepareStatement("UPDATE NOTIFIKASI_LOG SET EXECUTE_DT=SYSDATE, STATUS='S', TIPE_NOTIFIKASI='E', QUEUE_NO = ? WHERE NAMA_NOTIFIKASI = ? AND TO_CHAR(EXECUTE_DT, 'DD-MM-YYYY') = TO_CHAR(SYSDATE, 'DD-MM-YYYY')");
                updatelogstat.setString(1, nmNotifikasi);
                updatelogstat.setInt(2, queueNo);
                updatelogstat.executeUpdate();
                updatelogstat.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        } finally {
            deleteNotificationQueue(conn, queueNo);
        }
    }

    private void writeFailedNotificationLog(Connection conn,
                                            String nmNotifikasi,
                                            Integer queueNo) {
        try {
            PreparedStatement insertlogstat =
                conn.prepareStatement("INSERT INTO NOTIFIKASI_LOG(NAMA_NOTIFIKASI, EXECUTE_DT, STATUS, TIPE_NOTIFIKASI, QUEUE_NO) VALUES (?, SYSDATE, 'F', 'E', ?)");
            insertlogstat.setString(1, nmNotifikasi);
            insertlogstat.setInt(2, queueNo);
            insertlogstat.executeUpdate();
            insertlogstat.close();
        } catch (SQLException e) {
            try {
                PreparedStatement updatelogstat =
                    conn.prepareStatement("UPDATE NOTIFIKASI_LOG SET EXECUTE_DT=SYSDATE, STATUS='F', TIPE_NOTIFIKASI='E', QUEUE_NO = ? WHERE NAMA_NOTIFIKASI = ? AND TO_CHAR(EXECUTE_DT, 'DD-MM-YYYY') = TO_CHAR(SYSDATE, 'DD-MM-YYYY')");
                updatelogstat.setString(1, nmNotifikasi);
                updatelogstat.setInt(2, queueNo);
                updatelogstat.executeUpdate();
                updatelogstat.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        } finally {
            deleteNotificationQueue(conn, queueNo);
        }
    }

    private void deleteNotificationQueue(Connection conn, Integer queueNo) {
        try {
            PreparedStatement deleteNotifQue =
                conn.prepareStatement("DELETE FROM NOTIFIKASI_QUEUE WHERE ID_NOTIFIKASI_QUEUE = ?");
            deleteNotifQue.setInt(1, queueNo);
            deleteNotifQue.executeUpdate();
            deleteNotifQue.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        ;
    }

    private String replaceBodyMailParam(String mailBody, String parameter,
                                        String varParam) {

        ArrayList<String> paramValue =
            new ArrayList<String>(Arrays.asList(parameter.split(",")));

        ArrayList<String> paramVariable =
            new ArrayList<String>(Arrays.asList(varParam.split(",")));

        String mailBodyReplace = mailBody;
        for (int i = 0; i < paramValue.size(); i++) {
            mailBodyReplace =
                    mailBodyReplace.replace("#" + paramVariable.get(i) + "#",
                                            paramValue.get(i));
        }
        return mailBodyReplace;
    }
}
