package app.mkp.model.view.admin;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Oct 16 09:44:45 ICT 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class UserDataViewImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public UserDataViewImpl() {
    }

    /**
     * Returns the bind variable value for usrName.
     * @return bind variable value for usrName
     */
    public String getusrName() {
        return (String)getNamedWhereClauseParam("usrName");
    }

    /**
     * Sets <code>value</code> for bind variable usrName.
     * @param value value to bind as usrName
     */
    public void setusrName(String value) {
        setNamedWhereClauseParam("usrName", value);
    }
}