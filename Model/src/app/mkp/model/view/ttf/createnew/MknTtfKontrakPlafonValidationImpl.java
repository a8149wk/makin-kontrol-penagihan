package app.mkp.model.view.ttf.createnew;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Dec 19 09:22:39 ICT 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MknTtfKontrakPlafonValidationImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public MknTtfKontrakPlafonValidationImpl() {
    }

    /**
     * Returns the bind variable value for noInv.
     * @return bind variable value for noInv
     */
    public String getnoInv() {
        return (String)getNamedWhereClauseParam("noInv");
    }

    /**
     * Sets <code>value</code> for bind variable noInv.
     * @param value value to bind as noInv
     */
    public void setnoInv(String value) {
        setNamedWhereClauseParam("noInv", value);
    }
}
