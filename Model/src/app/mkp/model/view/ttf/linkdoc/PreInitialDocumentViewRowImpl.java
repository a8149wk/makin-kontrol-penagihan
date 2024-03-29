package app.mkp.model.view.ttf.linkdoc;

import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Nov 19 02:47:53 ICT 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PreInitialDocumentViewRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Did {
            public Object get(PreInitialDocumentViewRowImpl obj) {
                return obj.getDid();
            }

            public void put(PreInitialDocumentViewRowImpl obj, Object value) {
                obj.setDid((Integer)value);
            }
        }
        ,
        IdDokumen {
            public Object get(PreInitialDocumentViewRowImpl obj) {
                return obj.getIdDokumen();
            }

            public void put(PreInitialDocumentViewRowImpl obj, Object value) {
                obj.setIdDokumen((String)value);
            }
        }
        ,
        TipeDok {
            public Object get(PreInitialDocumentViewRowImpl obj) {
                return obj.getTipeDok();
            }

            public void put(PreInitialDocumentViewRowImpl obj, Object value) {
                obj.setTipeDok((String)value);
            }
        }
        ,
        PihakTerkait {
            public Object get(PreInitialDocumentViewRowImpl obj) {
                return obj.getPihakTerkait();
            }

            public void put(PreInitialDocumentViewRowImpl obj, Object value) {
                obj.setPihakTerkait((String)value);
            }
        }
        ,
        DeptTerkait {
            public Object get(PreInitialDocumentViewRowImpl obj) {
                return obj.getDeptTerkait();
            }

            public void put(PreInitialDocumentViewRowImpl obj, Object value) {
                obj.setDeptTerkait((String)value);
            }
        }
        ,
        Tanggal {
            public Object get(PreInitialDocumentViewRowImpl obj) {
                return obj.getTanggal();
            }

            public void put(PreInitialDocumentViewRowImpl obj, Object value) {
                obj.setTanggal((Date)value);
            }
        }
        ,
        NumLink {
            public Object get(PreInitialDocumentViewRowImpl obj) {
                return obj.getNumLink();
            }

            public void put(PreInitialDocumentViewRowImpl obj, Object value) {
                obj.setNumLink((Long)value);
            }
        }
        ,
        MknDokRelView {
            public Object get(PreInitialDocumentViewRowImpl obj) {
                return obj.getMknDokRelView();
            }

            public void put(PreInitialDocumentViewRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        MknDokLinkView {
            public Object get(PreInitialDocumentViewRowImpl obj) {
                return obj.getMknDokLinkView();
            }

            public void put(PreInitialDocumentViewRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        LovDepartment1 {
            public Object get(PreInitialDocumentViewRowImpl obj) {
                return obj.getLovDepartment1();
            }

            public void put(PreInitialDocumentViewRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        LovSupplierVendor1 {
            public Object get(PreInitialDocumentViewRowImpl obj) {
                return obj.getLovSupplierVendor1();
            }

            public void put(PreInitialDocumentViewRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        LovTipeDokPoImKontrak1 {
            public Object get(PreInitialDocumentViewRowImpl obj) {
                return obj.getLovTipeDokPoImKontrak1();
            }

            public void put(PreInitialDocumentViewRowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(PreInitialDocumentViewRowImpl object);

        public abstract void put(PreInitialDocumentViewRowImpl object,
                                 Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int DID = AttributesEnum.Did.index();
    public static final int IDDOKUMEN = AttributesEnum.IdDokumen.index();
    public static final int TIPEDOK = AttributesEnum.TipeDok.index();
    public static final int PIHAKTERKAIT = AttributesEnum.PihakTerkait.index();
    public static final int DEPTTERKAIT = AttributesEnum.DeptTerkait.index();
    public static final int TANGGAL = AttributesEnum.Tanggal.index();
    public static final int NUMLINK = AttributesEnum.NumLink.index();
    public static final int MKNDOKRELVIEW = AttributesEnum.MknDokRelView.index();
    public static final int MKNDOKLINKVIEW = AttributesEnum.MknDokLinkView.index();
    public static final int LOVDEPARTMENT1 = AttributesEnum.LovDepartment1.index();
    public static final int LOVSUPPLIERVENDOR1 = AttributesEnum.LovSupplierVendor1.index();
    public static final int LOVTIPEDOKPOIMKONTRAK1 = AttributesEnum.LovTipeDokPoImKontrak1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PreInitialDocumentViewRowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute Did.
     * @return the Did
     */
    public Integer getDid() {
        return (Integer) getAttributeInternal(DID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Did.
     * @param value value to set the  Did
     */
    public void setDid(Integer value) {
        setAttributeInternal(DID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute IdDokumen.
     * @return the IdDokumen
     */
    public String getIdDokumen() {
        return (String) getAttributeInternal(IDDOKUMEN);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute IdDokumen.
     * @param value value to set the  IdDokumen
     */
    public void setIdDokumen(String value) {
        setAttributeInternal(IDDOKUMEN, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TipeDok.
     * @return the TipeDok
     */
    public String getTipeDok() {
        return (String) getAttributeInternal(TIPEDOK);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TipeDok.
     * @param value value to set the  TipeDok
     */
    public void setTipeDok(String value) {
        setAttributeInternal(TIPEDOK, value);
    }

    /**
     * Gets the attribute value for the calculated attribute PihakTerkait.
     * @return the PihakTerkait
     */
    public String getPihakTerkait() {
        return (String) getAttributeInternal(PIHAKTERKAIT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PihakTerkait.
     * @param value value to set the  PihakTerkait
     */
    public void setPihakTerkait(String value) {
        setAttributeInternal(PIHAKTERKAIT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute DeptTerkait.
     * @return the DeptTerkait
     */
    public String getDeptTerkait() {
        return (String) getAttributeInternal(DEPTTERKAIT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute DeptTerkait.
     * @param value value to set the  DeptTerkait
     */
    public void setDeptTerkait(String value) {
        setAttributeInternal(DEPTTERKAIT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Tanggal.
     * @return the Tanggal
     */
    public Date getTanggal() {
        return (Date) getAttributeInternal(TANGGAL);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Tanggal.
     * @param value value to set the  Tanggal
     */
    public void setTanggal(Date value) {
        setAttributeInternal(TANGGAL, value);
    }

    /**
     * Gets the attribute value for the calculated attribute NumLink.
     * @return the NumLink
     */
    public Long getNumLink() {
        return (Long) getAttributeInternal(NUMLINK);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute NumLink.
     * @param value value to set the  NumLink
     */
    public void setNumLink(Long value) {
        setAttributeInternal(NUMLINK, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link MknDokRelView.
     */
    public RowIterator getMknDokRelView() {
        return (RowIterator)getAttributeInternal(MKNDOKRELVIEW);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link MknDokLinkView.
     */
    public RowIterator getMknDokLinkView() {
        return (RowIterator)getAttributeInternal(MKNDOKLINKVIEW);
    }


    /**
     * Gets the view accessor <code>RowSet</code> LovDepartment1.
     */
    public RowSet getLovDepartment1() {
        return (RowSet)getAttributeInternal(LOVDEPARTMENT1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LovSupplierVendor1.
     */
    public RowSet getLovSupplierVendor1() {
        return (RowSet)getAttributeInternal(LOVSUPPLIERVENDOR1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LovTipeDokPoImKontrak1.
     */
    public RowSet getLovTipeDokPoImKontrak1() {
        return (RowSet)getAttributeInternal(LOVTIPEDOKPOIMKONTRAK1);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }
}
