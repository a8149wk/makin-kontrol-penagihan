package app.mkp.backing;

import app.mkp.adfextensions.ADFUtils;

import app.mkp.model.TandaTerimaFakturAMImpl;

import app.mkp.model.view.ttf.createnew.MknTtfKontrakPlafonValidationImpl;
import app.mkp.model.view.ttf.createnew.MknTtfKontrakPlafonValidationRowImpl;
import app.mkp.model.view.ttf.createnew.MknTtfValidationViewImpl;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.jbo.domain.Number;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;


public class CheckAndValidationBean {

    private RichPopup confirmInvDuplicatePopup;
    private RichDialog invoiceDuplicateDialog;
    private RichPopup confirmKontrakPlafonPopup;
    private RichDialog kontrakPlafonDialog;
    private final String VALIDATION_PASS = "PASS";

    public CheckAndValidationBean() {
    }

    // action listener
    public String validationTtfGlobal() {
        if (checkDuplicateInvoice() == null) {
            showPopup(confirmInvDuplicatePopup, null);
            return null;
        } else if (checkKontrakPlafon() == null) {
            showPopup(confirmKontrakPlafonPopup, null);
            return null;
        }  else {
            return "addEditTtf";
        }
    }

    public String checkDuplicateInvoice() {

        String invoiceNo;
        invoiceNo =
                ADFContext.getCurrent().getPageFlowScope().get("invNo").toString();

        TandaTerimaFakturAMImpl ttfAM =
            (TandaTerimaFakturAMImpl)ADFUtils.getApplicationModuleForDataControl("TandaTerimaFakturAMDataControl");

        MknTtfValidationViewImpl ttfValidationView;
        ttfValidationView = ttfAM.getMknTtfValidationView1();
        ttfValidationView.setNamedWhereClauseParam("invNo", invoiceNo);
        ttfValidationView.executeQuery();

        if (ttfValidationView.hasNext()) {
            return null;
        } else {
            return VALIDATION_PASS;
        }
    }

    public String checkKontrakPlafon() {

        String invoiceNo;
        invoiceNo =
                ADFContext.getCurrent().getPageFlowScope().get("invNo").toString();

        TandaTerimaFakturAMImpl ttfAM =
            (TandaTerimaFakturAMImpl)ADFUtils.getApplicationModuleForDataControl("TandaTerimaFakturAMDataControl");

        MknTtfKontrakPlafonValidationImpl ttfKontrakPlafonValidation;
        ttfKontrakPlafonValidation = ttfAM.getMknTtfKontrakPlafonValidation1();
        ttfKontrakPlafonValidation.setNamedWhereClauseParam("noInv",
                                                            invoiceNo);
        ttfKontrakPlafonValidation.executeQuery();

        if (ttfKontrakPlafonValidation.hasNext()) {
            MknTtfKontrakPlafonValidationRowImpl mknTtfKontrakPlafonValidationRow =
                (MknTtfKontrakPlafonValidationRowImpl)ttfKontrakPlafonValidation.next();

            Number nilaiKontrak =
                mknTtfKontrakPlafonValidationRow.getNilaiKontrak();
            Number totalNilaiInvoice =
                mknTtfKontrakPlafonValidationRow.getSumNilInv();

            if (nilaiKontrak.compareTo(totalNilaiInvoice) < 0) {
                return null;
            } else {
                return VALIDATION_PASS;
            }
        } else {
            return VALIDATION_PASS;
        }
    }

    //dialogListener
    public void handleConfirmInvDuplicateDialog(DialogEvent ev) {
        if (ev.getOutcome().equals(DialogEvent.Outcome.yes)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getApplication().getNavigationHandler().handleNavigation(context,
                                                                             null,
                                                                             "addEditTtf");
        }
    }
    
    public void handleConfirmKontrakPlafonDialog(DialogEvent ev) {
        if (ev.getOutcome().equals(DialogEvent.Outcome.yes)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getApplication().getNavigationHandler().handleNavigation(context,
                                                                             null,
                                                                             "addEditTtf");
        }
    }

    public static void showPopup(RichPopup popup, UIComponent component) {
        FacesContext context = FacesContext.getCurrentInstance();
        String alignId =
            (component == null) ? null : component.getClientId(context);
        StringBuilder script = new StringBuilder();
        script.append("var popup = AdfPage.PAGE.findComponent('").append(popup.getClientId(context)).append("'); ").append("if (!popup.isPopupVisible()) { ").append("var hints = {}; ");
        if (alignId != null) {
            script.append("hints[AdfRichPopup.HINT_ALIGN_ID] = '").append(alignId).append("'; ").append("hints[AdfRichPopup.HINT_ALIGN] = AdfRichPopup.ALIGN_AFTER_START; ");
        }
        script.append("popup.show(hints);}");
        ExtendedRenderKitService erks =
            Service.getService(context.getRenderKit(),
                               ExtendedRenderKitService.class);
        erks.addScript(context, script.toString());
    }

    public void setConfirmInvDuplicatePopup(RichPopup confirmInvDuplicatePopup) {
        this.confirmInvDuplicatePopup = confirmInvDuplicatePopup;
    }

    public RichPopup getConfirmInvDuplicatePopup() {
        return confirmInvDuplicatePopup;
    }

    public void setInvoiceDuplicateDialog(RichDialog invoiceDuplicateDialog) {
        this.invoiceDuplicateDialog = invoiceDuplicateDialog;
    }

    public RichDialog getInvoiceDuplicateDialog() {
        return invoiceDuplicateDialog;
    }

    public void setConfirmKontrakPlafonPopup(RichPopup confirmKontrakPlafonPopup) {
        this.confirmKontrakPlafonPopup = confirmKontrakPlafonPopup;
    }

    public RichPopup getConfirmKontrakPlafonPopup() {
        return confirmKontrakPlafonPopup;
    }

    public void setKontrakPlafonDialog(RichDialog kontrakPlafonDialog) {
        this.kontrakPlafonDialog = kontrakPlafonDialog;
    }

    public RichDialog getKontrakPlafonDialog() {
        return kontrakPlafonDialog;
    }
}
