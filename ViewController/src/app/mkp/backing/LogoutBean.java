package app.mkp.backing;

import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutBean {

    public void logoutUser(ActionEvent evt) {
        /*
        try {
        */
            /*
             * TRY II - Not using ADF Security
             * Use this
            
            FacesContext ctx = FacesContext.getCurrentInstance();
            ExternalContext ectx = ctx.getExternalContext();
            HttpServletResponse response =
                (HttpServletResponse)ectx.getResponse();
            HttpSession session = (HttpSession)ectx.getSession(false);
            
            session.invalidate();
            ctx.responseComplete();
            response.sendRedirect("Login");
            FacesContext.getCurrentInstance().responseComplete();
            */

            /*
             * TRY I 
             * Just for testing
            
            ADFUtils.getDCBindingContainer().getBindingContext().release();
            session.invalidate();
            ctx.responseComplete();
                        
            ControllerContext cc = ControllerContext.getInstance();
            String logoutUrl = cc.getGlobalViewActivityURL("Login");
            response.sendRedirect(logoutUrl);
            */
            
            ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();  
            HttpServletResponse response = (HttpServletResponse)ectx.getResponse();  
            String url = ectx.getRequestContextPath()+"/adfAuthentication?logout=true&end_url=/faces/Login.jspx";  
              
            try {  
              response.sendRedirect(url);  
            } catch (Exception ex) {  
              ex.printStackTrace();  
            }  
            
        /*              
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }

}
