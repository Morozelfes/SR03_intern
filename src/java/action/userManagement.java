/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Model.User;
import Model.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;

/**
 *
 * @author Junior
 */
public class userManagement extends ActionSupport {
    public ArrayList<User> users = new ArrayList<User>();
    
    @Override
    public String execute() throws Exception {
        UserDAO userDAO = new UserDAO();
        setUserList(userDAO.getAll());
        System.out.println(" users " + users.get(0));
        return "success";
    }
    
    public ArrayList<User> getUserList() {
        return users;
    }
    
    public void setUserList(ArrayList<User> users) {
        this.users = users;
    }
}
