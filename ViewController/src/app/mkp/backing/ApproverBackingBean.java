package app.mkp.backing;

import app.mkp.adfextensions.ADFUtils;

import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;
import oracle.jbo.Row;

public class ApproverBackingBean {

    // Shuttle operations PT (Anak Perusahaan)
    List selectedMenuItems;
    List allMenuItems;
    Boolean refreshSelectedList = false;
    
    // Shuttle operations Vendor
    List selectedVndMenuItems;
    List allVndMenuItems;
    Boolean refreshVndSelectedList = false;
    
    // Delete Operation
    private RichTable childTableBrAppvr;
    private RichTable childTableBrReference;
    
    public ApproverBackingBean() {
    }

    // Shuttle operation PT (Anak Perusahaan)
    public void setSelectedMenuItems(List selectedMenuItems) {
        this.selectedMenuItems = selectedMenuItems;
    }

    public List getSelectedMenuItems() {

        if (selectedMenuItems == null || refreshSelectedList) {
            selectedMenuItems =
                    attributeListForIterator("BrAppvrRefView1Iterator",
                                             "BrRefId");
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
            (DCIteratorBinding)binding.get("BrAppvrRefView1Iterator");

        //Removing all rows
        for (Row r : iter.getAllRowsInRange()) {
            r.remove();
        }

        if (this.getSelectedMenuItems().size() > 0) {
            for (int i = 0; i < getSelectedMenuItems().size(); i++) {

                Row row = iter.getRowSetIterator().createRow();

                row.setNewRowState(Row.STATUS_INITIALIZED);
                row.setAttribute("BrRefId", getSelectedMenuItems().get(i));

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
                    attributeListForIterator("BrAppvrRefView1Iterator",
                                             "BrRefId");
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
            (DCIteratorBinding)binding.get("BrAppvrRefView1Iterator");

        //Removing all rows
        for (Row r : iter.getAllRowsInRange()) {
            r.remove();
        }

        if (this.getSelectedVndMenuItems().size() > 0) {
            for (int i = 0; i < getSelectedVndMenuItems().size(); i++) {

                Row row = iter.getRowSetIterator().createRow();

                row.setNewRowState(Row.STATUS_INITIALIZED);
                row.setAttribute("BrRefId", getSelectedVndMenuItems().get(i));

                iter.getRowSetIterator().insertRow(row);
                iter.setCurrentRowWithKey(row.getKey().toStringFormat(true));
            }
        }
        String ok = doCommit();
        return null;
    }
    
    // Shuttle operation reference
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
    
    public String doCommit() {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding =
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
    
    // Delete Operations
    public void confirmDeleteBrApproverDialogListener (DialogEvent e) {
        BackingUtil.confirmDeleteDialogListener(e, getChildTableBrAppvr(), "BrAppvrView1");
        ADFUtils.invokeEL("#{bindings.Commit.execute}");
    }

    public void confirmDeleteBrReferenceDialogListener (DialogEvent e) {
        BackingUtil.confirmDeleteDialogListener(e, getChildTableBrReference(), "BrAppvrRefView1");
        ADFUtils.invokeEL("#{bindings.Commit.execute}");
    }

    public void setChildTableBrAppvr(RichTable childTableBrAppvr) {
        this.childTableBrAppvr = childTableBrAppvr;
    }

    public RichTable getChildTableBrAppvr() {
        return childTableBrAppvr;
    }

    public void setChildTableBrReference(RichTable childTableBrReference) {
        this.childTableBrReference = childTableBrReference;
    }

    public RichTable getChildTableBrReference() {
        return childTableBrReference;
    }
}
