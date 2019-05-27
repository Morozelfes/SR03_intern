/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import Model.User;
import Model.UserDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Junior
 */
public class UserAction extends ActionSupport{
    public User user=new User();
    public ArrayList<User> users = new ArrayList<User>();

    public String modifyEmail;
    public int id=0;
    
    public String index() {
        return "success";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<User> getUserList() {
        return users;
    }

    public void setUserList(ArrayList<User> users) {
        this.users = users;
    }
    
    public String addUser() throws SQLException{
        UserDAO userDAO = new UserDAO();
        System.out.println("GetUser (is_admin): " + user.is_admin() + "\n");
        userDAO.create(getUser());
        setUserList(userDAO.getAll());
        return "success";
    }
    
    public String connexion() throws SQLException {
        ResultSet result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connexion=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sr03_intern","root","");
            PreparedStatement statement = null;
            statement = connexion.prepareStatement("SELECT* FROM users WHERE email = ? AND password=?");
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            result = statement.executeQuery();
            if (result.next()) {
                user = new User(result.getString("lastname"),
                    result.getString("firstname"),
                    result.getString("email"),
                    result.getString("password"),
                    result.getString("tel"),
                    result.getString("company"),
                    result.getString("date_creat"),
                    result.getBoolean("is_admin"),
                    result.getString("status"),
                    result.getString("gender"));
            }
            result.close();
            if(user.is_admin()) {
                return "adminView";
            } else {
                return "visitorView";
            }
        } catch (ClassNotFoundException e){
            Logger.getLogger(UserAction.class.getName()).log(Level.SEVERE,null,e);
            return "failure";
        }
    }
    
    public String getAll() throws SQLException {
        User user = null;
        id=0;
        
        Statement statement = null;
        ResultSet result = null;
        
        try  {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/sr03_intern","root","");
                statement = connexion.createStatement();
            } catch (ClassNotFoundException e) {
                Logger.getLogger(UserAction.class.getName()).log(Level.SEVERE, null, e);
            }
            
            result = statement.executeQuery("SELECT * FROM users");
            while(result.next()) {
                user = new User(result.getString("lastname"),
                    result.getString("firstname"),
                    result.getString("email"),
                    result.getString("password"),
                    result.getString("tel"),
                    result.getString("company"),
                    result.getString("date_creat"),
                    result.getBoolean("is_admin"),
                    result.getString("status"),
                    result.getString("gender"));
                user.setId(id);
                users.add(user);
                System.out.println("User : " + user.toString() + "\n");
                System.out.println("Users " + id + " : "+ users.get(id) + "\n");
                id++;
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return "failure";
        }
        return "success";
    }
    
    public String activateUser() throws SQLException{
        UserDAO userdao = new UserDAO();
        user = userdao.find(modifyEmail).get();
        System.out.println("actif : " + user.getStatus() + "\n");
        if((user.getStatus()).equals("actif")) 
            user.setStatus("inactif"); 
        else 
            user.setStatus("actif");
        userdao.update(getUser());
        setUserList(userdao.getAll());
        return "success";
    }
    
    public String modifyUser() throws Exception {
        System.out.println("email modifier : " + modifyEmail + "\n");
        UserDAO userdao = new UserDAO();
        user = userdao.find(modifyEmail).get();
        return "success";
    }
    
    public String modifyUserSubmit() throws Exception {
        UserDAO userdao = new UserDAO();
        System.out.println("email modifier : " + user.getEmail() + "\n");
        userdao.update(getUser());
        setUserList(userdao.getAll());
        return "success";
    }
}
