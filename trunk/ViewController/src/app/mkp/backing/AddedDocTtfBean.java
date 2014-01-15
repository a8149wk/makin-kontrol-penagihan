package app.mkp.backing;

import app.mkp.adfextensions.ADFUtils;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.binding.BindingContainer;

public class AddedDocTtfBean {    
    
    private RichTable addedDocTable;

    public AddedDocTtfBean() {
    }

    public void setAddedDocTable(RichTable addedDocTable) {
        this.addedDocTable = addedDocTable;
    }

    public RichTable getAddedDocTable() {
        return addedDocTable;
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    
    public void confirmDeleteAddedDocDialogListener(DialogEvent e) {
        BackingUtil.confirmDeleteDialogListener(e, getAddedDocTable(),
                                                "MknTtfAddedDocView2");
        ADFUtils.invokeEL("#{bindings.Commit.execute}");
    }

    public void confirmDeleteAddedDocReviewDialogListener(DialogEvent e) {
        BackingUtil.confirmDeleteDialogListener(e, getAddedDocTable(),
                                                "MknTtfAddedDocView1");
        ADFUtils.invokeEL("#{bindings.Commit.execute}");
    }

    public void confirmDeleteAddedDocMyTtfReviewDialogListener(DialogEvent e) {
        BackingUtil.confirmDeleteDialogListener(e, getAddedDocTable(),
                                                "MknTtfAddedDocView3");
        ADFUtils.invokeEL("#{bindings.Commit.execute}");
    }
}
