package app.mkp.backing.lov;

import java.util.Map;

import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.jbo.uicli.binding.JUCtrlHierBinding;

import org.apache.myfaces.trinidad.model.CollectionModel;

public class DocumentLovBean {
    private RichTable documentTable;
    private DCIteratorBinding tableIterator;

    public DocumentLovBean() {
        super();
    }

    public String onValueSelect() {
        //get collection model from table JSF component binding reference.
        //This also grants access to the DCIteratorBinding that is
        //synchronized with the selected table row
        CollectionModel model = (CollectionModel)documentTable.getValue();
        JUCtrlHierBinding tableBinding =
            (JUCtrlHierBinding)model.getWrappedData();

        //table synchronizes row selection with current binding row        
        tableIterator = tableBinding.getDCIteratorBinding();
        if (tableIterator.getCurrentRow() != null) {
            Object dIdValue =
                tableIterator.getCurrentRow().getAttribute("Did");
            //copy value into the pageFlowScope, which is returned in an task
            //flow param output
            /*
            System.out.println("----------------------------------------");            
            System.out.println("DOCUMENT LOV BEAN");
            System.out.println("DOC ID: |" + dIdValue + "|");
            System.out.println("----------------------------------------");
            */
            ADFContext adfCtx = ADFContext.getCurrent();
            Map pageFlowScope = adfCtx.getPageFlowScope();
            pageFlowScope.put("docId", dIdValue);
        }
        return "return";
    }

    public void setDocumentTable(RichTable documentTable) {
        this.documentTable = documentTable;
    }

    public RichTable getDocumentTable() {
        return documentTable;
    }
}
