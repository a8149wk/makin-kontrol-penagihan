package app.mkp.backing;

import java.util.ArrayList;

import oracle.adf.controller.TaskFlowId;
import java.util.List;

import javax.faces.model.SelectItem;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;

public class NotifikasiBackingBean {
    
    // Menu Accordion
    private String notifConfigTaskFlowId = "/WEB-INF/notif-config.xml#notif-config";
    // private String notifRecipientTaskFlowId = "/WEB-INF/notif-recipient.xml#notif-recipient";
    private String currentTF = "setting";
    
    // Process Shuttle
    //--------------------------------------------------------------------------
    /* Start of Standard Shuttle */    
    List selectedPosition;
    List allPosition;
    Boolean refreshSelectedList = false;
    /* End of Standard Shuttle */
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    /* Start of Shuttle with filter */
    
    
    /* End of Shuttle with filter */
    //--------------------------------------------------------------------------
    

    public NotifikasiBackingBean() {
    }
    
    // Menu Accordion
    public TaskFlowId getDynamicTaskFlowId() {
        /*
        if (this.getCurrentTF().equalsIgnoreCase("recipient"))
            return TaskFlowId.parse(notifRecipientTaskFlowId);
        else
        */
            return TaskFlowId.parse(notifConfigTaskFlowId);
    }

    public void setCurrentTF(String currentTF) {
        this.currentTF = currentTF;
    }

    public String getCurrentTF() {
        return currentTF;
    }
    
    // Process Shuttle Recipient
    //--------------------------------------------------------------------------
    /* Start of Standard Shuttle */
    
    public static List attributeListForIterator(String iteratorName,
                                                String valueAttrName) {
        BindingContext bc = BindingContext.getCurrent();
        DCBindingContainer binding =
            (DCBindingContainer)bc.getCurrentBindingsEntry();
        DCIteratorBinding iter = binding.findIteratorBinding(iteratorName);
        List attributeList = new ArrayList();
        for (Row r : iter.getAllRowsInRange()) {
            attributeList.add(r.getAttribute(valueAttrName).toString().trim());
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
            selectItems.add(new SelectItem(r.getAttribute(valueAttrName).toString().trim(),
                                           (String)r.getAttribute(displayAttrName)));
        }
        return selectItems;
    }

    public void refreshSelectedList() {
        refreshSelectedList = true;
    }
    
    public void setSelectedPosition(List selectedPosition) {
        this.selectedPosition = selectedPosition;
    }

    public List getSelectedPosition() {

        if (selectedPosition == null || refreshSelectedList) {
            selectedPosition =
                    attributeListForIterator("NotifikasiPositionView1Iterator",
                                             "UsrPosition");
        }
        return selectedPosition;
    }

    public void setAllPosition(List allPosition) {
        this.allPosition = allPosition;
    }

    public List getAllPosition() {
        if (allPosition == null) {
            allPosition =
                    selectItemsForIterator("PositionAllView1Iterator", "Positioncode", "FullPosition");
        }
        return allPosition;
    }

    public String processShuttle() {
        BindingContext bctx = BindingContext.getCurrent();
        DCBindingContainer binding =
            (DCBindingContainer)bctx.getCurrentBindingsEntry();
        DCIteratorBinding iter =
            (DCIteratorBinding)binding.get("NotifikasiPositionView1Iterator");

        //Removing all rows
        for (Row r : iter.getAllRowsInRange()) {
            r.remove();
        }

        if (this.getSelectedPosition().size() > 0) {
            for (int i = 0; i < getSelectedPosition().size(); i++) {

                Row row = iter.getRowSetIterator().createRow();  
                
                row.setNewRowState(Row.STATUS_INITIALIZED);
                row.setAttribute("NotifikasiId", this.getCurrentIdNotifikasi());
                row.setAttribute("UsrPosition", getSelectedPosition().get(i));

                iter.getRowSetIterator().insertRow(row);
                iter.setCurrentRowWithKey(row.getKey().toStringFormat(true));
            }
        }
        String ok;
        ok = doCommit();
        return null;
    }


    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public String doCommit() {
        BindingContainer bindings = getBindings();
        OperationBinding operationBinding =
            bindings.getOperationBinding("Commit");
        Object result;
        result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return null;
    }
    
    public Integer getCurrentIdNotifikasi() {
        BindingContext bctx = BindingContext.getCurrent();
        DCBindingContainer bindings =
            (DCBindingContainer)bctx.getCurrentBindingsEntry();
        AttributeBinding attr = (AttributeBinding)bindings.get("IdNotifikasi");
        Integer userName = Integer.valueOf(attr.getInputValue().toString());
        return userName;
    }
    
    /* End of Standard Shuttle */
    //--------------------------------------------------------------------------
    
    //--------------------------------------------------------------------------
    /* Start of Shuttle with filter */
    
    
    /* End of Shuttle with filter */
    //--------------------------------------------------------------------------
    
}