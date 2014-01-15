package app.mkp.backing.timer;

import app.mkp.backing.mail.MailUtilities;
import app.mkp.backing.scheduler.SendQueueEventMail;

import app.mkp.backing.scheduler.SendQueueSchedulerMail;

import commonj.timers.Timer;
import commonj.timers.TimerManager;

import java.util.ArrayList;

import javax.faces.event.ActionEvent;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;

public class TimerBean {


    private InitialContext ic = null;
    private TimerManager tm = null;

    private Timer batchRunSendEventTimer = null;
    private Boolean batchRunSendEventTimerIsRunning = false;

    private Timer batchRunSendSchedulerTimer = null;
    private Boolean batchRunSendSchedulerTimerIsRunning = false;

    public TimerBean() {
        try {
            ic = new InitialContext();
            tm = (TimerManager)ic.lookup("java:comp/env/tm/TimerManager");

            FacesContext ctx = FacesContext.getCurrentInstance();
            ServletContext servletContext =
                (ServletContext)ctx.getExternalContext().getContext();
            
            // Send for by Event
            batchRunSendEventTimer =
                    (Timer)servletContext.getAttribute("batchRunSendEventTimer");
            batchRunSendEventTimerIsRunning =
                    (Boolean)servletContext.getAttribute("batchRunSendEventRunning");
            
            // Send for by Scheduler
            batchRunSendSchedulerTimer =
                    (Timer)servletContext.getAttribute("batchRunSendSchedulerMailTimer");
            batchRunSendSchedulerTimerIsRunning =
                    (Boolean)servletContext.getAttribute("batchRunSendSchedulerMailRunning");

            System.out.println("Timer Initialization End");

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public void timerManager(ActionEvent actionEvent) {
        // Add event code here...
        if (tm.isSuspended()) {
            tm.resume();
        } else {
            tm.suspend();
        }
    }

    public void sendQueueEventMail(ActionEvent actionEvent) {
        // Add event code here...
        if (batchRunSendEventTimerIsRunning) {
            batchRunSendEventTimer.cancel();
            batchRunSendEventTimerIsRunning = false;
        } else {
            batchRunSendEventTimer =
                    tm.schedule(new SendQueueEventMail(), 0, 10 * 1000);
            batchRunSendEventTimerIsRunning = true;
        }
    }
    
    public void sendQueueSchedulerMail(ActionEvent actionEvent) {
        // Add event code here...
        if (batchRunSendSchedulerTimerIsRunning) {
            batchRunSendSchedulerTimer.cancel();
            batchRunSendSchedulerTimerIsRunning = false;
        } else {
            batchRunSendSchedulerTimer =
                    tm.schedule(new SendQueueSchedulerMail(), 0, 10 * 1000);
            batchRunSendSchedulerTimerIsRunning = true;
        }
    }

    public String getTmStatus() {
        if (tm.isSuspended()) {
            return "Timer Manager is stopped";
        } else {
            return "Timer Manager is running";
        }
    }

    public String getSendQueueMailStatus() {
        Long time = batchRunSendEventTimer.getScheduledExecutionTime();
        java.util.Date date = new java.util.Date(time);
        if (batchRunSendEventTimerIsRunning) {
            return "Send Queue Mail scheduled time " + date.toString();
        } else {
            return "Send Queue Mail stopped";
        }
    }

    public void setBatchRunSendEventTimer(Timer batchRunSendMailTimer) {
        this.batchRunSendEventTimer = batchRunSendMailTimer;
    }

    public Timer getBatchRunSendEventTimer() {
        return batchRunSendEventTimer;
    }

    public void setBatchRunSendEventTimerIsRunning(Boolean batchRunSendMailTimerIsRunning) {
        this.batchRunSendEventTimerIsRunning = batchRunSendMailTimerIsRunning;
    }

    public Boolean getBatchRunSendEventTimerIsRunning() {
        return batchRunSendEventTimerIsRunning;
    }


    public void setBatchRunSendSchedulerTimer(Timer batchRunSendSchedulerTimer) {
        this.batchRunSendSchedulerTimer = batchRunSendSchedulerTimer;
    }

    public Timer getBatchRunSendSchedulerTimer() {
        return batchRunSendSchedulerTimer;
    }

    public void setBatchRunSendSchedulerTimerIsRunning(Boolean batchRunSendSchedulerTimerIsRunning) {
        this.batchRunSendSchedulerTimerIsRunning = batchRunSendSchedulerTimerIsRunning;
    }

    public Boolean getBatchRunSendSchedulerTimerIsRunning() {
        return batchRunSendSchedulerTimerIsRunning;
    }
}
