package app.mkp.backing;

import app.mkp.adfextensions.ADFUtils;
import app.mkp.adfextensions.JSFUtils;
import app.mkp.model.MenuAMImpl;
import app.mkp.model.view.menubar.MenuItemsViewImpl;
import java.io.IOException;    
import java.util.Iterator;  
import javax.el.ELContext;  
import javax.el.ExpressionFactory;  
import javax.el.MethodExpression;   
import javax.faces.application.Application;  
import javax.faces.component.UIComponent;  
import javax.faces.context.ExternalContext;  
import javax.faces.context.FacesContext;  
import javax.faces.event.ActionEvent;  
import javax.faces.event.PhaseEvent;  
import javax.servlet.http.HttpServletResponse;  
import app.mkp.model.view.menubar.MenuItemsViewRowImpl;
import app.mkp.model.view.menubar.UserAccessRolesViewImpl;
import app.mkp.model.view.menubar.UserAccessRolesViewRowImpl;
import java.util.ArrayList;
import java.util.List;

import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichMenu;  
import oracle.adf.view.rich.component.rich.RichMenuBar;  
import oracle.adf.view.rich.component.rich.nav.RichCommandMenuItem;

public class MenuBean {

    private RichMenuBar initMenu;

    public void createMenus(PhaseEvent phaseEvent) {

        // check the menu is already added
        boolean addMenu = true;
        for (Iterator iterator = initMenu.getChildren().iterator(); iterator.hasNext();) {
            UIComponent component = (UIComponent) iterator.next();
            if ( component.getId().startsWith("menuId")){
                addMenu = false;
            }
        } 
        if (addMenu) {

            //Get user data
            /*
            UserData userData =
                (UserData)JSFUtils.resolveExpression("#{UserData}");
            String userNameLogin = userData.getUserNameLogin();
            
            String userNameLogin = ADFContext.getCurrent().getSecurityContext().getUserName();
            */

            // List user roles
            List roles = new ArrayList();
            
            // Get menu application module
            MenuAMImpl menuAM = 
                    (MenuAMImpl)ADFUtils.getApplicationModuleForDataControl("MenuAMDataControl");
            
            /*
            // Get role by user access
            UserAccessRolesViewImpl roleView;
            roleView = menuAM.getUserAccessRolesView1();
            roleView.setNamedWhereClauseParam("userNameLogin", userNameLogin);
            roleView.executeQuery();
            
            
            while (roleView.hasNext()) {
                UserAccessRolesViewRowImpl roleName =  (UserAccessRolesViewRowImpl)roleView.next();            
                roles.add(roleName.getRole());
            }             
            */
            
            for ( String role : ADFContext.getCurrent().getSecurityContext().getUserRoles() ) {  
               //System.out.println("Role: "+role);
               roles.add(role);
            }  
                        
            // Get menu items
            MenuItemsViewImpl menuView;
            menuView = menuAM.getMenuItemsView1();
            //menuView.setNamedWhereClauseParam("usrNameLogin", userNameLogin);
            menuView.executeQuery();
            
            while (menuView.hasNext()) {
                MenuItemsViewRowImpl menuItem =  (MenuItemsViewRowImpl)menuView.next();
                
                // check if the user has this role
                boolean roleFound = false;
                  
                for (int i = 0 ; i < roles.size() ; i++ ) { 
                    /*
                    System.out.println("-----------------------------");
                    System.out.println("ROLES         : |" + roles.get(i).toString().trim() + "|");
                    System.out.println("MENU ITEM ROLE: |" + menuItem.getRolesName().trim() + "|");
                    System.out.println("BOLEAN RESULT : " + roles.get(i).toString().trim().equals(menuItem.getRolesName().trim()));
                    System.out.println("-----------------------------");
                    */                   
                    if (roles.get(i).toString().trim().equals(menuItem.getRolesName().trim())){
                      roleFound = true;  
                    }
                }        

                if (roleFound) {
                    Boolean menuFound = false;
                    RichMenu menu = new RichMenu();
                    String menuId = "menuId" + menuItem.getMenId().toString();
                    /*
                    System.out.println("-----------------------------");
                    System.out.println("MENU ID: " + menuId);
                    System.out.println("-----------------------------");
                    */
                    // check if the main menu is already added
                    for (Iterator iterator = initMenu.getChildren().iterator();
                         iterator.hasNext(); ) {
                        UIComponent component = (UIComponent)iterator.next();
                        if (component.getId().equalsIgnoreCase(menuId)) {
                            menuFound = true;
                            menu = (RichMenu)component;
                        }
                    }
                    if (!menuFound) {
                        // new main menu
                        RichMenu newMenu = new RichMenu();
                        newMenu.setId(menuId);
                        // Menu label
                        //newMenu.setText(menuItem.getMenuName());
                        newMenu.setText(menuItem.getMenuLabel());
                        newMenu.setIcon(menuItem.getMenuIcon());
                        initMenu.getChildren().add(newMenu);
                        menu = newMenu;
                    }
    
                    Boolean menuItemFound = false;
                    String menuItemId = menuItem.getName();
    
                    // check if the menu item is already added
                    for (Iterator iterator = menu.getChildren().iterator();
                         iterator.hasNext(); ) {
                        UIComponent component = (UIComponent)iterator.next();
                        if (component.getId().equalsIgnoreCase(menuItemId)) {
                            menuItemFound = true;
                        }
                    }
                    if (!menuItemFound) {
                        RichCommandMenuItem richMenuItem = new RichCommandMenuItem();
                        richMenuItem.setId(menuItemId);
                        // Menu item label
                        // richMenuItem.setText(menuItem.getName());
                        richMenuItem.setText(menuItem.getLabel());
                        richMenuItem.setActionExpression(getMethodExpression(menuItem.getAction()));
                        richMenuItem.setIcon(menuItem.getIcon());
                        menu.getChildren().add(richMenuItem);
                    }
                }
            }
            menuView.remove();
        }
    }

    public void setInitMenu(RichMenuBar initMenu) {
        this.initMenu = initMenu;
    }

    public RichMenuBar getInitMenu() {
        return initMenu;
    }

    private MethodExpression getMethodExpression(String name) {
        Class[] argtypes = new Class[1];
        argtypes[0] = ActionEvent.class;
        FacesContext facesCtx = FacesContext.getCurrentInstance();
        Application app = facesCtx.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesCtx.getELContext();
        return elFactory.createMethodExpression(elContext, name, null, argtypes);
    }
    
    public String goHome() throws IOException{
        ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletResponse response = (HttpServletResponse)ectx.getResponse();
        String url = ectx.getRequestContextPath()+"/faces/Pages/MainUserDashboard.jspx";    
        try {
           response.sendRedirect(url);
        } catch (Exception ex) {
           ex.printStackTrace();
        }
        return null;
    }

}