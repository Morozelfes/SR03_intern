/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.DAO.DRIVER;
import static Model.DAO.PASSWORD;
import static Model.DAO.URL;
import static Model.DAO.USERNAME;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Junior
 */
public class FormDAO implements DAO<Form>{

    @Override
    public Optional<Form> find(String s) {
        return null;
    }
    
    @Override
    public Optional<Form> find(int id) {
        try {
            Connection connexion = null;
            Statement statement = null;
            
            try {
                Class.forName(DRIVER);
            } catch(ClassNotFoundException e) {
                Logger.getLogger(FormDAO.class.getName()).log(Level.SEVERE,null,e);
            }
            connexion = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            statement = connexion.createStatement();
            
            String query = "SELECT * FROM forms WHERE id= '" + id + "';";
            System.out.println("Executing command: " + query + "\n");
            ResultSet result = statement.executeQuery(query);
            
            result.next();
            int id_form =result.getInt(1);
            String theme=result.getString(2);
            String subject=result.getString(3);
            String status = result.getString(4);
            int nb_question = result.getInt(5);
            int nb_answer = result.getInt(6);
            ArrayList<Question> questions = new ArrayList<Question>();

            // ****** implémenter question DAO *****

            result.close();
            
            Form ret = new Form(id_form,theme,subject,status,nb_question,nb_answer,questions);
            return Optional.ofNullable(ret);
        } catch(SQLException e) {
            Logger.getLogger(FormDAO.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }
    }
    
    @Override
    public ArrayList<Form> getAll() {
        try {
            Connection connexion = null;
            Statement statement = null;

            try {
                Class.forName(DRIVER);
            } catch(ClassNotFoundException e) {
                Logger.getLogger(FormDAO.class.getName()).log(Level.SEVERE,null,e);
            }
            connexion = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            statement = connexion.createStatement();

            String query = "SELECT * from forms,themes WHERE forms.theme=themes.subject";
            System.out.println("Executing command : " + query + "\n");
            ArrayList<Form> ret;
            ResultSet result = statement.executeQuery(query);
            ret = new ArrayList<Form>();
            while(result.next()) {
                int id_form =result.getInt(1);
                String theme=result.getString(2);
                String subject=result.getString(3);
                String status = result.getString(4);
                int nb_question = result.getInt(5);
                int nb_answer = result.getInt(6);

                ArrayList<Question> questions = new ArrayList<Question>();

                // ***** Ajouter Question DAO à mettre dans questions

                ret.add(new Form(id_form,theme,subject,status,nb_question,nb_answer,questions));
            }
            return ret;
        } catch(SQLException e) {
            Logger.getLogger(FormDAO.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }
    }
    
    @Override
    public void create(Form f) {
        try {
            Connection connexion = null;

            try {
                Class.forName(DRIVER);
            } catch(ClassNotFoundException e) {
                Logger.getLogger(FormDAO.class.getName()).log(Level.SEVERE,null,e);
            }

            connexion = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            String query = "INSERT INTO forms (theme, subject,status,nb_question,nb_answer) VALUES ((SELECT subject FROM themes WHERE subject=?),?,?,?,?)";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setString(1,f.getTheme());
            statement.setString(2,f.getSubject());
            statement.setString(3,f.getStatus());
            statement.setInt(4,f.getNb_question());
            statement.setInt(5,f.getNb_answer());

            System.out.println("Executing command : " + query + "\n");
            System.out.println("Get Theme : " + f.getTheme() + "\n");
            statement.executeUpdate();
            statement.close();

        } catch(SQLException e) {
            Logger.getLogger(FormDAO.class.getName()).log(Level.SEVERE,null,e);           
        }
    }
    
    @Override
    public void update(Form f) {
        try {
            Connection connexion = null;

            try {
                Class.forName(DRIVER);
            } catch(ClassNotFoundException e) {
                Logger.getLogger(FormDAO.class.getName()).log(Level.SEVERE,null,e);
            }
            connexion = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String query = "UPDATE forms SET theme=?,subject=?,status=?,nb_question=?, nb_answer=? WHERE id=?;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setString(1,f.getTheme());
            statement.setString(2,f.getSubject());
            statement.setString(3,f.getStatus());
            statement.setInt(4,f.getNb_question());
            statement.setInt(5,f.getNb_answer());
            statement.setInt(6,f.getId());
            statement.executeUpdate();
            statement.close();

        } catch(SQLException e) {
            Logger.getLogger(FormDAO.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
    public void delete(Form f) {
        try {
            Connection connexion = null;

            try {
                Class.forName(DRIVER);
            } catch(ClassNotFoundException e) {
                Logger.getLogger(FormDAO.class.getName()).log(Level.SEVERE,null,e);
            }

            connexion = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String query = "DELETE FROM forms WHERE id=?";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1,f.getId());
            statement.executeUpdate();
            connexion.commit();
            statement.close();
        } catch (SQLException e) {
            Logger.getLogger(FormDAO.class.getName()).log(Level.SEVERE,null,e);            
        }
    }
}
