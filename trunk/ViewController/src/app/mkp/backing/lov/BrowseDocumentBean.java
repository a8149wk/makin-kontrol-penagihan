package app.mkp.backing.lov;

import app.mkp.adfextensions.ADFUtils;
import app.mkp.model.SecurityAMImpl;
import app.mkp.model.TandaTerimaFakturAMImpl;
import app.mkp.model.view.ttf.createnew.MknTtfAddedDocViewImpl;
import app.mkp.model.view.ttf.createnew.MknTtfAddedDocViewRowImpl;

import java.util.Map;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.domain.Number;

import org.apache.myfaces.trinidad.event.ReturnEvent;

public class BrowseDocumentBean {

    private RichPanelCollection addedDocPanColl;
    private RichPanelCollection addedDocPanCollNewTtf;
    private RichPanelCollection addedDocPanCollMyTtf;

    public BrowseDocumentBean() {
    }

    public void onDialogReturn(ReturnEvent returnEvent) {
        ADFContext adfCtx = ADFContext.getCurrent(); 
        Map pageFlowScope = adfCtx.getPageFlowScope(); 
        //only update the field if the LOV select option was used, 
        //ignore for cancel 
        Object cancelFlag = pageFlowScope.get("submitOrCancelFlag"); 
        if(cancelFlag!=null){ 
            if (((String)cancelFlag).equalsIgnoreCase("submit")) { 
                //Object docId = returnEvent.getReturnValue(); 
                Object docId = pageFlowScope.get("docId");
                /*
                System.out.println("----------------------------------------");            
                System.out.println("BROWSE DOC BEAN");
                System.out.println("DOC ID: |" + docId + "|");
                System.out.println("----------------------------------------");
                */
                TandaTerimaFakturAMImpl ttfAM =
                    (TandaTerimaFakturAMImpl)ADFUtils.getApplicationModuleForDataControl("TandaTerimaFakturAMDataControl");
                
                MknTtfAddedDocViewImpl addedDocView =
                    (MknTtfAddedDocViewImpl)ttfAM.getMknTtfAddedDocView1();
                
                MknTtfAddedDocViewRowImpl addedDocRow =
                    (MknTtfAddedDocViewRowImpl)addedDocView.createRow();
                addedDocRow.setDid((oracle.jbo.domain.Number)docId);
                addedDocView.insertRow(addedDocRow);                

                AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance(); 
                adfFacesContext.addPartialTarget(addedDocPanColl); 
            }
        }
    }

    public void setAddedDocPanColl(RichPanelCollection addedDocPanColl) {
        this.addedDocPanColl = addedDocPanColl;
    }

    public RichPanelCollection getAddedDocPanColl() {
        return addedDocPanColl;
    }

    public void onDialogReturnNewTtf(ReturnEvent returnEvent) {
        ADFContext adfCtx = ADFContext.getCurrent(); 
        Map pageFlowScope = adfCtx.getPageFlowScope(); 
        //only update the field if the LOV select option was used, 
        //ignore for cancel 
        Object cancelFlag = pageFlowScope.get("submitOrCancelFlag"); 
        if(cancelFlag!=null){ 
            if (((String)cancelFlag).equalsIgnoreCase("submit")) { 
                //Object docId = returnEvent.getReturnValue(); 
                Object docId = pageFlowScope.get("docId");
                /*
                System.out.println("----------------------------------------");            
                System.out.println("BROWSE DOC BEAN");
                System.out.println("DOC ID: |" + docId + "|");
                System.out.println("----------------------------------------");
                */
                TandaTerimaFakturAMImpl ttfAM =
                    (TandaTerimaFakturAMImpl)ADFUtils.getApplicationModuleForDataControl("TandaTerimaFakturAMDataControl");
                
                MknTtfAddedDocViewImpl addedDocView =
                    (MknTtfAddedDocViewImpl)ttfAM.getMknTtfAddedDocView2();
                
                MknTtfAddedDocViewRowImpl addedDocRow =
                    (MknTtfAddedDocViewRowImpl)addedDocView.createRow();
                addedDocRow.setDid((oracle.jbo.domain.Number)docId);
                addedDocView.insertRow(addedDocRow);                

                AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance(); 
                adfFacesContext.addPartialTarget(addedDocPanCollNewTtf); 
            }
        }
    }

    public void setAddedDocPanCollNewTtf(RichPanelCollection addedDocPanCollNewTtf) {
        this.addedDocPanCollNewTtf = addedDocPanCollNewTtf;
    }

    public RichPanelCollection getAddedDocPanCollNewTtf() {
        return addedDocPanCollNewTtf;
    }

    public void onDialogReturnMyTtf(ReturnEvent returnEvent) {
        ADFContext adfCtx = ADFContext.getCurrent(); 
        Map pageFlowScope = adfCtx.getPageFlowScope(); 
        //only update the field if the LOV select option was used, 
        //ignore for cancel 
        Object cancelFlag = pageFlowScope.get("submitOrCancelFlag"); 
        if(cancelFlag!=null){ 
            if (((String)cancelFlag).equalsIgnoreCase("submit")) { 
                //Object docId = returnEvent.getReturnValue(); 
                Object docId = pageFlowScope.get("docId");
                /*
                System.out.println("----------------------------------------");            
                System.out.println("BROWSE DOC BEAN");
                System.out.println("DOC ID: |" + docId + "|");
                System.out.println("----------------------------------------");
                */
                TandaTerimaFakturAMImpl ttfAM =
                    (TandaTerimaFakturAMImpl)ADFUtils.getApplicationModuleForDataControl("TandaTerimaFakturAMDataControl");
                
                MknTtfAddedDocViewImpl addedDocView = ttfAM.getMknTtfAddedDocView3();
                
                MknTtfAddedDocViewRowImpl addedDocRow =
                    (MknTtfAddedDocViewRowImpl)addedDocView.createRow();
                addedDocRow.setDid((oracle.jbo.domain.Number)docId);
                addedDocView.insertRow(addedDocRow);                

                AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance(); 
                adfFacesContext.addPartialTarget(addedDocPanCollMyTtf); 
            }
        }
    }

    public void setAddedDocPanCollMyTtf(RichPanelCollection addedDocPanCollMyTtf) {
        this.addedDocPanCollMyTtf = addedDocPanCollMyTtf;
    }

    public RichPanelCollection getAddedDocPanCollMyTtf() {
        return addedDocPanCollMyTtf;
    }
}
