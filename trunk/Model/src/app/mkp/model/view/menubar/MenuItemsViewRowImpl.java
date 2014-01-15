package app.mkp.model.view.menubar;

import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Mar 07 10:47:32 ICT 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MenuItemsViewRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        Id {
            public Object get(MenuItemsViewRowImpl obj) {
                return obj.getId();
            }

            public void put(MenuItemsViewRowImpl obj, Object value) {
                obj.setId((DBSequence)value);
            }
        }
        ,
        Name {
            public Object get(MenuItemsViewRowImpl obj) {
                return obj.getName();
            }

            public void put(MenuItemsViewRowImpl obj, Object value) {
                obj.setName((String)value);
            }
        }
        ,
        Shortcut {
            public Object get(MenuItemsViewRowImpl obj) {
                return obj.getShortcut();
            }

            public void put(MenuItemsViewRowImpl obj, Object value) {
                obj.setShortcut((String)value);
            }
        }
        ,
        DisplaySequence {
            public Object get(MenuItemsViewRowImpl obj) {
                return obj.getDisplaySequence();
            }

            public void put(MenuItemsViewRowImpl obj, Object value) {
                obj.setDisplaySequence((Number)value);
            }
        }
        ,
        Action {
            public Object get(MenuItemsViewRowImpl obj) {
                return obj.getAction();
            }

            public void put(MenuItemsViewRowImpl obj, Object value) {
                obj.setAction((String)value);
            }
        }
        ,
        MenId {
            public Object get(MenuItemsViewRowImpl obj) {
                return obj.getMenId();
            }

            public void put(MenuItemsViewRowImpl obj, Object value) {
                obj.setMenId((Number)value);
            }
        }
        ,
        Icon {
            public Object get(MenuItemsViewRowImpl obj) {
                return obj.getIcon();
            }

            public void put(MenuItemsViewRowImpl obj, Object value) {
                obj.setIcon((String)value);
            }
        }
        ,
        Label {
            public Object get(MenuItemsViewRowImpl obj) {
                return obj.getLabel();
            }

            public void put(MenuItemsViewRowImpl obj, Object value) {
                obj.setLabel((String)value);
            }
        }
        ,
        MenuDisplaySequence {
            public Object get(MenuItemsViewRowImpl obj) {
                return obj.getMenuDisplaySequence();
            }

            public void put(MenuItemsViewRowImpl obj, Object value) {
                obj.setMenuDisplaySequence((Number)value);
            }
        }
        ,
        MenuId {
            public Object get(MenuItemsViewRowImpl obj) {
                return obj.getMenuId();
            }

            public void put(MenuItemsViewRowImpl obj, Object value) {
                obj.setMenuId((DBSequence)value);
            }
        }
        ,
        MenuIcon {
            public Object get(MenuItemsViewRowImpl obj) {
                return obj.getMenuIcon();
            }

            public void put(MenuItemsViewRowImpl obj, Object value) {
                obj.setMenuIcon((String)value);
            }
        }
        ,
        MenuLabel {
            public Object get(MenuItemsViewRowImpl obj) {
                return obj.getMenuLabel();
            }

            public void put(MenuItemsViewRowImpl obj, Object value) {
                obj.setMenuLabel((String)value);
            }
        }
        ,
        MenuName {
            public Object get(MenuItemsViewRowImpl obj) {
                return obj.getMenuName();
            }

            public void put(MenuItemsViewRowImpl obj, Object value) {
                obj.setMenuName((String)value);
            }
        }
        ,
        MenuShortcut {
            public Object get(MenuItemsViewRowImpl obj) {
                return obj.getMenuShortcut();
            }

            public void put(MenuItemsViewRowImpl obj, Object value) {
                obj.setMenuShortcut((String)value);
            }
        }
        ,
        RolesId {
            public Object get(MenuItemsViewRowImpl obj) {
                return obj.getRolesId();
            }

            public void put(MenuItemsViewRowImpl obj, Object value) {
                obj.setRolesId((DBSequence)value);
            }
        }
        ,
        RolesName {
            public Object get(MenuItemsViewRowImpl obj) {
                return obj.getRolesName();
            }

            public void put(MenuItemsViewRowImpl obj, Object value) {
                obj.setRolesName((String)value);
            }
        }
        ,
        RoleMenuItemsRoleId {
            public Object get(MenuItemsViewRowImpl obj) {
                return obj.getRoleMenuItemsRoleId();
            }

            public void put(MenuItemsViewRowImpl obj, Object value) {
                obj.setRoleMenuItemsRoleId((DBSequence)value);
            }
        }
        ,
        RoleMenuItemsMenuItemId {
            public Object get(MenuItemsViewRowImpl obj) {
                return obj.getRoleMenuItemsMenuItemId();
            }

            public void put(MenuItemsViewRowImpl obj, Object value) {
                obj.setRoleMenuItemsMenuItemId((DBSequence)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(MenuItemsViewRowImpl object);

        public abstract void put(MenuItemsViewRowImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }

    public static final int ID = AttributesEnum.Id.index();
    public static final int NAME = AttributesEnum.Name.index();
    public static final int SHORTCUT = AttributesEnum.Shortcut.index();
    public static final int DISPLAYSEQUENCE = AttributesEnum.DisplaySequence.index();
    public static final int ACTION = AttributesEnum.Action.index();
    public static final int MENID = AttributesEnum.MenId.index();
    public static final int ICON = AttributesEnum.Icon.index();
    public static final int LABEL = AttributesEnum.Label.index();
    public static final int MENUDISPLAYSEQUENCE = AttributesEnum.MenuDisplaySequence.index();
    public static final int MENUID = AttributesEnum.MenuId.index();
    public static final int MENUICON = AttributesEnum.MenuIcon.index();
    public static final int MENULABEL = AttributesEnum.MenuLabel.index();
    public static final int MENUNAME = AttributesEnum.MenuName.index();
    public static final int MENUSHORTCUT = AttributesEnum.MenuShortcut.index();
    public static final int ROLESID = AttributesEnum.RolesId.index();
    public static final int ROLESNAME = AttributesEnum.RolesName.index();
    public static final int ROLEMENUITEMSROLEID = AttributesEnum.RoleMenuItemsRoleId.index();
    public static final int ROLEMENUITEMSMENUITEMID = AttributesEnum.RoleMenuItemsMenuItemId.index();

    /**
     * This is the default constructor (do not remove).
     */
    public MenuItemsViewRowImpl() {
    }

    /**
     * Gets MenuItems entity object.
     * @return the MenuItems
     */
    public EntityImpl getMenuItems() {
        return (EntityImpl)getEntity(0);
    }

    /**
     * Gets Menu entity object.
     * @return the Menu
     */
    public EntityImpl getMenu() {
        return (EntityImpl)getEntity(1);
    }

    /**
     * Gets Roles entity object.
     * @return the Roles
     */
    public EntityImpl getRoles() {
        return (EntityImpl)getEntity(2);
    }

    /**
     * Gets RoleMenuItems entity object.
     * @return the RoleMenuItems
     */
    public EntityImpl getRoleMenuItems() {
        return (EntityImpl)getEntity(3);
    }


    /**
     * Gets the attribute value for ID using the alias name Id.
     * @return the ID
     */
    public DBSequence getId() {
        return (DBSequence)getAttributeInternal(ID);
    }

    /**
     * Sets <code>value</code> as attribute value for ID using the alias name Id.
     * @param value value to set the ID
     */
    public void setId(DBSequence value) {
        setAttributeInternal(ID, value);
    }

    /**
     * Gets the attribute value for NAME using the alias name Name.
     * @return the NAME
     */
    public String getName() {
        return (String) getAttributeInternal(NAME);
    }

    /**
     * Sets <code>value</code> as attribute value for NAME using the alias name Name.
     * @param value value to set the NAME
     */
    public void setName(String value) {
        setAttributeInternal(NAME, value);
    }

    /**
     * Gets the attribute value for SHORTCUT using the alias name Shortcut.
     * @return the SHORTCUT
     */
    public String getShortcut() {
        return (String) getAttributeInternal(SHORTCUT);
    }

    /**
     * Sets <code>value</code> as attribute value for SHORTCUT using the alias name Shortcut.
     * @param value value to set the SHORTCUT
     */
    public void setShortcut(String value) {
        setAttributeInternal(SHORTCUT, value);
    }

    /**
     * Gets the attribute value for DISPLAY_SEQUENCE using the alias name DisplaySequence.
     * @return the DISPLAY_SEQUENCE
     */
    public Number getDisplaySequence() {
        return (Number) getAttributeInternal(DISPLAYSEQUENCE);
    }

    /**
     * Sets <code>value</code> as attribute value for DISPLAY_SEQUENCE using the alias name DisplaySequence.
     * @param value value to set the DISPLAY_SEQUENCE
     */
    public void setDisplaySequence(Number value) {
        setAttributeInternal(DISPLAYSEQUENCE, value);
    }

    /**
     * Gets the attribute value for ACTION using the alias name Action.
     * @return the ACTION
     */
    public String getAction() {
        return (String) getAttributeInternal(ACTION);
    }

    /**
     * Sets <code>value</code> as attribute value for ACTION using the alias name Action.
     * @param value value to set the ACTION
     */
    public void setAction(String value) {
        setAttributeInternal(ACTION, value);
    }

    /**
     * Gets the attribute value for MEN_ID using the alias name MenId.
     * @return the MEN_ID
     */
    public Number getMenId() {
        return (Number) getAttributeInternal(MENID);
    }

    /**
     * Sets <code>value</code> as attribute value for MEN_ID using the alias name MenId.
     * @param value value to set the MEN_ID
     */
    public void setMenId(Number value) {
        setAttributeInternal(MENID, value);
    }

    /**
     * Gets the attribute value for ICON using the alias name Icon.
     * @return the ICON
     */
    public String getIcon() {
        return (String) getAttributeInternal(ICON);
    }

    /**
     * Sets <code>value</code> as attribute value for ICON using the alias name Icon.
     * @param value value to set the ICON
     */
    public void setIcon(String value) {
        setAttributeInternal(ICON, value);
    }

    /**
     * Gets the attribute value for LABEL using the alias name Label.
     * @return the LABEL
     */
    public String getLabel() {
        return (String) getAttributeInternal(LABEL);
    }

    /**
     * Sets <code>value</code> as attribute value for LABEL using the alias name Label.
     * @param value value to set the LABEL
     */
    public void setLabel(String value) {
        setAttributeInternal(LABEL, value);
    }

    /**
     * Gets the attribute value for DISPLAY_SEQUENCE using the alias name MenuDisplaySequence.
     * @return the DISPLAY_SEQUENCE
     */
    public Number getMenuDisplaySequence() {
        return (Number) getAttributeInternal(MENUDISPLAYSEQUENCE);
    }

    /**
     * Sets <code>value</code> as attribute value for DISPLAY_SEQUENCE using the alias name MenuDisplaySequence.
     * @param value value to set the DISPLAY_SEQUENCE
     */
    public void setMenuDisplaySequence(Number value) {
        setAttributeInternal(MENUDISPLAYSEQUENCE, value);
    }

    /**
     * Gets the attribute value for ID using the alias name MenuId.
     * @return the ID
     */
    public DBSequence getMenuId() {
        return (DBSequence)getAttributeInternal(MENUID);
    }

    /**
     * Sets <code>value</code> as attribute value for ID using the alias name MenuId.
     * @param value value to set the ID
     */
    public void setMenuId(DBSequence value) {
        setAttributeInternal(MENUID, value);
    }

    /**
     * Gets the attribute value for ICON using the alias name MenuIcon.
     * @return the ICON
     */
    public String getMenuIcon() {
        return (String) getAttributeInternal(MENUICON);
    }

    /**
     * Sets <code>value</code> as attribute value for ICON using the alias name MenuIcon.
     * @param value value to set the ICON
     */
    public void setMenuIcon(String value) {
        setAttributeInternal(MENUICON, value);
    }

    /**
     * Gets the attribute value for LABEL using the alias name MenuLabel.
     * @return the LABEL
     */
    public String getMenuLabel() {
        return (String) getAttributeInternal(MENULABEL);
    }

    /**
     * Sets <code>value</code> as attribute value for LABEL using the alias name MenuLabel.
     * @param value value to set the LABEL
     */
    public void setMenuLabel(String value) {
        setAttributeInternal(MENULABEL, value);
    }

    /**
     * Gets the attribute value for NAME using the alias name MenuName.
     * @return the NAME
     */
    public String getMenuName() {
        return (String) getAttributeInternal(MENUNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for NAME using the alias name MenuName.
     * @param value value to set the NAME
     */
    public void setMenuName(String value) {
        setAttributeInternal(MENUNAME, value);
    }

    /**
     * Gets the attribute value for SHORTCUT using the alias name MenuShortcut.
     * @return the SHORTCUT
     */
    public String getMenuShortcut() {
        return (String) getAttributeInternal(MENUSHORTCUT);
    }

    /**
     * Sets <code>value</code> as attribute value for SHORTCUT using the alias name MenuShortcut.
     * @param value value to set the SHORTCUT
     */
    public void setMenuShortcut(String value) {
        setAttributeInternal(MENUSHORTCUT, value);
    }

    /**
     * Gets the attribute value for ID using the alias name RolesId.
     * @return the ID
     */
    public DBSequence getRolesId() {
        return (DBSequence)getAttributeInternal(ROLESID);
    }

    /**
     * Sets <code>value</code> as attribute value for ID using the alias name RolesId.
     * @param value value to set the ID
     */
    public void setRolesId(DBSequence value) {
        setAttributeInternal(ROLESID, value);
    }

    /**
     * Gets the attribute value for NAME using the alias name RolesName.
     * @return the NAME
     */
    public String getRolesName() {
        return (String) getAttributeInternal(ROLESNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for NAME using the alias name RolesName.
     * @param value value to set the NAME
     */
    public void setRolesName(String value) {
        setAttributeInternal(ROLESNAME, value);
    }

    /**
     * Gets the attribute value for MIT_ID using the alias name RoleMenuItemsRoleId.
     * @return the MIT_ID
     */
    public DBSequence getRoleMenuItemsRoleId() {
        return (DBSequence)getAttributeInternal(ROLEMENUITEMSROLEID);
    }

    /**
     * Sets <code>value</code> as attribute value for MIT_ID using the alias name RoleMenuItemsRoleId.
     * @param value value to set the MIT_ID
     */
    public void setRoleMenuItemsRoleId(DBSequence value) {
        setAttributeInternal(ROLEMENUITEMSROLEID, value);
    }

    /**
     * Gets the attribute value for ROL_ID using the alias name RoleMenuItemsMenuItemId.
     * @return the ROL_ID
     */
    public DBSequence getRoleMenuItemsMenuItemId() {
        return (DBSequence)getAttributeInternal(ROLEMENUITEMSMENUITEMID);
    }

    /**
     * Sets <code>value</code> as attribute value for ROL_ID using the alias name RoleMenuItemsMenuItemId.
     * @param value value to set the ROL_ID
     */
    public void setRoleMenuItemsMenuItemId(DBSequence value) {
        setAttributeInternal(ROLEMENUITEMSMENUITEMID, value);
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
