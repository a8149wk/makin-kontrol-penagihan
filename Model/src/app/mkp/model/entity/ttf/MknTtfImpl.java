package app.mkp.model.entity.ttf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.text.SimpleDateFormat;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Sep 30 10:33:37 ICT 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MknTtfImpl extends EntityImpl {

    private static EntityDefImpl mDefinitionObject;

    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        if (operation == DML_UPDATE) {
            if (this.getBolean1().equalsIgnoreCase("T")) {
                this.setStatus(PAIDSTATUS);
                String profileCalcProcStmt =
                    "BEGIN MKN_NOTIF_SENDER.KONTRAK_PAID_OVER_90('" +
                    getKontrakNo() + "', " + this.getAmount() + "); END;";
                
                PreparedStatement st = null;
                try {
                    st =
 getDBTransaction().createPreparedStatement(profileCalcProcStmt, 0);
                    st.executeUpdate();
                    st.close();

                } catch (Exception exc) {
                    exc.printStackTrace();
                }

            } else {
                this.setBolean1(NOTPAID);
            }
        }
        super.doDML(operation, e);
    }

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Did {
            public Object get(MknTtfImpl obj) {
                return obj.getDid();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setDid((Number)value);
            }
        },
        Id {
            public Object get(MknTtfImpl obj) {
                return obj.getId();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setId((String)value);
            }
        },
        IdDokumen {
            public Object get(MknTtfImpl obj) {
                return obj.getIdDokumen();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setIdDokumen((String)value);
            }
        },
        UnitcompanyId {
            public Object get(MknTtfImpl obj) {
                return obj.getUnitcompanyId();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setUnitcompanyId((String)value);
            }
        },
        DepartmentId {
            public Object get(MknTtfImpl obj) {
                return obj.getDepartmentId();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setDepartmentId((String)value);
            }
        },
        GroupTtf {
            public Object get(MknTtfImpl obj) {
                return obj.getGroupTtf();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setGroupTtf((String)value);
            }
        },
        Trndate {
            public Object get(MknTtfImpl obj) {
                return obj.getTrndate();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setTrndate((Date)value);
            }
        },
        Trncode {
            public Object get(MknTtfImpl obj) {
                return obj.getTrncode();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setTrncode((String)value);
            }
        },
        Refno {
            public Object get(MknTtfImpl obj) {
                return obj.getRefno();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setRefno((String)value);
            }
        },
        Period {
            public Object get(MknTtfImpl obj) {
                return obj.getPeriod();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setPeriod((String)value);
            }
        },
        SupplierId {
            public Object get(MknTtfImpl obj) {
                return obj.getSupplierId();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setSupplierId((String)value);
            }
        },
        PoNo {
            public Object get(MknTtfImpl obj) {
                return obj.getPoNo();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setPoNo((String)value);
            }
        },
        InvoiceNo {
            public Object get(MknTtfImpl obj) {
                return obj.getInvoiceNo();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setInvoiceNo((String)value);
            }
        },
        InvoiceDate {
            public Object get(MknTtfImpl obj) {
                return obj.getInvoiceDate();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setInvoiceDate((Date)value);
            }
        },
        InvoiceDuedate {
            public Object get(MknTtfImpl obj) {
                return obj.getInvoiceDuedate();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setInvoiceDuedate((Date)value);
            }
        },
        Duedate {
            public Object get(MknTtfImpl obj) {
                return obj.getDuedate();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setDuedate((Date)value);
            }
        },
        Descr {
            public Object get(MknTtfImpl obj) {
                return obj.getDescr();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setDescr((String)value);
            }
        },
        CurrencyId {
            public Object get(MknTtfImpl obj) {
                return obj.getCurrencyId();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setCurrencyId((String)value);
            }
        },
        Amount {
            public Object get(MknTtfImpl obj) {
                return obj.getAmount();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setAmount((Number)value);
            }
        },
        Memotext {
            public Object get(MknTtfImpl obj) {
                return obj.getMemotext();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setMemotext((String)value);
            }
        },
        CreateBy {
            public Object get(MknTtfImpl obj) {
                return obj.getCreateBy();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        },
        CreateDate {
            public Object get(MknTtfImpl obj) {
                return obj.getCreateDate();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        },
        Status {
            public Object get(MknTtfImpl obj) {
                return obj.getStatus();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setStatus((Integer)value);
            }
        },
        CostCenter {
            public Object get(MknTtfImpl obj) {
                return obj.getCostCenter();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setCostCenter((String)value);
            }
        },
        PembayaranKe {
            public Object get(MknTtfImpl obj) {
                return obj.getPembayaranKe();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setPembayaranKe((Integer)value);
            }
        },
        TglTerimaDok {
            public Object get(MknTtfImpl obj) {
                return obj.getTglTerimaDok();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setTglTerimaDok((Date)value);
            }
        },
        ImNo {
            public Object get(MknTtfImpl obj) {
                return obj.getImNo();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setImNo((String)value);
            }
        },
        KontrakNo {
            public Object get(MknTtfImpl obj) {
                return obj.getKontrakNo();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setKontrakNo((String)value);
            }
        },
        TipePembelian {
            public Object get(MknTtfImpl obj) {
                return obj.getTipePembelian();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setTipePembelian((String)value);
            }
        },
        Bolean1 {
            public Object get(MknTtfImpl obj) {
                return obj.getBolean1();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setBolean1((String)value);
            }
        },
        Id1 {
            public Object get(MknTtfImpl obj) {
                return obj.getId1();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setId1((String)value);
            }
        },
        Id2 {
            public Object get(MknTtfImpl obj) {
                return obj.getId2();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setId2((String)value);
            }
        },
        Id3 {
            public Object get(MknTtfImpl obj) {
                return obj.getId3();
            }

            public void put(MknTtfImpl obj, Object value) {
                obj.setId3((String)value);
            }
        };
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public abstract Object get(MknTtfImpl object);

        public abstract void put(MknTtfImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() +
                AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int PAIDSTATUS = 40;
    public static final String NOTPAID = "N";

    public static final int DID = AttributesEnum.Did.index();
    public static final int ID = AttributesEnum.Id.index();
    public static final int IDDOKUMEN = AttributesEnum.IdDokumen.index();
    public static final int UNITCOMPANYID =
        AttributesEnum.UnitcompanyId.index();
    public static final int DEPARTMENTID = AttributesEnum.DepartmentId.index();
    public static final int GROUPTTF = AttributesEnum.GroupTtf.index();
    public static final int TRNDATE = AttributesEnum.Trndate.index();
    public static final int TRNCODE = AttributesEnum.Trncode.index();
    public static final int REFNO = AttributesEnum.Refno.index();
    public static final int PERIOD = AttributesEnum.Period.index();
    public static final int SUPPLIERID = AttributesEnum.SupplierId.index();
    public static final int PONO = AttributesEnum.PoNo.index();
    public static final int INVOICENO = AttributesEnum.InvoiceNo.index();
    public static final int INVOICEDATE = AttributesEnum.InvoiceDate.index();
    public static final int INVOICEDUEDATE =
        AttributesEnum.InvoiceDuedate.index();
    public static final int DUEDATE = AttributesEnum.Duedate.index();
    public static final int DESCR = AttributesEnum.Descr.index();
    public static final int CURRENCYID = AttributesEnum.CurrencyId.index();
    public static final int AMOUNT = AttributesEnum.Amount.index();
    public static final int MEMOTEXT = AttributesEnum.Memotext.index();
    public static final int CREATEBY = AttributesEnum.CreateBy.index();
    public static final int CREATEDATE = AttributesEnum.CreateDate.index();
    public static final int STATUS = AttributesEnum.Status.index();
    public static final int COSTCENTER = AttributesEnum.CostCenter.index();
    public static final int PEMBAYARANKE = AttributesEnum.PembayaranKe.index();
    public static final int TGLTERIMADOK = AttributesEnum.TglTerimaDok.index();
    public static final int IMNO = AttributesEnum.ImNo.index();
    public static final int KONTRAKNO = AttributesEnum.KontrakNo.index();
    public static final int TIPEPEMBELIAN =
        AttributesEnum.TipePembelian.index();
    public static final int BOLEAN1 = AttributesEnum.Bolean1.index();
    public static final int ID1 = AttributesEnum.Id1.index();
    public static final int ID2 = AttributesEnum.Id2.index();
    public static final int ID3 = AttributesEnum.Id3.index();

    /**
     * This is the default constructor (do not remove).
     */
    public MknTtfImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject =
                    EntityDefImpl.findDefObject("app.mkp.model.entity.ttf.MknTtf");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for Did, using the alias name Did.
     * @return the Did
     */
    public Number getDid() {
        return (Number)getAttributeInternal(DID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Did.
     * @param value value to set the Did
     */
    public void setDid(Number value) {
        setAttributeInternal(DID, value);
    }

    /**
     * Gets the attribute value for Id, using the alias name Id.
     * @return the Id
     */
    public String getId() {
        return (String)getAttributeInternal(ID);
    }

    /**
     * Sets <code>value</code> as the attribute value for Id.
     * @param value value to set the Id
     */
    public void setId(String value) {
        setAttributeInternal(ID, value);
    }

    /**
     * Gets the attribute value for IdDokumen, using the alias name IdDokumen.
     * @return the IdDokumen
     */
    public String getIdDokumen() {
        return (String)getAttributeInternal(IDDOKUMEN);
    }

    /**
     * Sets <code>value</code> as the attribute value for IdDokumen.
     * @param value value to set the IdDokumen
     */
    public void setIdDokumen(String value) {
        setAttributeInternal(IDDOKUMEN, value);
    }

    /**
     * Gets the attribute value for UnitcompanyId, using the alias name UnitcompanyId.
     * @return the UnitcompanyId
     */
    public String getUnitcompanyId() {
        return (String)getAttributeInternal(UNITCOMPANYID);
    }

    /**
     * Sets <code>value</code> as the attribute value for UnitcompanyId.
     * @param value value to set the UnitcompanyId
     */
    public void setUnitcompanyId(String value) {
        setAttributeInternal(UNITCOMPANYID, value);
    }

    /**
     * Gets the attribute value for DepartmentId, using the alias name DepartmentId.
     * @return the DepartmentId
     */
    public String getDepartmentId() {
        return (String)getAttributeInternal(DEPARTMENTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for DepartmentId.
     * @param value value to set the DepartmentId
     */
    public void setDepartmentId(String value) {
        setAttributeInternal(DEPARTMENTID, value);
    }

    /**
     * Gets the attribute value for GroupTtf, using the alias name GroupTtf.
     * @return the GroupTtf
     */
    public String getGroupTtf() {
        return (String)getAttributeInternal(GROUPTTF);
    }

    /**
     * Sets <code>value</code> as the attribute value for GroupTtf.
     * @param value value to set the GroupTtf
     */
    public void setGroupTtf(String value) {
        setAttributeInternal(GROUPTTF, value);
    }

    /**
     * Gets the attribute value for Trndate, using the alias name Trndate.
     * @return the Trndate
     */
    public Date getTrndate() {
        return (Date)getAttributeInternal(TRNDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Trndate.
     * @param value value to set the Trndate
     */
    public void setTrndate(Date value) {
        setAttributeInternal(TRNDATE, value);
    }

    /**
     * Gets the attribute value for Trncode, using the alias name Trncode.
     * @return the Trncode
     */
    public String getTrncode() {
        return (String)getAttributeInternal(TRNCODE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Trncode.
     * @param value value to set the Trncode
     */
    public void setTrncode(String value) {
        setAttributeInternal(TRNCODE, value);
    }

    /**
     * Gets the attribute value for Refno, using the alias name Refno.
     * @return the Refno
     */
    public String getRefno() {
        return (String)getAttributeInternal(REFNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for Refno.
     * @param value value to set the Refno
     */
    public void setRefno(String value) {
        setAttributeInternal(REFNO, value);
    }

    /**
     * Gets the attribute value for Period, using the alias name Period.
     * @return the Period
     */
    public String getPeriod() {
        return (String)getAttributeInternal(PERIOD);
    }

    /**
     * Sets <code>value</code> as the attribute value for Period.
     * @param value value to set the Period
     */
    public void setPeriod(String value) {
        setAttributeInternal(PERIOD, value);
    }

    /**
     * Gets the attribute value for SupplierId, using the alias name SupplierId.
     * @return the SupplierId
     */
    public String getSupplierId() {
        return (String)getAttributeInternal(SUPPLIERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for SupplierId.
     * @param value value to set the SupplierId
     */
    public void setSupplierId(String value) {
        setAttributeInternal(SUPPLIERID, value);
    }

    /**
     * Gets the attribute value for PoNo, using the alias name PoNo.
     * @return the PoNo
     */
    public String getPoNo() {
        return (String)getAttributeInternal(PONO);
    }

    /**
     * Sets <code>value</code> as the attribute value for PoNo.
     * @param value value to set the PoNo
     */
    public void setPoNo(String value) {
        setAttributeInternal(PONO, value);
    }

    /**
     * Gets the attribute value for InvoiceNo, using the alias name InvoiceNo.
     * @return the InvoiceNo
     */
    public String getInvoiceNo() {
        return (String)getAttributeInternal(INVOICENO);
    }

    /**
     * Sets <code>value</code> as the attribute value for InvoiceNo.
     * @param value value to set the InvoiceNo
     */
    public void setInvoiceNo(String value) {
        setAttributeInternal(INVOICENO, value);
    }

    /**
     * Gets the attribute value for InvoiceDate, using the alias name InvoiceDate.
     * @return the InvoiceDate
     */
    public Date getInvoiceDate() {
        return (Date)getAttributeInternal(INVOICEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for InvoiceDate.
     * @param value value to set the InvoiceDate
     */
    public void setInvoiceDate(Date value) {
        setAttributeInternal(INVOICEDATE, value);
    }

    /**
     * Gets the attribute value for InvoiceDuedate, using the alias name InvoiceDuedate.
     * @return the InvoiceDuedate
     */
    public Date getInvoiceDuedate() {
        return (Date)getAttributeInternal(INVOICEDUEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for InvoiceDuedate.
     * @param value value to set the InvoiceDuedate
     */
    public void setInvoiceDuedate(Date value) {
        setAttributeInternal(INVOICEDUEDATE, value);
    }

    /**
     * Gets the attribute value for Duedate, using the alias name Duedate.
     * @return the Duedate
     */
    public Date getDuedate() {
        return (Date)getAttributeInternal(DUEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Duedate.
     * @param value value to set the Duedate
     */
    public void setDuedate(Date value) {
        setAttributeInternal(DUEDATE, value);
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
     * Gets the attribute value for CurrencyId, using the alias name CurrencyId.
     * @return the CurrencyId
     */
    public String getCurrencyId() {
        return (String)getAttributeInternal(CURRENCYID);
    }

    /**
     * Sets <code>value</code> as the attribute value for CurrencyId.
     * @param value value to set the CurrencyId
     */
    public void setCurrencyId(String value) {
        setAttributeInternal(CURRENCYID, value);
    }

    /**
     * Gets the attribute value for Amount, using the alias name Amount.
     * @return the Amount
     */
    public Number getAmount() {
        return (Number)getAttributeInternal(AMOUNT);
    }

    /**
     * Sets <code>value</code> as the attribute value for Amount.
     * @param value value to set the Amount
     */
    public void setAmount(Number value) {
        setAttributeInternal(AMOUNT, value);
    }

    /**
     * Gets the attribute value for Memotext, using the alias name Memotext.
     * @return the Memotext
     */
    public String getMemotext() {
        return (String)getAttributeInternal(MEMOTEXT);
    }

    /**
     * Sets <code>value</code> as the attribute value for Memotext.
     * @param value value to set the Memotext
     */
    public void setMemotext(String value) {
        setAttributeInternal(MEMOTEXT, value);
    }

    /**
     * Gets the attribute value for CreateBy, using the alias name CreateBy.
     * @return the CreateBy
     */
    public String getCreateBy() {
        return (String)getAttributeInternal(CREATEBY);
    }

    /**
     * Gets the attribute value for CreateDate, using the alias name CreateDate.
     * @return the CreateDate
     */
    public Date getCreateDate() {
        return (Date)getAttributeInternal(CREATEDATE);
    }

    /**
     * Gets the attribute value for Status, using the alias name Status.
     * @return the Status
     */
    public Integer getStatus() {
        return (Integer)getAttributeInternal(STATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Status.
     * @param value value to set the Status
     */
    public void setStatus(Integer value) {
        setAttributeInternal(STATUS, value);
    }

    /**
     * Gets the attribute value for CostCenter, using the alias name CostCenter.
     * @return the CostCenter
     */
    public String getCostCenter() {
        return (String)getAttributeInternal(COSTCENTER);
    }

    /**
     * Sets <code>value</code> as the attribute value for CostCenter.
     * @param value value to set the CostCenter
     */
    public void setCostCenter(String value) {
        setAttributeInternal(COSTCENTER, value);
    }

    /**
     * Gets the attribute value for PembayaranKe, using the alias name PembayaranKe.
     * @return the PembayaranKe
     */
    public Integer getPembayaranKe() {
        return (Integer)getAttributeInternal(PEMBAYARANKE);
    }

    /**
     * Sets <code>value</code> as the attribute value for PembayaranKe.
     * @param value value to set the PembayaranKe
     */
    public void setPembayaranKe(Integer value) {
        setAttributeInternal(PEMBAYARANKE, value);
    }

    /**
     * Gets the attribute value for TglTerimaDok, using the alias name TglTerimaDok.
     * @return the TglTerimaDok
     */
    public Date getTglTerimaDok() {
        return (Date)getAttributeInternal(TGLTERIMADOK);
    }

    /**
     * Sets <code>value</code> as the attribute value for TglTerimaDok.
     * @param value value to set the TglTerimaDok
     */
    public void setTglTerimaDok(Date value) {
        setAttributeInternal(TGLTERIMADOK, value);
    }

    /**
     * Gets the attribute value for ImNo, using the alias name ImNo.
     * @return the ImNo
     */
    public String getImNo() {
        return (String)getAttributeInternal(IMNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for ImNo.
     * @param value value to set the ImNo
     */
    public void setImNo(String value) {
        setAttributeInternal(IMNO, value);
    }

    /**
     * Gets the attribute value for KontrakNo, using the alias name KontrakNo.
     * @return the KontrakNo
     */
    public String getKontrakNo() {
        return (String)getAttributeInternal(KONTRAKNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for KontrakNo.
     * @param value value to set the KontrakNo
     */
    public void setKontrakNo(String value) {
        setAttributeInternal(KONTRAKNO, value);
    }

    /**
     * Gets the attribute value for TipePembelian, using the alias name TipePembelian.
     * @return the TipePembelian
     */
    public String getTipePembelian() {
        return (String)getAttributeInternal(TIPEPEMBELIAN);
    }

    /**
     * Sets <code>value</code> as the attribute value for TipePembelian.
     * @param value value to set the TipePembelian
     */
    public void setTipePembelian(String value) {
        setAttributeInternal(TIPEPEMBELIAN, value);
    }


    /**
     * Gets the attribute value for Bolean1, using the alias name Bolean1.
     * @return the Bolean1
     */
    public String getBolean1() {
        return (String)getAttributeInternal(BOLEAN1);
    }

    /**
     * Sets <code>value</code> as the attribute value for Bolean1.
     * @param value value to set the Bolean1
     */
    public void setBolean1(String value) {
        setAttributeInternal(BOLEAN1, value);
    }

    /**
     * Gets the attribute value for Id1, using the alias name Id1.
     * @return the Id1
     */
    public String getId1() {
        return (String)getAttributeInternal(ID1);
    }

    /**
     * Sets <code>value</code> as the attribute value for Id1.
     * @param value value to set the Id1
     */
    public void setId1(String value) {
        setAttributeInternal(ID1, value);
    }

    /**
     * Gets the attribute value for Id2, using the alias name Id2.
     * @return the Id2
     */
    public String getId2() {
        return (String)getAttributeInternal(ID2);
    }

    /**
     * Sets <code>value</code> as the attribute value for Id2.
     * @param value value to set the Id2
     */
    public void setId2(String value) {
        setAttributeInternal(ID2, value);
    }

    /**
     * Gets the attribute value for Id3, using the alias name Id3.
     * @return the Id3
     */
    public String getId3() {
        return (String)getAttributeInternal(ID3);
    }

    /**
     * Sets <code>value</code> as the attribute value for Id3.
     * @param value value to set the Id3
     */
    public void setId3(String value) {
        setAttributeInternal(ID3, value);
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
        if ((index >= AttributesEnum.firstIndex()) &&
            (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index -
                AttributesEnum.firstIndex()].get(this);
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
        if ((index >= AttributesEnum.firstIndex()) &&
            (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index -
                AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }


    /**
     * @param did key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number did) {
        return new Key(new Object[] { did });
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);

        Connection conn = null;
        String newIdTtf = "";
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("jdbc/MKPConnectionDS");
            conn = ds.getConnection();
            PreparedStatement statement =
                conn.prepareStatement("SELECT TO_CHAR(MAX(TO_NUMBER(SUBSTR(ID_TTF,1,6)))+1,'FM000000')||'/'||'" +
                                      this.getDepartmentId() + "'||'/'||'" +
                                      this.getCostCenter() +
                                      "'||'/'||TO_CHAR(SYSDATE, 'MM')||'/'||TO_CHAR(SYSDATE, 'YYYY') AS NEW_ID_TTF " +
                                      "FROM (SELECT MknTtf.ID AS ID_TTF FROM MKN_TTF MknTtf) " +
                                      "WHERE SUBSTR(ID_TTF,8,3) = '" +
                                      this.getDepartmentId() + "' " +
                                      "AND SUBSTR(ID_TTF, -4,4) = TO_CHAR(SYSDATE, 'YYYY')");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                newIdTtf = rs.getString("NEW_ID_TTF");
                if (newIdTtf.length() < 26) {
                    newIdTtf = "000001" + newIdTtf;
                }
            }

            statement.close();
            rs.close();
            conn.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        this.setId(newIdTtf);
    }

}
