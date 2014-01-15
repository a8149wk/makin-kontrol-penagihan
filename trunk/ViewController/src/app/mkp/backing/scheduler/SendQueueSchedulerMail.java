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

public class SendQueueSchedulerMail implements Serializable, TimerListener,
                                               CancelTimerListener {

    String dmsUrl = "";

    @SuppressWarnings("compatibility")
    private static final long serialVersionUID = 5890787544151725181L;

    public void timerExpired(Timer timer) {
        //System.out.println("Send scheduler mail queue called on " + timer);

        Connection conn = null;
        String nmNotifikasi = "";
        String mailSubject = "";
        String mailBody = "";
        String mailRecipient = "";
        String mailSql = "";

        // Get DMS URL
        try {
            Context ctxUrl = new InitialContext();
            DataSource ds = (DataSource)ctxUrl.lookup("jdbc/MKPConnectionDS");
            conn = ds.getConnection();
            PreparedStatement statement =
                conn.prepareStatement("SELECT AU.APP_URL FROM APP_URL AU WHERE APP_ID = 'DMS'");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                dmsUrl = rs.getString("APP_URL");
            }

            statement.close();
            rs.close();
            conn.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        // End get DMS URL
        /*
        System.out.println("----------------------------------");
        System.out.println("DMS URL: |" + dmsUrl + "|");
        System.out.println("----------------------------------");
        */

        try {
            //System.out.println("STARTING SEND SCHEDULER NOTIFICATION...");

            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("jdbc/MKPConnectionDS");
            conn = ds.getConnection();
            PreparedStatement statement =
                conn.prepareStatement("SELECT MQ.ID_NOTIFIKASI, " +
                                      "MQ.NAMA_NOTIFIKASI, " +
                                      "MQ.MAIL_SUBJECT, MQ.MAIL_BODY, " +
                                      "LISTAGG(TRIM(MQ.MAIL_REP), ',') WITHIN GROUP (ORDER BY MQ.ID_NOTIFIKASI) AS MAIL_RECIPIENT, " +
                                      "MQ.MAIL_SQL FROM (SELECT DISTINCT(PER.EMAIL) AS MAIL_REP, NC.ID_NOTIFIKASI, " +
                                      "NC.NAMA_NOTIFIKASI, MT.MAIL_SUBJECT, MT.MAIL_BODY, MT.MAIL_SQL " +
                                      "FROM NOTIFIKASI_CFG NC, MAIL_TEMPLATE MT, NOTIFIKASI_POSITION NP, PERSON PER, POSITION POS " +
                                      "WHERE NP.NOTIFIKASI_ID = NC.ID_NOTIFIKASI " +
                                      "AND NC.MAIL_TEMPLATE_NM = MT.MAIL_NM " +
                                      "AND NC.NOTIFICATION_TYPE = 'B' " +
                                      "AND NC.NAMA_NOTIFIKASI NOT IN (SELECT NL.NAMA_NOTIFIKASI FROM NOTIFIKASI_LOG NL WHERE TO_CHAR(NL.EXECUTE_DT, 'DD/MM/YYYY') = TO_CHAR(SYSDATE, 'DD/MM/YYYY')) " +
                                      "AND PER.EMPLID = POS.EMPLID " +
                                      "AND POS.POSITIONCODE = NP.USR_POSITION ) MQ " +
                                      "GROUP BY MQ.ID_NOTIFIKASI, MQ.NAMA_NOTIFIKASI, MQ.MAIL_SUBJECT, MQ.MAIL_BODY, MQ.MAIL_SQL ");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                //Integer idNotifikasi = schedulerQueueRow.getIdNotifikasi();
                nmNotifikasi = rs.getString("NAMA_NOTIFIKASI");
                mailSubject = rs.getString("MAIL_SUBJECT");
                mailBody = rs.getString("MAIL_BODY");
                mailRecipient = rs.getString("MAIL_RECIPIENT");
                mailSql = rs.getString("MAIL_SQL");

                /*
                System.out.println("--------------------------------------");
                System.out.println("NAMA_NOTIFIKASI : " + nmNotifikasi);
                System.out.println("MAIL_SUBJECT    : " + mailBody);
                System.out.println("MAIL_RECIPIENT  : " + mailRecipient);
                System.out.println("--------------------------------------");
                */

                // Get rowset of document which will be notifiy to user
                String rowSetParam =
                    documentRowSet(conn, mailSql, nmNotifikasi);

                if (!rowSetParam.equals("")) {
                    // Replace #ROWSET# from the template
                    mailBody = mailBody.replace("#ROWSET#", rowSetParam);

                    /*
                    System.out.println("--------------------------------------");
                    System.out.println("MAIL SUBJECT  : " + mailSubject);
                    System.out.println("MAIL BODY     : " + mailBody);
                    System.out.println("MAIL RECIPIENT: " + mailRecipient);
                    System.out.println("--------------------------------------");
                    */

                    // Send the Email
                    String result = null;
                    ArrayList<String> recipient =
                        new ArrayList<String>(Arrays.asList(mailRecipient.split(",")));

                    //Add body content
                    String bodyContent = mailBody;

                    //Invoke mail utility package
                    MailUtilities util = new MailUtilities();
                    result =
                            util.sendMail(mailSubject, recipient, bodyContent);

                    // Write success to notification log
                    writeSuccessNotificationLog(conn, nmNotifikasi);
                } else {
                    // Write empty to notification log
                    writeEmptyNotificationLog(conn, nmNotifikasi);
                }
            }
            statement.close();
            rs.close();
            conn.close();
        } catch (Exception exc) {
            //exc.printStackTrace();

            // Write failed to notification log
            writeFailedNotificationLog(conn, nmNotifikasi);
        } finally {
            //System.out.println("FINISHED SEND SCHEDULER NOTIFICATION...");
        }
    }

    public void timerCancel(Timer timer) {
        System.out.println("Send scheduler mail queue cancelled called on " +
                           timer);
    }

    public String documentRowSet(Connection conn, String mailQuery,
                                 String nmNotifikasi) {
        int dataRowNum = 0;
        String docRowSet =
            "<table id=\"rowSetTable\" class=\"rsTbl\" cellpadding=\"3\" cellspacing=\"0\" summary=\"Table with a notification of document\"> " +
            "    <tbody> " + "      <tr> " +
            "        <td class=\"rsColTblHdr\"  width=\"33\" scope=\"col\"><div align=\"center\"><strong>Link</strong></div></td> " +
            "        <td class=\"rsColTblHdr\" width=\"400\" scope=\"col\"><div align=\"center\"><strong>Description</strong></div></td> " +
            "      </tr>";

        try {
            PreparedStatement statement = conn.prepareStatement(mailQuery);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                dataRowNum = dataRowNum + 1;
                String docTitle = rs.getString("DOCTITLE");
                String docName = rs.getString("DOCNAME");
                String docDescr = rs.getString("DOCDESCR");
                String docInfoDate = rs.getString("DOCINFODATE");
                String docLink = dmsUrl + rs.getString("DOCLINK");
                String docLinkThumb =
                    dmsUrl + docLink.replace(".pdf", "@t~1.jpg");
                /*
                System.out.println("--------------------------------------");
                System.out.println("DOC ID       : " + docId);
                System.out.println("DOC DESCR    : " + docDescription);
                System.out.println("DOC DATE INFO: " + docDateInfo);
                System.out.println("DOC LINK     : " + docLink);
                System.out.println("--------------------------------------");
                */
                if (dataRowNum % 2 == 0) {
                    docRowSet = docRowSet + "<tr class=\"rowEven\">";
                } else {
                    docRowSet = docRowSet + "<tr class=\"rowOdd\">";
                }

                docRowSet =
                        docRowSet + "<td><div class=\"rsColTblContent\"> " +
                        "          <div> " +
                        "            <div align=\"center\"><a href=\"" +
                        docLink + "\" target=\"_blank\"><img src=\"" +
                        docLinkThumb +
                        "\" border=\"0\" alt=\"Link To Document\" /></a></div> " +
                        "          </div> " + "        </div></td> " +
                        "        <td><div class=\"rsColTblContent\"><a href=\"" +
                        docLink + "\" target=\"_blank\"><strong>" + docTitle +
                        " &nbsp;&nbsp;[&nbsp;" + docName +
                        "&nbsp;]</strong><br /> " + "          </a>" +
                        docDescr + "<br /> " +
                        "          <strong>Expired Date:</strong>&nbsp;" +
                        docInfoDate + "&nbsp;<br /> " + "          <br /> " +
                        "        </div></td> " + "      </tr>  </tr>";
            }
            statement.close();
            rs.close();
        } catch (SQLException e) {
            //e.printStackTrace();

            // Write failed to notification log
            writeFailedNotificationLog(conn, nmNotifikasi);
        }

        docRowSet = docRowSet + " </tbody>  </table></br>";

        if (dataRowNum > 0) {
            return docRowSet;
        } else {
            return "";
        }
    }

    public void writeSuccessNotificationLog(Connection conn,
                                            String nmNotifikasi) {
        // Notification success, then set log as Success (S)
        try {
            PreparedStatement insertlogstat =
                conn.prepareStatement("INSERT INTO NOTIFIKASI_LOG (NAMA_NOTIFIKASI, EXECUTE_DT, STATUS) VALUES (?, SYSDATE, 'S')");
            insertlogstat.setString(1, nmNotifikasi);
            insertlogstat.executeUpdate();
            insertlogstat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void writeFailedNotificationLog(Connection conn,
                                           String nmNotifikasi) {
        // Failed to send notification, then set log as Failed (F)
        try {
            PreparedStatement insertlogstat =
                conn.prepareStatement("INSERT INTO NOTIFIKASI_LOG (NAMA_NOTIFIKASI, EXECUTE_DT, STATUS) VALUES (?, SYSDATE, 'F')");
            insertlogstat.setString(1, nmNotifikasi);
            insertlogstat.executeUpdate();
            insertlogstat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void writeEmptyNotificationLog(Connection conn,
                                          String nmNotifikasi) {
        // No data rowset found, then set log as Empty (E)
        try {
            PreparedStatement insertlogstat =
                conn.prepareStatement("INSERT INTO NOTIFIKASI_LOG(NAMA_NOTIFIKASI, EXECUTE_DT, STATUS) VALUES (?, SYSDATE, 'E')");
            insertlogstat.setString(1, nmNotifikasi);
            insertlogstat.executeUpdate();
            insertlogstat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
