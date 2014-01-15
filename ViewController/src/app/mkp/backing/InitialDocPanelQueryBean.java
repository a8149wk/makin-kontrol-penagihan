package app.mkp.backing;

import app.mkp.adfextensions.JSFUtils;

public class InitialDocPanelQueryBean {
    
    private String qryPanelFinAcc;
    private String qryPanelNotFinAcc;
    
    public InitialDocPanelQueryBean() {
    }

    public void setQryPanelFinAcc(String qryPanelFinAcc) {
        this.qryPanelFinAcc = qryPanelFinAcc;
    }

    public String getQryPanelFinAcc() {
        UserData userData =
            (UserData)JSFUtils.resolveExpression("#{UserData}");
        String deptCode = userData.getDepartmentCode();
        
        if (deptCode.compareToIgnoreCase("FIN")==0 || deptCode.compareToIgnoreCase("ACC")==0) {        
            qryPanelFinAcc = "true";
        } else {
            qryPanelFinAcc = "false";
        }
        return qryPanelFinAcc;
    }

    public void setQryPanelNotFinAcc(String qryPanelNotFinAcc) {
        this.qryPanelNotFinAcc = qryPanelNotFinAcc;
    }

    public String getQryPanelNotFinAcc() {
        UserData userData =
            (UserData)JSFUtils.resolveExpression("#{UserData}");
        String deptCode = userData.getDepartmentCode();
        
        if (deptCode.compareToIgnoreCase("FIN")==0 || deptCode.compareToIgnoreCase("ACC")==0) {        
            qryPanelNotFinAcc = "false";
        } else {
            qryPanelNotFinAcc = "true";
        }
        return qryPanelNotFinAcc;
    }
}
