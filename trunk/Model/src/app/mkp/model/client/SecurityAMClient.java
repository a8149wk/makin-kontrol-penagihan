package app.mkp.model.client;

import app.mkp.model.common.SecurityAM;

import java.util.Map;

import oracle.jbo.client.remote.ApplicationModuleImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Mar 06 12:28:57 ICT 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SecurityAMClient extends ApplicationModuleImpl implements SecurityAM {
    /**
     * This is the default constructor (do not remove).
     */
    public SecurityAMClient() {
    }

    public Map authenticateUser(String userLogin, String userPassword) {
        Object _ret =
            this.riInvokeExportedMethod(this,"authenticateUser",new String [] {"java.lang.String","java.lang.String"},new Object[] {userLogin, userPassword});
        return (Map)_ret;
    }
}