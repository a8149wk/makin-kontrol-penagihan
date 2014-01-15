package app.mkp.backing;

import app.mkp.adfextensions.ADFUtils;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import javax.faces.model.SelectItem;

import oracle.adf.model.BindingContext;
import oracle.adf.model.OperationBinding;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.adf.view.rich.event.DialogEvent;

import oracle.binding.BindingContainer;

import oracle.jbo.Row;

public class LevelOfAuthorityBackingBean {

    // Shuttle operations Finance --> List PT
    List selectedMenuItems;
    List allMenuItems;
    Boolean refreshSelectedList = false;
    
    // Shuttle operations Accounting --> Vendor
    List selectedVndMenuItems;
    List allVndMenuItems;
    Boolean refreshVndSelectedList = false;
    
    // Delete Operation
    private RichTable childTableLoa;
    private RichTable childTableAuthLvl;
    private RichTable childTableLoaAppvr;
    
    public LevelOfAuthorityBackingBean() {
    }    
    
    // Delete Operations LOA
    public void confirmDeleteLoaDialogListener (DialogEvent e) {
        BackingUtil.confirmDeleteDialogListener(e, getChildTableLoa(), "LoaMainView1");
        ADFUtils.invokeEL("#{bindings.Commit.execute}");
    }

    public void setChildTableLoa(RichTable childTableLoa) {
        this.childTableLoa = childTableLoa;
    }

    public RichTable getChildTableLoa() {
        return childTableLoa;
    }

    // Delete operations authority level
    public void confirmDeleteAuthLvlDialogListener (DialogEvent e) {
        BackingUtil.confirmDeleteDialogListener(e, getChildTableAuthLvl(), "LoaAuthView1");
        ADFUtils.invokeEL("#{bindings.Commit.execute}");
    }

    public void setChildTableAuthLvl(RichTable childTableAuthLvl) {
        this.childTableAuthLvl = childTableAuthLvl;
    }

    public RichTable getChildTableAuthLvl() {
        return childTableAuthLvl;
    }
    
    // Delete operations approver
    public void confirmDeleteLoaAppvrDialogListener (DialogEvent e) {
        BackingUtil.confirmDeleteDialogListener(e, getChildTableLoaAppvr(), "LoaAprvrView1");
        ADFUtils.invokeEL("#{bindings.Commit.execute}");
    }

    public void setChildTableLoaAppvr(RichTable childTableLoaAppvr) {
        this.childTableLoaAppvr = childTableLoaAppvr;
    }

    public RichTable getChildTableLoaAppvr() {
        return childTableLoaAppvr;
    }
        
    // Shuttle assign Finance PT operation
    public void setSelectedMenuItems(List selectedMenuItems) {
        this.selectedMenuItems = selectedMenuItems;
    }

    public List getSelectedMenuItems() {

        if (selectedMenuItems == null || refreshSelectedList) {
            selectedMenuItems =
                    attributeListForIterator("LoaAprvrPtView1Iterator",
                                             "KodePt");
        }
        return selectedMenuItems;
    }

    public void setAllMenuItems(List allMenuItems) {
        this.allMenuItems = allMenuItems;
    }

    public List getAllMenuItems() {
        if (allMenuItems == null) {
            allMenuItems =
                    selectItemsForIterator("ListPtView1Iterator", "KdMaster", "Descr");
        }
        return allMenuItems;
    }

    public String processShuttle() {
        BindingContext bctx = BindingContext.getCurrent();
        DCBindingContainer binding =
            (DCBindingContainer)bctx.getCurrentBindingsEntry();
        DCIteratorBinding iter =
            (DCIteratorBinding)binding.get("LoaAprvrPtView1Iterator");

        //Removing all rows
        for (Row r : iter.getAllRowsInRange()) {
            r.remove();
        }

        if (this.getSelectedMenuItems().size() > 0) {
            for (int i = 0; i < getSelectedMenuItems().size(); i++) {

                Row row = iter.getRowSetIterator().createRow();

                row.setNewRowState(Row.STATUS_INITIALIZED);
                row.setAttribute("KodePt", getSelectedMenuItems().get(i));

                iter.getRowSetIterator().insertRow(row);
                iter.setCurrentRowWithKey(row.getKey().toStringFormat(true));
            }
        }
        String ok = doCommit();
        return null;
    }
    
    // Shuttle operation Vendor
    public void setSelectedVndMenuItems(List selectedVndMenuItems) {
        this.selectedVndMenuItems = selectedVndMenuItems;
    }

    public List getSelectedVndMenuItems() {

        if (selectedVndMenuItems == null || refreshVndSelectedList) {
            selectedVndMenuItems =
                    attributeListForIterator("LoaAprvrPtView1Iterator",
                                             "KodePt");
        }
        return selectedVndMenuItems;
    }

    public void setAllVndMenuItems(List allVndMenuItems) {
        this.allVndMenuItems = allVndMenuItems;
    }

    public List getAllVndMenuItems() {
        if (allVndMenuItems == null) {
            allVndMenuItems =
                    selectItemsForIterator("ListVendorView1Iterator", "KdMaster", "Descr");
        }
        return allVndMenuItems;
    }

    public String processVndShuttle() {
        BindingContext bctx = BindingContext.getCurrent();
        DCBindingContainer binding =
            (DCBindingContainer)bctx.getCurrentBindingsEntry();
        DCIteratorBinding iter =
            (DCIteratorBinding)binding.get("LoaAprvrPtView1Iterator");

        //Removing all rows
        for (Row r : iter.getAllRowsInRange()) {
            r.remove();
        }

        if (this.getSelectedVndMenuItems().size() > 0) {
            for (int i = 0; i < getSelectedVndMenuItems().size(); i++) {

                Row row = iter.getRowSetIterator().createRow();

                row.setNewRowState(Row.STATUS_INITIALIZED);
                row.setAttribute("KodePt", getSelectedVndMenuItems().get(i));

                iter.getRowSetIterator().insertRow(row);
                iter.setCurrentRowWithKey(row.getKey().toStringFormat(true));
            }
        }
        String ok = doCommit();
        return null;
    }

    // Shuttle Operation common     
    public static List attributeListForIterator(String iteratorName,
                                                String valueAttrName) {
        BindingContext bc = BindingContext.getCurrent();
        DCBindingContainer binding =
            (DCBindingContainer)bc.getCurrentBindingsEntry();
        DCIteratorBinding iter = binding.findIteratorBinding(iteratorName);
        List attributeList = new ArrayList();
        for (Row r : iter.getAllRowsInRange()) {
            attributeList.add(r.getAttribute(valueAttrName));
        }
        return attributeList;
    }
    
    public static List<SelectItem> selectItemsForIterator(String iteratorName,
                                                          String valueAttrName,
                                                          String displayAttrName) {
        BindingContext bc = BindingContext.getCurrent();
        DCBindingContainer binding =
            (DCBindingContainer)bc.getCurrentBindingsEntry();
        DCIteratorBinding iter = binding.findIteratorBinding(iteratorName);
        List<SelectItem> selectItems = new ArrayList<SelectItem>();
        for (Row r : iter.getAllRowsInRange()) {
            selectItems.add(new SelectItem(r.getAttribute(valueAttrName),
                                           (String)r.getAttribute(displayAttrName)));
        }
        return selectItems;
    }
    
    public String doCommit() {
            BindingContainer bindings = getBindings();
            oracle.binding.OperationBinding operationBinding =
                bindings.getOperationBinding("Commit");
            Object result = operationBinding.execute();
            if (!operationBinding.getErrors().isEmpty()) {
                return null;
            }
            return null;
        }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
}
