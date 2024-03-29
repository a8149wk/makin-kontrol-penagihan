package app.mkp.model;

import app.mkp.adfextensions.CustomApplicationModuleImpl;

import app.mkp.model.view.menubar.AppUrlViewImpl;
import app.mkp.model.view.menubar.MenuItemsViewImpl;

import app.mkp.model.view.menubar.UserAccessRolesViewImpl;

import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewLinkImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Mar 06 12:09:19 ICT 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MenuAMImpl extends CustomApplicationModuleImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public MenuAMImpl() {
    }
    
    public void setLoginToSession_MenuAM(String key, String val) {
        this.setLoginToSession(key, val);
    }


    /**
     * Container's getter for MenuItemsView1.
     * @return MenuItemsView1
     */
    public MenuItemsViewImpl getMenuItemsView1() {
        return (MenuItemsViewImpl)findViewObject("MenuItemsView1");
    }

    /**
     * Container's getter for UserAccessRolesView1.
     * @return UserAccessRolesView1
     */
    public UserAccessRolesViewImpl getUserAccessRolesView1() {
        return (UserAccessRolesViewImpl)findViewObject("UserAccessRolesView1");
    }

    /**
     * Container's getter for AppUrlView1.
     * @return AppUrlView1
     */
    public AppUrlViewImpl getAppUrlView1() {
        return (AppUrlViewImpl)findViewObject("AppUrlView1");
    }
}
