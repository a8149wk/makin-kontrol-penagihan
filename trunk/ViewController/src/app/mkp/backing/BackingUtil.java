package app.mkp.backing;

import java.util.ArrayList;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierBinding;

import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import org.apache.myfaces.trinidad.model.CollectionModel;
import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class BackingUtil {
  public BackingUtil() {
  }

  public static void confirmDeleteDialogListener(DialogEvent e,
                                                        RichTable _table,
                                                        String _bindingName) {

    DialogEvent.Outcome result = e.getOutcome();

    if (result == DialogEvent.Outcome.ok ||
        result == DialogEvent.Outcome.yes) {
      deleteOnTable(_bindingName, _table);
    }
  }
  
  /**
   * Method to perform single or multiple record delete on a table
   * that contains a binding
   * @param bName, the name of the bind Variable
   * @param myTable, the RichTable from which we remove the records
   */
  public static void deleteOnTable(String bName,RichTable myTable) {
      FacesContext fctx = FacesContext.getCurrentInstance();
      Application application = fctx.getApplication();
      ELContext elctx = fctx.getELContext();
      ExpressionFactory exprfactory  = application.getExpressionFactory();
      
      ValueExpression valueExpression =
      exprfactory.createValueExpression(elctx,"#{bindings}",Object.class);
      
      DCBindingContainer dcbinding =
           (DCBindingContainer) valueExpression.getValue(elctx);
          
      FacesCtrlHierBinding treeRootNode =
           (FacesCtrlHierBinding) dcbinding.get(bName);        
          
      RowKeySet rowKeySet = (RowKeySet) myTable.getSelectedRowKeys();
      CollectionModel cm = treeRootNode.getCollectionModel();    
      for (Object facesTreeRowKey : rowKeySet) {
          cm.setRowKey(facesTreeRowKey);
          JUCtrlHierNodeBinding rowData = (JUCtrlHierNodeBinding) cm.getRowData();
          rowData.getRow().remove();              
      } 
  }
  
  public static void confirmDeleteCommitDialogListener(DialogEvent e,
                                                        RichTable _table,
                                                        String _bindingName) {

    DialogEvent.Outcome result = e.getOutcome();

    if (result == DialogEvent.Outcome.ok ||
        result == DialogEvent.Outcome.yes) {
      deleteOnTableCommit(_bindingName, _table);
    }
  }
  
  /**
   * Method to perform single or multiple record delete on a table
   * that contains a binding and commit the transaction
   * @param bName, the name of the bind Variable
   * @param myTable, the RichTable from which we remove the records
   */
  public static void deleteOnTableCommit(String bName,RichTable myTable ) {
      FacesContext fctx = FacesContext.getCurrentInstance();
      Application application = fctx.getApplication();
      ELContext elctx = fctx.getELContext();
      ExpressionFactory exprfactory  = application.getExpressionFactory();
      
      ValueExpression valueExpression =
      exprfactory.createValueExpression(elctx,"#{bindings}",Object.class);
      
      DCBindingContainer dcbinding =
           (DCBindingContainer) valueExpression.getValue(elctx);
          
      FacesCtrlHierBinding treeRootNode =
           (FacesCtrlHierBinding) dcbinding.get(bName);        
          
      RowKeySet rowKeySet = (RowKeySet) myTable.getSelectedRowKeys();
      CollectionModel cm = treeRootNode.getCollectionModel();    
      for (Object facesTreeRowKey : rowKeySet) {
          cm.setRowKey(facesTreeRowKey);
          JUCtrlHierNodeBinding rowData = (JUCtrlHierNodeBinding) cm.getRowData();
          rowData.getRow().remove();              
      } 
      dcbinding.getDataControl().getApplicationModule().getTransaction().commit();
  }
  
  public static void commitApplicationModule() {
      FacesContext fctx = FacesContext.getCurrentInstance();
      Application application = fctx.getApplication();
      ELContext elctx = fctx.getELContext();
      ExpressionFactory exprfactory  = application.getExpressionFactory();
      
      ValueExpression valueExpression =
      exprfactory.createValueExpression(elctx,"#{bindings}",Object.class);
      
      DCBindingContainer dcbinding =
           (DCBindingContainer) valueExpression.getValue(elctx);
      
      dcbinding.getDataControl().getApplicationModule().getTransaction().commit();
  }
  
  public static void showPopupActionListener(String popupId,ActionEvent event) 
   {
     FacesContext context = FacesContext.getCurrentInstance();
     UIComponent source = (UIComponent) event.getSource();
     String alignId = source.getClientId(context);
       
     StringBuilder script = new StringBuilder();
     script.append("var popup = AdfPage.PAGE.findComponent('").append(popupId).append("'); ")
           .append("if (!popup.isPopupVisible()) { ")
           .append("var hints = {}; ")
           .append("hints[AdfRichPopup.HINT_ALIGN_ID] = '").append(alignId).append("'; ") 
           .append("hints[AdfRichPopup.HINT_ALIGN] = AdfRichPopup.ALIGN_AFTER_START; ")
           .append("popup.show(hints);}");
       ExtendedRenderKitService erks = 
            Service.getService(context.getRenderKit(), ExtendedRenderKitService.class);
          erks.addScript(context, script.toString());
   }

    public static void putErrorMsg(String errorMessage) {
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, null);
        FacesContext fctx = FacesContext.getCurrentInstance();
        fctx.addMessage(null, fm);
    }        
}
