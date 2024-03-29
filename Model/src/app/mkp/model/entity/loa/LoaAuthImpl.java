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
// ---    Mon Jun 17 12:53:29 ICT 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class LoaAuthImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        LoaId {
            public Object get(LoaAuthImpl obj) {
                return obj.getLoaId();
            }

            public void put(LoaAuthImpl obj, Object value) {
                obj.setLoaId((Number)value);
            }
        }
        ,
        LoaAuthId {
            public Object get(LoaAuthImpl obj) {
                return obj.getLoaAuthId();
            }

            public void put(LoaAuthImpl obj, Object value) {
                obj.setLoaAuthId((DBSequence)value);
            }
        }
        ,
        LoaName {
            public Object get(LoaAuthImpl obj) {
                return obj.getLoaName();
            }

            public void put(LoaAuthImpl obj, Object value) {
                obj.setLoaName((String)value);
            }
        }
        ,
        LoaTipe {
            public Object get(LoaAuthImpl obj) {
                return obj.getLoaTipe();
            }

            public void put(LoaAuthImpl obj, Object value) {
                obj.setLoaTipe((String)value);
            }
        }
        ,
        Descr {
            public Object get(LoaAuthImpl obj) {
                return obj.getDescr();
            }

            public void put(LoaAuthImpl obj, Object value) {
                obj.setDescr((String)value);
            }
        }
        ,
        Min1 {
            public Object get(LoaAuthImpl obj) {
                return obj.getMin1();
            }

            public void put(LoaAuthImpl obj, Object value) {
                obj.setMin1((Number)value);
            }
        }
        ,
        Max1 {
            public Object get(LoaAuthImpl obj) {
                return obj.getMax1();
            }

            public void put(LoaAuthImpl obj, Object value) {
                obj.setMax1((Number)value);
            }
        }
        ,
        Kurs {
            public Object get(LoaAuthImpl obj) {
                return obj.getKurs();
            }

            public void put(LoaAuthImpl obj, Object value) {
                obj.setKurs((String)value);
            }
        }
        ,
        LoaMain {
            public Object get(LoaAuthImpl obj) {
                return obj.getLoaMain();
            }

            public void put(LoaAuthImpl obj, Object value) {
                obj.setLoaMain((LoaMainImpl)value);
            }
        }
        ,
        LoaAprvr {
            public Object get(LoaAuthImpl obj) {
                return obj.getLoaAprvr();
            }

            public void put(LoaAuthImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(LoaAuthImpl object);

        public abstract void put(LoaAuthImpl object, Object value);

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

    public static final int LOAID = AttributesEnum.LoaId.index();
    public static final int LOAAUTHID = AttributesEnum.LoaAuthId.index();
    public static final int LOANAME = AttributesEnum.LoaName.index();
    public static final int LOATIPE = AttributesEnum.LoaTipe.index();
    public static final int DESCR = AttributesEnum.Descr.index();
    public static final int MIN1 = AttributesEnum.Min1.index();
    public static final int MAX1 = AttributesEnum.Max1.index();
    public static final int KURS = AttributesEnum.Kurs.index();
    public static final int LOAMAIN = AttributesEnum.LoaMain.index();
    public static final int LOAAPRVR = AttributesEnum.LoaAprvr.index();

    /**
     * This is the default constructor (do not remove).
     */
    public LoaAuthImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("app.mkp.model.entity.loa.LoaAuth");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for LoaId, using the alias name LoaId.
     * @return the LoaId
     */
    public Number getLoaId() {
        return (Number)getAttributeInternal(LOAID);
    }

    /**
     * Sets <code>value</code> as the attribute value for LoaId.
     * @param value value to set the LoaId
     */
    public void setLoaId(Number value) {
        setAttributeInternal(LOAID, value);
    }

    /**
     * Gets the attribute value for LoaAuthId, using the alias name LoaAuthId.
     * @return the LoaAuthId
     */
    public DBSequence getLoaAuthId() {
        return (DBSequence)getAttributeInternal(LOAAUTHID);
    }

    /**
     * Sets <code>value</code> as the attribute value for LoaAuthId.
     * @param value value to set the LoaAuthId
     */
    public void setLoaAuthId(DBSequence value) {
        setAttributeInternal(LOAAUTHID, value);
    }

    /**
     * Gets the attribute value for LoaName, using the alias name LoaName.
     * @return the LoaName
     */
    public String getLoaName() {
        return (String)getAttributeInternal(LOANAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for LoaName.
     * @param value value to set the LoaName
     */
    public void setLoaName(String value) {
        setAttributeInternal(LOANAME, value);
    }

    /**
     * Gets the attribute value for LoaTipe, using the alias name LoaTipe.
     * @return the LoaTipe
     */
    public String getLoaTipe() {
        return (String)getAttributeInternal(LOATIPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for LoaTipe.
     * @param value value to set the LoaTipe
     */
    public void setLoaTipe(String value) {
        setAttributeInternal(LOATIPE, value);
    }

    /**
     * Gets the attribute value for Descr, using the alias name Descr.
     * @return the Descr
     */
    public String getDescr() {
        return (String)getAttributeInternal(DESCR);
    }

    /**
     * Sets <code>value</code> as the attribute value for Descr.
     * @param value value to set the Descr
     */
    public void setDescr(String value) {
        setAttributeInternal(DESCR, value);
    }

    /**
     * Gets the attribute value for Min1, using the alias name Min1.
     * @return the Min1
     */
    public Number getMin1() {
        return (Number)getAttributeInternal(MIN1);
    }

    /**
     * Sets <code>value</code> as the attribute value for Min1.
     * @param value value to set the Min1
     */
    public void setMin1(Number value) {
        setAttributeInternal(MIN1, value);
    }

    /**
     * Gets the attribute value for Max1, using the alias name Max1.
     * @return the Max1
     */
    public Number getMax1() {
        return (Number)getAttributeInternal(MAX1);
    }

    /**
     * Sets <code>value</code> as the attribute value for Max1.
     * @param value value to set the Max1
     */
    public void setMax1(Number value) {
        setAttributeInternal(MAX1, value);
    }

    /**
     * Gets the attribute value for Kurs, using the alias name Kurs.
     * @return the Kurs
     */
    public String getKurs() {
        return (String)getAttributeInternal(KURS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Kurs.
     * @param value value to set the Kurs
     */
    public void setKurs(String value) {
        setAttributeInternal(KURS, value);
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
     * @return the associated entity LoaMainImpl.
     */
    public LoaMainImpl getLoaMain() {
        return (LoaMainImpl)getAttributeInternal(LOAMAIN);
    }

    /**
     * Sets <code>value</code> as the associated entity LoaMainImpl.
     */
    public void setLoaMain(LoaMainImpl value) {
        setAttributeInternal(LOAMAIN, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getLoaAprvr() {
        return (RowIterator)getAttributeInternal(LOAAPRVR);
    }


    /**
     * @param loaId key constituent
     * @param loaAuthId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number loaId, DBSequence loaAuthId) {
        return new Key(new Object[]{loaId, loaAuthId});
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
     protected void create(AttributeList attributeList) {
             super.create(attributeList);
             SequenceImpl seq = new SequenceImpl("LOA_AUTH_SEQ", getDBTransaction());
             this.setLoaAuthId(new DBSequence(seq.getSequenceNumber()));
     }
}
