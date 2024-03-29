package app.mkp.model;

import app.mkp.adfextensions.CustomApplicationModuleImpl;
import app.mkp.model.common.SecurityAM;
import app.mkp.model.view.menubar.UserAccessRolesViewImpl;

import java.util.HashMap;
import java.util.Map;

import oracle.jbo.Row;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Mar 06 12:28:12 ICT 2013
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SecurityAMImpl extends CustomApplicationModuleImpl implements SecurityAM {
    /**
     * This is the default constructor (do not remove).
     */
    public SecurityAMImpl() {
    }


    /**
     * Function to find user row by login and password
     * @return map with user data and lis of privileges
     */
    public Map authenticateUser(String userLogin, String userPassword) {
        
        Map userData = new HashMap();
        HashMap userAccess = new HashMap();
        
        ViewObjectImpl user = this.getUserAccessView1();
        user.setMaxFetchSize(1);
        user.setNamedWhereClauseParam("userLogin", userLogin);
        //user.setNamedWhereClauseParam("userPassword",PasswordEncoder.encodePassword(userLogin + ":" + userPassword));
        user.setNamedWhereClauseParam("userPassword",userPassword);
        user.executeQuery();

        if (user.getEstimatedRowCount() > 0) {

            Row userRow = user.first();
            String firstName = (String)userRow.getAttribute("FirstName");
            String middleName = (String)userRow.getAttribute("MiddleName");
            String lastName = (String)userRow.getAttribute("LastName");
            String departmentName = (String)userRow.getAttribute("Department");
            String titleName = (String)userRow.getAttribute("Title");
            String userNameLogin = (String)userRow.getAttribute("UserName");
                        
            userData.put("FirstName", firstName);
            userData.put("MiddleName", middleName);
            userData.put("LastName", lastName);
            userData.put("DepartmentName", departmentName);
            userData.put("TitleName", titleName);
            userData.put("Password", userPassword);
            userData.put("UserName", userNameLogin);
            setToSession("UserId", userLogin); // Save Login ID to BC session
            
            //Retrive User Roles
            UserAccessRolesViewImpl groupOfRoles;
            groupOfRoles = this.getUserAccessRolesView1();
            groupOfRoles.setNamedWhereClauseParam("userNameLogin", userNameLogin);
            groupOfRoles.executeQuery();

            while (groupOfRoles.hasNext()) {
                Row privsRow = groupOfRoles.next();
                String roleName = (String)privsRow.getAttribute("Role");
                String userName = (String)privsRow.getAttribute("UserName");
                userAccess.put(roleName, userName);
            }
            
            userData.put("UserAccess", userAccess);
        }

        return userData;
    }
    /**
     * Container's getter for UserAccessRolesView1.
     * @return UserAccessRolesView1
     */
    public UserAccessRolesViewImpl getUserAccessRolesView1() {
        return (UserAccessRolesViewImpl)findViewObject("UserAccessRolesView1");
    }

    /**
     * Container's getter for UserAccessView1.
     * @return UserAccessView1
     */
    public ViewObjectImpl getUserAccessView1() {
        return (ViewObjectImpl)findViewObject("UserAccessView1");
    }

    /**
     * Container's getter for UserDataView1.
     * @return UserDataView1
     */
    public ViewObjectImpl getUserDataView1() {
        return (ViewObjectImpl)findViewObject("UserDataView1");
    }
}
