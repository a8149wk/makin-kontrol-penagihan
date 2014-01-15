package app.mkp.backing;

import java.util.HashMap;

public class UserData {
    private HashMap userAccess;
    private String departmentName;
    private Boolean loggedIn = Boolean.FALSE;    
    private String firstName;
    private String middleName;
    private String lastName;
    private String titleName;
    private String password;
    private String userNameLogin;
    private Integer kodeKantor;
    private String namaKantor;
    private String appBpmUrl;
    private String appDmsUrl;
    private String departmentCode;

    public UserData(){
    }

    public void setUserAccess(HashMap userAccess) {
        this.userAccess = userAccess;
    }

    public HashMap getUserAccess() {
        return userAccess;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUserNameLogin(String userNameLogin) {
        this.userNameLogin = userNameLogin;
    }

    public String getUserNameLogin() {
        return userNameLogin;
    }

    public void setKodeKantor(Integer kodeKantor) {
        this.kodeKantor = kodeKantor;
    }

    public Integer getKodeKantor() {
        return kodeKantor;
    }

    public void setNamaKantor(String namaKantor) {
        this.namaKantor = namaKantor;
    }

    public String getNamaKantor() {
        return namaKantor;
    }

    public void setAppBpmUrl(String appBpmUrl) {
        this.appBpmUrl = appBpmUrl;
    }

    public String getAppBpmUrl() {
        return appBpmUrl;
    }

    public void setAppDmsUrl(String appDmsUrl) {
        this.appDmsUrl = appDmsUrl;
    }

    public String getAppDmsUrl() {
        return appDmsUrl;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }
}
