package app.mkp.model.view.ttf.linkdoc;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Nov 19 14:09:45 ICT 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MknDokLinkViewImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public MknDokLinkViewImpl() {
    }


    /**
     * Returns the variable value for dId.
     * @return variable value for dId
     */
    public String getdId() {
        return (String)ensureVariableManager().getVariableValue("dId");
    }

    /**
     * Sets <code>value</code> for variable dId.
     * @param value value to bind as dId
     */
    public void setdId(String value) {
        ensureVariableManager().setVariableValue("dId", value);
    }
}