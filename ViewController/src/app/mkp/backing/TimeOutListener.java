package app.mkp.backing;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.adf.share.logging.ADFLogger;

public class TimeOutListener implements Filter {

    private FilterConfig filterConfig = null;
    private String initParam = null;

    /**
     * Logger.
     */
    private static final ADFLogger LOG = ADFLogger.createADFLogger(TimeOutListener.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        LOG.info("Init SessionExpiredFilter.");
        this.filterConfig = filterConfig;
        this.initParam = filterConfig.getInitParameter("RedirectTo");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void destroy() {
        filterConfig = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        LOG.info("Check if the session is valid.");
        final HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        final String adfCtrlState = request.getParameter("_adf.ctrl-state");
        final String requestedSession = httpServletRequest.getRequestedSessionId();
        final String currentWebSession = httpServletRequest.getSession().getId();

//        if (LOG.isDebugEnabled()) {
            LOG.info("Filter info: \n" +
                    "   adfCtrolState: " + adfCtrlState + "\n" +
                    "   requestedSession: " + requestedSession + "\n" +
                    "   currentWebSession " + currentWebSession);
//        }
        /*                    
        System.out.println("=======================================");            
        System.out.println("adfCtrolState: " + adfCtrlState);
        System.out.println("requestedSession: " + requestedSession);
        System.out.println("currentWebSession " + currentWebSession);                        
        System.out.println("=======================================");   
        */
        if (adfCtrlState != null && (requestedSession == null || !currentWebSession.equalsIgnoreCase(requestedSession))) {
            final String serverRelativeUrl = httpServletRequest.getContextPath() + "/" + initParam;

            LOG.info("Redirect to: " + initParam);
            if("true".equals(httpServletRequest.getHeader("Adf-Rich-Message"))) {
                // PPR
                PrintWriter writer = response.getWriter();
                writer.write("<?xml version=\"1.0\" ?>");
                writer.write("<?Adf-Rich-Response-Type ?>");
                writer.write("<redirect>");
                writer.write(serverRelativeUrl);
                writer.write("</redirect>");
            }
            else {
                // Normal
                ((HttpServletResponse) response).sendRedirect(serverRelativeUrl);
            }
        } else {
            chain.doFilter(request, response);
        }
    }
}