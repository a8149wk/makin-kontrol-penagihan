package app.mkp.model.entity.ttf.linkdoc;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Nov 18 12:11:12 ICT 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MknDokLinkImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Id {
            public Object get(MknDokLinkImpl obj) {
                return obj.getId();
            }

            public void put(MknDokLinkImpl obj, Object value) {
                obj.setId((DBSequence)value);
            }
        }
        ,
        LinkDokDid {
            public Object get(MknDokLinkImpl obj) {
                return obj.getLinkDokDid();
            }

            public void put(MknDokLinkImpl obj, Object value) {
                obj.setLinkDokDid((Integer)value);
            }
        }
        ,
        Did {
            public Object get(MknDokLinkImpl obj) {
                return obj.getDid();
            }

            public void put(MknDokLinkImpl obj, Object value) {
                obj.setDid((Integer)value);
            }
        }
        ,
        NoParent {
            public Object get(MknDokLinkImpl obj) {
                return obj.getNoParent();
            }

            public void put(MknDokLinkImpl obj, Object value) {
                obj.setNoParent((String)value);
            }
        }
        ,
        TipeDok {
            public Object get(MknDokLinkImpl obj) {
                return obj.getTipeDok();
            }

            public void put(MknDokLinkImpl obj, Object value) {
                obj.setTipeDok((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(MknDokLinkImpl object);

        public abstract void put(MknDokLinkImpl object, Object value);

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


    public static final int ID = AttributesEnum.Id.index();
    public static final int LINKDOKDID = AttributesEnum.LinkDokDid.index();
    public static final int DID = AttributesEnum.Did.index();
    public static final int NOPARENT = AttributesEnum.NoParent.index();
    public static final int TIPEDOK = AttributesEnum.TipeDok.index();

    /**
     * This is the default constructor (do not remove).
     */
    public MknDokLinkImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("app.mkp.model.entity.ttf.linkdoc.MknDokLink");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for Id, using the alias name Id.
     * @return the Id
     */
    public DBSequence getId() {
        return (DBSequence)getAttributeInternal(ID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Id.
     * @param value value to set the Id
     */
    public void setId(DBSequence value) {
        setAttributeInternal(ID, value);
    }

    /**
     * Gets the attribute value for LinkDokDid, using the alias name LinkDokDid.
     * @return the LinkDokDid
     */
    public Integer getLinkDokDid() {
        return (Integer)getAttributeInternal(LINKDOKDID);
    }

    /**
     * Sets <code>value</code> as the attribute value for LinkDokDid.
     * @param value value to set the LinkDokDid
     */
    public void setLinkDokDid(Integer value) {
        setAttributeInternal(LINKDOKDID, value);
    }

    /**
     * Gets the attribute value for Did, using the alias name Did.
     * @return the Did
     */
    public Integer getDid() {
        return (Integer)getAttributeInternal(DID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Did.
     * @param value value to set the Did
     */
    public void setDid(Integer value) {
        setAttributeInternal(DID, value);
    }

    /**
     * Gets the attribute value for NoParent, using the alias name NoParent.
     * @return the NoParent
     */
    public String getNoParent() {
        return (String)getAttributeInternal(NOPARENT);
    }

    /**
     * Sets <code>value</code> as the attribute value for NoParent.
     * @param value value to set the NoParent
     */
    public void setNoParent(String value) {
        setAttributeInternal(NOPARENT, value);
    }

    /**
     * Gets the attribute value for TipeDok, using the alias name TipeDok.
     * @return the TipeDok
     */
    public String getTipeDok() {
        return (String)getAttributeInternal(TIPEDOK);
    }

    /**
     * Sets <code>value</code> as the attribute value for TipeDok.
     * @param value value to set the TipeDok
     */
    public void setTipeDok(String value) {
        setAttributeInternal(TIPEDOK, value);
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
     * @param id key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(DBSequence id) {
        return new Key(new Object[]{id});
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
     protected void create(AttributeList attributeList) {
             super.create(attributeList);
             SequenceImpl seq = new SequenceImpl("MKN_DOK_LINK_SEQ", getDBTransaction());
             this.setId(new DBSequence(seq.getSequenceNumber()));
     }
}
