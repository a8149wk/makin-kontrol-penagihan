package app.mkp.backing.mail;

import com.sun.mail.smtp.SMTPTransport;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.ArrayList;

import javax.naming.InitialContext;

public class MailUtilities {

    String emailTableStyle = "<style type=\"text/css\"> " + 
                            "<!-- " + 
                            ".rsTbl { " + 
                            "        border:thin; " + 
                            "        border-color:#666666; " + 
                            "        border-style:solid; " + 
                            "        font-family:Arial, Helvetica, sans-serif; " + 
                            "        font-size:14px; " + 
                            "} " + 
                            ".rsColTblHdr { " + 
                            "        border-bottom:thin; " + 
                            "        border-color:#666666; " + 
                            "        background-color:#B0F169; " + 
                            "        font-family:Arial, Helvetica, sans-serif; " + 
                            "        font-size:14px; " + 
                            "} " + 
                            ".rsColTblContent { " + 
                            "        border:thin; " + 
                            "        padding:5px; " + 
                            "        border-right:thin; " + 
                            "        border-color:#666666; " + 
                            "        font-family:Arial, Helvetica, sans-serif; " + 
                            "        font-size:14px; " + 
                            "} " + 
                            " " + 
                            ".rowOdd {        " + 
                            "        background-color:#FFFFFF; " + 
                            "} " + 
                            ".rowEven { " + 
                            "        background-color:#DDFCBA; " + 
                            "} " + 
                            " " + 
                            "--> " + 
                            "</style>";
    public MailUtilities() {
        super();
    }
    
    public String sendMail(String subject, ArrayList<String> recipient, String bodyContent){
        try{
                /**
                 * Initialize mail session
                 * Note: "com.makin.mailsession" is the JNDI name in mail session defined in Weblogic server
                 */
                InitialContext ic = new InitialContext();
                Session session = (Session) ic.lookup("com.makin.mailsession");
                Properties props = session.getProperties();
                //props.list(System.out);

                //fetch properties set in Mail-session in Weblogic server
                String mailhost = props.getProperty("mail.smtp.host");
                String protocol = props.getProperty("mail.transport.protocol");
                String mailDisabled = props.getProperty("mail.disable");                
                
                //get message body text
                String bodyText = null;
                bodyText =  "Email ini dikirim oleh sistem notifikasi MAKIN. Tidak usah dibalas. \n \n ";
            
                if(bodyContent != null)
                    bodyText = bodyText+bodyContent;
                bodyText =  bodyText+"\n \n Akhir email notifikasi \n";
                
                //get message subject
                if(subject==null || subject.equals(""))
                    subject = "Email Sistem Notifikasi MAKIN";


                /**
                 * use sendDisabled flag to control mail enable or disable option from weblogic server. 
                 * Whenever you want to disable mail sending, you can set this "sentDisable" = true
                 * 
                 */
                 
                mailDisabled = mailDisabled == null ? "false" : mailDisabled;
                boolean sentDisabled = false;
                if(mailDisabled.equals("true"))
                    sentDisabled = true;
        
                //check if mail send option is disabled in Weblogic server.
                if(!sentDisabled){
                
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom();
                    message.setSubject(subject, "UTF-8");
                    message.setSentDate(new Date());      
                    
                    //Add all recipients
                    InternetAddress[] addressTo = new InternetAddress[recipient.size()];
                    for (int i = 0; i < recipient.size(); i++)
                    {
                        addressTo[i] = new InternetAddress(recipient.get(i));
                    }
                    
                    //if recipient list is null then send email to default DL(distribution List)
                    if(recipient.size() <1) 
                        addressTo[0] = new InternetAddress("mii.dms@makingroup.com");
                    
                    message.setRecipients(Message.RecipientType.TO, addressTo); 
                    
                    //Add body part of message here, Alternative TEXT/HTML content    
                    MimeBodyPart wrap = new MimeBodyPart();
                    
                    MimeMultipart cover = new MimeMultipart("alternative");
                    MimeBodyPart html = new MimeBodyPart();
                    MimeBodyPart text = new MimeBodyPart();
                    cover.addBodyPart(html);
                    
                    wrap.setContent(cover);
                    
                    MimeMultipart content = new MimeMultipart("related");
                    message.setContent(content);
                    content.addBodyPart(wrap);
                    
                    html.setContent("<html><head><style type=\"text/css\"> " +
                            ".rsTbl { " + 
                            "        border:thin; " + 
                            "        border-color:#666666; " + 
                            "        border-style:solid; " + 
                            "        font-family:Arial, Helvetica, sans-serif; " + 
                            "        font-size:14px; " + 
                            "} " + 
                            ".rsColTblHdr { " + 
                            "        border-bottom:thin; " + 
                            "        border-color:#666666; " + 
                            "        background-color:#B0F169; " + 
                            "        font-family:Arial, Helvetica, sans-serif; " + 
                            "        font-size:14px; " + 
                            "} " + 
                            ".rsColTblContent { " + 
                            "        border:thin; " + 
                            "        padding:5px; " + 
                            "        border-right:thin; " + 
                            "        border-color:#666666; " + 
                            "        font-family:Arial, Helvetica, sans-serif; " + 
                            "        font-size:14px; " + 
                            "} " + 
                            " " + 
                            ".rowOdd {        " + 
                            "        background-color:#FFFFFF; " + 
                            "} " + 
                            ".rowEven { " + 
                            "        background-color:#DDFCBA; " + 
                            "} " + 
                            " " +  
                            "</style></head><body>" + bodyContent + "</body></html>", "text/html");
                    
                    // Send the message                    
                    SMTPTransport t = (SMTPTransport)session.getTransport(protocol);
                    try {
                        t.connect(mailhost, null, null);
                        t.send(message);
                    } finally {
                    
                        t.close();
                    }
                
                }else{
                    System.out.println("Mail Sending is disabled.");
                }
            } catch(Exception e){
                e.printStackTrace();
            }        
        
        
        return "email sent successfully";
    }
}
