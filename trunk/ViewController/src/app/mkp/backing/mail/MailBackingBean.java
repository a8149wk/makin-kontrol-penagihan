package app.mkp.backing.mail;

import java.util.ArrayList;

import javax.faces.event.ActionEvent;

import oracle.adf.controller.TaskFlowId;
import oracle.adf.view.rich.component.rich.input.RichInputText;

public class MailBackingBean {
    private String mailConfigTaskFlowId = "/WEB-INF/mail-config.xml#mail-config";
    private String mailTemplateTaskFlowId = "/WEB-INF/mail-template.xml#mail-template";
    private String mailParamTaskFlowId = "/WEB-INF/mail-param.xml#mail-param";
    private String currentTF = "template";
    
    private RichInputText emailId;
    private RichInputText mailComments;
    
    public MailBackingBean() {
    }  
    
    public TaskFlowId getDynamicTaskFlowId() {
        if (this.getCurrentTF().equalsIgnoreCase("config"))
            return TaskFlowId.parse(mailConfigTaskFlowId);
        else if (this.getCurrentTF().equalsIgnoreCase("mailparam"))
            return TaskFlowId.parse(mailParamTaskFlowId);
        else
            return TaskFlowId.parse(mailTemplateTaskFlowId);
    }

    public void setCurrentTF(String currentTF) {
        this.currentTF = currentTF;
    }

    public String getCurrentTF() {
        return currentTF;
    }
    
    public void setEmailId(RichInputText emailId) {
        this.emailId = emailId;
    }

    public RichInputText getEmailId() {
        return emailId;
    }

    public void setMailComments(RichInputText mailComments) {
        this.mailComments = mailComments;
    }

    public RichInputText getMailComments() {
        return mailComments;
    }

    public void sendEmail(ActionEvent actionEvent) {        
       
       String result = null;
       ArrayList<String> recipient = new ArrayList<String>();   
       
        //Add one or more recipients here
        if(this.getEmailId().getValue() != null)
            recipient.add(this.getEmailId().getValue().toString());
        else
            recipient.add("mii.dms@makingroup.com");
       
       
        //Add comments
        String comments = "Sender Comments::     ";
        if(this.getMailComments().getValue() != null)
            comments = comments+this.getMailComments().getValue().toString();
        else
            comments = comments+"No comments from sender";
        String bodyContent = "This is system generated email \n "+comments;
        
        //Invoke mail utility package
        MailUtilities util = new MailUtilities();
        result = util.sendMail("ADF Test Subject", recipient, bodyContent);
        
    }
}