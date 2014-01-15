package app.mkp.backing.lov;

import app.mkp.adfextensions.ADFUtils;
import app.mkp.model.TandaTerimaFakturAMImpl;

import app.mkp.model.view.ttf.linkdoc.MknDokLinkViewImpl;

import app.mkp.model.view.ttf.linkdoc.MknDokLinkViewRowImpl;

import java.util.Map;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;
import oracle.adf.view.rich.context.AdfFacesContext;

import org.apache.myfaces.trinidad.event.ReturnEvent;

public class BrowseDocPoImKontrakBean {

    private RichPanelCollection addedDocPanColl;

    public BrowseDocPoImKontrakBean() {
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
                
                MknDokLinkViewImpl dokLinkView =
                    (MknDokLinkViewImpl)ttfAM.getMknDokLinkView1();
                
                MknDokLinkViewRowImpl dokLinkRow =
                    (MknDokLinkViewRowImpl)dokLinkView.createRow();
                dokLinkRow.setLinkDokDid(Integer.valueOf(docId.toString()));
                dokLinkView.insertRow(dokLinkRow);                

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

}
