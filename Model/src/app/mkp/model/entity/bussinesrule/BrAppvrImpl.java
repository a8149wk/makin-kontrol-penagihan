package app.mkp.model.entity.bussinesrule;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu May 30 10:29:46 ICT 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class BrAppvrImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        BrAppvrId {
            public Object get(BrAppvrImpl obj) {
                return obj.getBrAppvrId();
            }

            public void put(BrAppvrImpl obj, Object value) {
                obj.setBrAppvrId((DBSequence)value);
            }
        }
        ,
        BrId {
            public Object get(BrAppvrImpl obj) {
                return obj.getBrId();
            }

            public void put(BrAppvrImpl obj, Object value) {
                obj.setBrId((Number)value);
            }
        }
        ,
        Approver {
            public Object get(BrAppvrImpl obj) {
                return obj.getApprover();
            }

            public void put(BrAppvrImpl obj, Object value) {
                obj.setApprover((String)value);
            }
        }
        ,
        PriorityLvl {
            public Object get(BrAppvrImpl obj) {
                return obj.getPriorityLvl();
            }

            public void put(BrAppvrImpl obj, Object value) {
                obj.setPriorityLvl((Number)value);
            }
        }
        ,
        BrRef {
            public Object get(BrAppvrImpl obj) {
                return obj.getBrRef();
            }

            public void put(BrAppvrImpl obj, Object value) {
                obj.setBrRef((String)value);
            }
        }
        ,
        BrMain {
            public Object get(BrAppvrImpl obj) {
                return obj.getBrMain();
            }

            public void put(BrAppvrImpl obj, Object value) {
                obj.setBrMain((BrMainImpl)value);
            }
        }
        ,
        BrAppvrRef {
            public Object get(BrAppvrImpl obj) {
                return obj.getBrAppvrRef();
            }

            public void put(BrAppvrImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(BrAppvrImpl object);

        public abstract void put(BrAppvrImpl object, Object value);

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


    public static final int BRAPPVRID = AttributesEnum.BrAppvrId.index();
    public static final int BRID = AttributesEnum.BrId.index();
    public static final int APPROVER = AttributesEnum.Approver.index();
    public static final int PRIORITYLVL = AttributesEnum.PriorityLvl.index();
    public static final int BRREF = AttributesEnum.BrRef.index();
    public static final int BRMAIN = AttributesEnum.BrMain.index();
    public static final int BRAPPVRREF = AttributesEnum.BrAppvrRef.index();

    /**
     * This is the default constructor (do not remove).
     */
    public BrAppvrImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("app.mkp.model.entity.bussinesrule.BrAppvr");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for BrAppvrId, using the alias name BrAppvrId.
     * @return the BrAppvrId
     */
    public DBSequence getBrAppvrId() {
        return (DBSequence)getAttributeInternal(BRAPPVRID);
    }

    /**
     * Sets <code>value</code> as the attribute value for BrAppvrId.
     * @param value value to set the BrAppvrId
     */
    public void setBrAppvrId(DBSequence value) {
        setAttributeInternal(BRAPPVRID, value);
    }

    /**
     * Gets the attribute value for BrId, using the alias name BrId.
     * @return the BrId
     */
    public Number getBrId() {
        return (Number)getAttributeInternal(BRID);
    }

    /**
     * Sets <code>value</code> as the attribute value for BrId.
     * @param value value to set the BrId
     */
    public void setBrId(Number value) {
        setAttributeInternal(BRID, value);
    }

    /**
     * Gets the attribute value for Approver, using the alias name Approver.
     * @return the Approver
     */
    public String getApprover() {
        return (String)getAttributeInternal(APPROVER);
    }

    /**
     * Sets <code>value</code> as the attribute value for Approver.
     * @param value value to set the Approver
     */
    public void setApprover(String value) {
        setAttributeInternal(APPROVER, value);
    }

    /**
     * Gets the attribute value for PriorityLvl, using the alias name PriorityLvl.
     * @return the PriorityLvl
     */
    public Number getPriorityLvl() {
        return (Number)getAttributeInternal(PRIORITYLVL);
    }

    /**
     * Sets <code>value</code> as the attribute value for PriorityLvl.
     * @param value value to set the PriorityLvl
     */
    public void setPriorityLvl(Number value) {
        setAttributeInternal(PRIORITYLVL, value);
    }

    /**
     * Gets the attribute value for BrRef, using the alias name BrRef.
     * @return the BrRef
     */
    public String getBrRef() {
        return (String)getAttributeInternal(BRREF);
    }

    /**
     * Sets <code>value</code> as the attribute value for BrRef.
     * @param value value to set the BrRef
     */
    public void setBrRef(String value) {
        setAttributeInternal(BRREF, value);
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

    /**
     * @return the associated entity BrMainImpl.
     */
    public BrMainImpl getBrMain() {
        return (BrMainImpl)getAttributeInternal(BRMAIN);
    }

    /**
     * Sets <code>value</code> as the associated entity BrMainImpl.
     */
    public void setBrMain(BrMainImpl value) {
        setAttributeInternal(BRMAIN, value);
    }


    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getBrAppvrRef() {
        return (RowIterator)getAttributeInternal(BRAPPVRREF);
    }


    /**
     * @param brAppvrId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(DBSequence brAppvrId) {
        return new Key(new Object[]{brAppvrId});
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
     protected void create(AttributeList attributeList) {
             super.create(attributeList);
             SequenceImpl seq = new SequenceImpl("MAIL_TEMPLATE_SEQ", getDBTransaction());
             this.setBrAppvrId(new DBSequence(seq.getSequenceNumber()));
     }
}
