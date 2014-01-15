package app.mkp.backing;

import app.mkp.adfextensions.ADFUtils;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.event.DialogEvent;

public class RolesBackingBean {  
    // Delete operations
    private RichTable childTable;
    
    public RolesBackingBean() {
    }

    public void confirmDeleteClientDialogListener (DialogEvent e) {
        BackingUtil.confirmDeleteDialogListener(e, getChildTable(), "RolesView1");
        ADFUtils.invokeEL("#{bindings.Commit.execute}");
    }

    public void setChildTable(RichTable childTable) {
        this.childTable = childTable;
    }

    public RichTable getChildTable() {
        return childTable;
    }
}
