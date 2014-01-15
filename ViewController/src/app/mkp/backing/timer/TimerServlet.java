package app.mkp.backing.timer;

import app.mkp.backing.scheduler.SendQueueEventMail;

import app.mkp.backing.scheduler.SendQueueSchedulerMail;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import commonj.timers.*;

/**
* TimerServlet demonstrates a simple use of commonj timers
*/
public class TimerServlet extends HttpServlet {


    @SuppressWarnings("compatibility:2457890615325353578")
    private static final long serialVersionUID = -5696661815499027088L;

    public void init(ServletConfig config) throws ServletException {

       super.init(config);
       System.out.println("timer servlet is initialized  ");
       try {
           InitialContext ic = new InitialContext();
           TimerManager tm = (TimerManager)ic.lookup("java:comp/env/tm/TimerManager");
           
           // SEND EVENT MAIL
           Timer batchRunSendEventTimer = null;
           Boolean batchRunSendEventTimerIsRunning = false;
           
           // Execute timer every 30 seconds starting immediately
           batchRunSendEventTimer = tm.schedule(new SendQueueEventMail(), 0, 10 * 1000);
           batchRunSendEventTimerIsRunning = true;
           
           config.getServletContext().setAttribute("batchRunSendEventTimer", batchRunSendEventTimer);
           config.getServletContext().setAttribute("batchRunSendEventTimerIsRunning", batchRunSendEventTimerIsRunning);
           
           // SEND SCHEDULER MAIL 
           Timer batchRunSendSchedulerTimer = null;
           Boolean batchRunSendSchedulerTimerIsRunning = false;
           
           // Execute timer every 20 seconds starting immediately
           batchRunSendSchedulerTimer = tm.schedule(new SendQueueSchedulerMail(), 0, 30 * 1000);
           batchRunSendSchedulerTimerIsRunning = true;
           
           config.getServletContext().setAttribute("batchRunSendSchedulerTimer", batchRunSendSchedulerTimer);
           config.getServletContext().setAttribute("batchRunSendSchedulerTimerIsRunning", batchRunSendSchedulerTimerIsRunning);

       } catch (NamingException ne) {
           ne.printStackTrace();
       }
   }

   public void service(HttpServletRequest req,  HttpServletResponse res) throws IOException {
      res.setContentType("text/html");
       PrintWriter out = res.getWriter();
       out.println("Timer servlet is working!");
   }
}