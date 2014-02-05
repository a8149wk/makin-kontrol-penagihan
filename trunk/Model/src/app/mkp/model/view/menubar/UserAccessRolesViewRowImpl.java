package app.mkp.model.view.menubar;

import oracle.jbo.domain.RowID;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Mar 05 09:52:09 ICT 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class UserAccessRolesViewRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Role {
            public Object get(UserAccessRolesViewRowImpl obj) {
                return obj.getRole();
            }

            public void put(UserAccessRolesViewRowImpl obj, Object value) {
                obj.setRole((String)value);
            }
        }
        ,
        UserName {
            public Object get(UserAccessRolesViewRowImpl obj) {
                return obj.getUserName();
            }

            public void put(UserAccessRolesViewRowImpl obj, Object value) {
                obj.setUserName((String)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(UserAccessRolesViewRowImpl object);

        public abstract void put(UserAccessRolesViewRowImpl object,
                                 Object value);

        public int index() {
            return UserAccessRolesViewRowImpl.AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return UserAccessRolesViewRowImpl.AttributesEnum.firstIndex() + UserAccessRolesViewRowImpl.AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = UserAccessRolesViewRowImpl.AttributesEnum.values();
            }
            return vals;
        }
    }

    public static final int ROLE = UserAccessRolesViewRowImpl.AttributesEnum.Role.index();
    public static final int USERNAME = UserAccessRolesViewRowImpl.AttributesEnum.UserName.index();

    /**
     * This is the default constructor (do not remove).
     */
    public UserAccessRolesViewRowImpl() {
    }

    /**
     * Gets UserAccessRoles entity object.
     * @return the UserAccessRoles
     */
    public EntityImpl getUserAccessRoles() {
        return (EntityImpl)getEntity(0);
    }

    /**
     * Gets the attribute value for ROLE using the alias name Role.
     * @return the ROLE
     */
    public String getRole() {
        return (String) getAttributeInternal(ROLE);
    }

    /**
     * Sets <code>value</code> as attribute value for ROLE using the alias name Role.
     * @param value value to set the ROLE
     */
    public void setRole(String value) {
        setAttributeInternal(ROLE, value);
    }

    /**
     * Gets the attribute value for USER_NAME using the alias name UserName.
     * @return the USER_NAME
     */
    public String getUserName() {
        return (String) getAttributeInternal(USERNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for USER_NAME using the alias name UserName.
     * @param value value to set the USER_NAME
     */
    public void setUserName(String value) {
        setAttributeInternal(USERNAME, value);
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
        if ((index >= UserAccessRolesViewRowImpl.AttributesEnum.firstIndex()) && (index < UserAccessRolesViewRowImpl.AttributesEnum.count())) {
            return UserAccessRolesViewRowImpl.AttributesEnum.staticValues()[index - UserAccessRolesViewRowImpl.AttributesEnum.firstIndex()].get(this);
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
        if ((index >= UserAccessRolesViewRowImpl.AttributesEnum.firstIndex()) && (index < UserAccessRolesViewRowImpl.AttributesEnum.count())) {
            UserAccessRolesViewRowImpl.AttributesEnum.staticValues()[index - UserAccessRolesViewRowImpl.AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }
}