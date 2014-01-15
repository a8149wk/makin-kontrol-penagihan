package app.mkp.backing;

import app.mkp.adfextensions.ADFUtils;
import app.mkp.adfextensions.JSFUtils;
import app.mkp.model.MenuAMImpl;

import app.mkp.model.SecurityAMImpl;

import app.mkp.model.view.admin.UserDataViewImpl;
import app.mkp.model.view.admin.UserDataViewRowImpl;
import app.mkp.model.view.menubar.AppUrlViewImpl;
import app.mkp.model.view.menubar.AppUrlViewRowImpl;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.security.auth.Subject;
import javax.security.auth.login.FailedLoginException;

import javax.security.auth.login.LoginException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weblogic.security.URLCallbackHandler;
import weblogic.security.services.Authentication;

import weblogic.servlet.security.ServletAuthentication;

public class LoginBean {

    private String _username, _password, _appbpm, _appdms, _action;

    public void setUsername(String _username) {
        this._username = _username;
    }

    public String getUsername() {
        return _username;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public String getPassword() {
        return _password;
    }

    public String doLogin() throws LoginException {

        _appbpm = SessionAppUrl("BPM");
        _appdms = SessionAppUrl("DMS");
        _action = null;

        String un = _username;

        byte[] pw = _password.getBytes();

        FacesContext ctx = FacesContext.getCurrentInstance();

        HttpServletRequest request =
            (HttpServletRequest)ctx.getExternalContext().getRequest();

        Subject mySubject;

        try {

            mySubject = Authentication.login(new URLCallbackHandler(un, pw));

            ServletAuthentication.runAs(mySubject, request);

            ServletAuthentication.generateNewSessionID(request);

            String loginUrl =
                "/adfAuthentication?success_url=/faces/Pages/MainUserDashboard.jspx";

            // Get menu application module
            SecurityAMImpl securityAM =
                (SecurityAMImpl)ADFUtils.getApplicationModuleForDataControl("SecurityAMDataControl");

            UserDataViewImpl userDataView;
            userDataView = (UserDataViewImpl)securityAM.getUserDataView1();
            userDataView.setNamedWhereClauseParam("usrName", un);
            userDataView.executeQuery();

            if (userDataView.hasNext()) {
                UserDataViewRowImpl userDataRow =
                    (UserDataViewRowImpl)userDataView.first();

                String titleName = userDataRow.getPositions().toLowerCase();
                String namaKantor = userDataRow.getCompany();
                String displayName = userDataRow.getDisplayname();
                String depCode = userDataRow.getDepartmentcode();

                UserData userData =
                    (UserData)JSFUtils.resolveExpression("#{UserData}");
                userData.setAppBpmUrl(_appbpm);
                userData.setAppDmsUrl(_appdms);
                userData.setLoggedIn(Boolean.TRUE);
                userData.setFirstName(displayName);
                userData.setUserAccess(null);
                userData.setUserNameLogin(un);
                userData.setMiddleName(displayName);
                userData.setLastName(displayName);
                userData.setTitleName(titleName);
                userData.setDepartmentName(namaKantor);
                userData.setPassword(null);
                userData.setKodeKantor(null);
                userData.setNamaKantor(namaKantor);
                userData.setDepartmentCode(depCode);
            } else {
                UserData userData =
                    (UserData)JSFUtils.resolveExpression("#{UserData}");
                userData.setAppBpmUrl(_appbpm);
                userData.setAppDmsUrl(_appdms);
                userData.setLoggedIn(Boolean.TRUE);
                userData.setFirstName(un);
                userData.setUserAccess(null);
                userData.setUserNameLogin(un);
                userData.setMiddleName(un);
                userData.setLastName(un);
                userData.setTitleName("jabatan tidak ditemukan");
                userData.setDepartmentName("Matahari Kahuripan");
                userData.setPassword(null);
                userData.setKodeKantor(null);
                userData.setNamaKantor("Matahari Kahuripan");
                userData.setDepartmentCode("NULL");
            }

            HttpServletResponse response =
                (HttpServletResponse)ctx.getExternalContext().getResponse();

            RequestDispatcher dispatcher =
                request.getRequestDispatcher(loginUrl);

            dispatcher.forward(request, response);

        } catch (FailedLoginException e) {
        
            /*
            FacesMessage msg =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid username or password",
                                 "Invalid username or password");

            ctx.addMessage(null, msg);
            */

            _action = "errlogin";
            
        } catch (Exception e) {

            //System.err.println(e.getMessage());
            _action = "errglobal";

        }

        return _action;

    }

    /* Manual login classes
    private static final String LOGIN_MSG = "Incorrect login credentials";
    private RichInputText inputLogin;
    private RichInputText inputPassword;

    public String loginAction() {

        OperationBinding login = ADFUtils.findOperation("authenticateUser");
        Map m = (Map)login.execute();

        if(m != null && !m.isEmpty()){

            String firstName = (String)m.get("FirstName");
            String middleName = (String)m.get("MiddleName");
            String lastName = (String)m.get("LastName");
            String departmentName = (String)m.get("DepartmentName");
            String titleName = (String)m.get("TitleName");
            HashMap userAccess = (HashMap)m.get("UserAccess");
            String password = (String)m.get("Password");
            String userNameLogin = (String)m.get("UserName");
            Integer kodeKantor = (Integer)m.get("KodeKantor");
            String namaKantor = (String)m.get("NamaKantor");

            UserData userData = (UserData)JSFUtils.resolveExpression("#{UserData}");
            userData.setLoggedIn(Boolean.TRUE);
            userData.setFirstName(firstName);
            userData.setUserAccess(userAccess);
            userData.setUserNameLogin(userNameLogin);
            userData.setMiddleName(middleName);
            userData.setLastName(lastName);
            userData.setTitleName(titleName);
            userData.setDepartmentName(departmentName);
            userData.setPassword(password);
            userData.setKodeKantor(kodeKantor);
            userData.setNamaKantor(namaKantor);

            OperationBinding _notificationAMSession = ADFUtils.findOperation("setLoginToSession_NotificationAM");
            _notificationAMSession.execute();

            OperationBinding _menuAMSession = ADFUtils.findOperation("setLoginToSession_MenuAM");
            _menuAMSession.execute();

            return "success";

        }else{

            FacesContext fctx = FacesContext.getCurrentInstance();
            FacesMessage msg =
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, LOGIN_MSG,
                                             LOGIN_MSG);
                        fctx.addMessage(null, msg);
            inputLogin.resetValue();
            inputPassword.resetValue();
            return null;

        }
    }

    public void setInputLogin(RichInputText inputLogin) {
        this.inputLogin = inputLogin;
    }

    public RichInputText getInputLogin() {
        return inputLogin;
    }

    public void setInputPassword(RichInputText inputPassword) {
        this.inputPassword = inputPassword;
    }

    public RichInputText getInputPassword() {
        return inputPassword;
    }
    */

    private String SessionAppUrl(String appId) {
        String appUrlResult = "";
        String appIdResult = "";

        // Get menu application module
        MenuAMImpl menuAM =
            (MenuAMImpl)ADFUtils.getApplicationModuleForDataControl("MenuAMDataControl");
        // Get role by user access
        AppUrlViewImpl appUrlView;
        appUrlView = menuAM.getAppUrlView1();
        appUrlView.setNamedWhereClauseParam("appId", appId);
        appUrlView.executeQuery();

        while (appUrlView.hasNext()) {
            AppUrlViewRowImpl appUrl = (AppUrlViewRowImpl)appUrlView.first();
            appIdResult = appUrl.getAppId();
            appUrlResult = appUrl.getAppUrl1();
        }

        return appUrlResult;
    }
}
