package app.mkp.model.common;

import oracle.jbo.ApplicationModule;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Oct 11 13:46:01 ICT 2013
// ---------------------------------------------------------------------
public interface TandaTerimaFakturAM extends ApplicationModule {
    void generateExistingDoc(String dId);

    void generateSelfDoc(String dId, String tipeDok);

    void generateAttachDoc(String dId);
}
