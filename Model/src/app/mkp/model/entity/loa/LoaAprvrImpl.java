package app.mkp.model.entity.loa;

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
// ---    Tue Jun 18 09:24:34 ICT 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class LoaAprvrImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        LoaAuthId {
            public Object get(LoaAprvrImpl obj) {
                return obj.getLoaAuthId();
            }

            public void put(LoaAprvrImpl obj, Object value) {
                obj.setLoaAuthId((Number)value);
            }
        }
        ,
        LoaAprvrId {
            public Object get(LoaAprvrImpl obj) {
                return obj.getLoaAprvrId();
            }

            public void put(LoaAprvrImpl obj, Object value) {
                obj.setLoaAprvrId((DBSequence)value);
            }
        }
        ,
        Approver {
            public Object get(LoaAprvrImpl obj) {
                return obj.getApprover();
            }

            public void put(LoaAprvrImpl obj, Object value) {
                obj.setApprover((String)value);
            }
        }
        ,
        PriorityLvl {
            public Object get(LoaAprvrImpl obj) {
                return obj.getPriorityLvl();
            }

            public void put(LoaAprvrImpl obj, Object value) {
                obj.setPriorityLvl((Number)value);
            }
        }
        ,
        LoaAuth {
            public Object get(LoaAprvrImpl obj) {
                return obj.getLoaAuth();
            }

            public void put(LoaAprvrImpl obj, Object value) {
                obj.setLoaAuth((LoaAuthImpl)value);
            }
        }
        ,
        LoaAprvrPt {
            public Object get(LoaAprvrImpl obj) {
                return obj.getLoaAprvrPt();
            }

            public void put(LoaAprvrImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(LoaAprvrImpl object);

        public abstract void put(LoaAprvrImpl object, Object value);

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

    public static final int LOAAUTHID = AttributesEnum.LoaAuthId.index();
    public static final int LOAAPRVRID = AttributesEnum.LoaAprvrId.index();
    public static final int APPROVER = AttributesEnum.Approver.index();
    public static final int PRIORITYLVL = AttributesEnum.PriorityLvl.index();
    public static final int LOAAUTH = AttributesEnum.LoaAuth.index();
    public static final int LOAAPRVRPT = AttributesEnum.LoaAprvrPt.index();

    /**
     * This is the default constructor (do not remove).
     */
    public LoaAprvrImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("app.mkp.model.entity.loa.LoaAprvr");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for LoaAuthId, using the alias name LoaAuthId.
     * @return the LoaAuthId
     */
    public Number getLoaAuthId() {
        return (Number)getAttributeInternal(LOAAUTHID);
    }

    /**
     * Sets <code>value</code> as the attribute value for LoaAuthId.
     * @param value value to set the LoaAuthId
     */
    public void setLoaAuthId(Number value) {
        setAttributeInternal(LOAAUTHID, value);
    }

    /**
     * Gets the attribute value for LoaAprvrId, using the alias name LoaAprvrId.
     * @return the LoaAprvrId
     */
    public DBSequence getLoaAprvrId() {
        return (DBSequence)getAttributeInternal(LOAAPRVRID);
    }

    /**
     * Sets <code>value</code> as the attribute value for LoaAprvrId.
     * @param value value to set the LoaAprvrId
     */
    public void setLoaAprvrId(DBSequence value) {
        setAttributeInternal(LOAAPRVRID, value);
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
     * @return the associated entity LoaAuthImpl.
     */
    public LoaAuthImpl getLoaAuth() {
        return (LoaAuthImpl)getAttributeInternal(LOAAUTH);
    }

    /**
     * Sets <code>value</code> as the associated entity LoaAuthImpl.
     */
    public void setLoaAuth(LoaAuthImpl value) {
        setAttributeInternal(LOAAUTH, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getLoaAprvrPt() {
        return (RowIterator)getAttributeInternal(LOAAPRVRPT);
    }


    /**
     * @param loaAuthId key constituent
     * @param loaAprvrId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number loaAuthId,
                                       DBSequence loaAprvrId) {
        return new Key(new Object[]{loaAuthId, loaAprvrId});
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
     protected void create(AttributeList attributeList) {
             super.create(attributeList);
             SequenceImpl seq = new SequenceImpl("LOA_APRVR_SEQ", getDBTransaction());
             this.setLoaAprvrId(new DBSequence(seq.getSequenceNumber()));
     }
}
