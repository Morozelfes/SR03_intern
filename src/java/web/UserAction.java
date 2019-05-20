/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import com.opensymphony.xwork2.ActionSupport;
import entities.User;
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
    
    public String index() {
        return "success";
    }
    
    public String save() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connexion=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sr03_intern","root","");
            PreparedStatement statement=null;
            statement = connexion.prepareStatement("INSERT INTO users (email, password, company, lastname, firstname, tel, date_creat) VALUES (?,?,?,?,?,?,NOW())");
            statement.setString(1,user.getEmail());
            statement.setString(2,user.getPwd());
            statement.setString(3,user.getCompany());
            statement.setString(4,user.getLastName());
            statement.setString(5,user.getFirstName());
            statement.setString(6,user.getTel());
            statement.executeUpdate();
            return "success";
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserAction.class.getName()).log(Level.SEVERE, null, ex);
            return "failure";
        }
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
            statement.setString(2, user.getPwd());
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
                user = new User(result.getString("lastName"),
                    result.getString("firstName"),
                    result.getString("email"),
                    result.getString("password"),
                    result.getString("tel"),
                    result.getString("company"),
                    result.getString("date_creat"),
                    result.getBoolean("is_admin"),
                    result.getString("status"),
                    result.getString("gender"));
                users.add(user);
                System.out.print(user.toString());
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return "failure";
        }
        return "success";
    }
    
    public String activateUser() throws SQLException{
        ResultSet result = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/sr03_intern", "root", "");
            PreparedStatement statement = null;
            statement = connexion.prepareStatement("UPDATE users SET status = ? WHERE email=?");
            statement.setString(1, "actif");
            statement.setString(2,user.getEmail());
            statement.executeUpdate();
            return "admin";
        } catch (ClassNotFoundException e)
        {
            Logger.getLogger(UserAction.class.getName()).log(Level.SEVERE, null, e);
            return "failure";
        }
    }
}
