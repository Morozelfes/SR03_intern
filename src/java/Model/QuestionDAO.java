/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Junior
 */
public class QuestionDAO implements DAO<Question>{
     @Override
    public Optional<Question> find(String s) {
        return null;
    }
    
    @Override
    public Optional<Question> find(int id) {
        try {
            Connection connexion = null;
            Statement statement = null;
            
            try {
                Class.forName(DRIVER);
            } catch(ClassNotFoundException e) {
                Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE,null,e);
            }
            connexion = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            statement = connexion.createStatement();
            
            String query = "SELECT * FROM questions WHERE id= '" + id + "';";
            System.out.println("Executing command: " + query + "\n");
            ResultSet result = statement.executeQuery(query);
            
            result.next();
            int id_question =result.getInt(1);
            String statement_question=result.getString(2);
            String status = result.getString(4);
            ArrayList<Answer> answers = new ArrayList<>();

            // ****** implémenter answer DAO *****

            result.close();
            
            Question ret = new Question(id_question,statement_question,status,answers);
            return Optional.ofNullable(ret);
        } catch(SQLException e) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }
    }
    
    @Override
    public ArrayList<Question> getAll() {
        try {
            Connection connexion = null;
            Statement statement = null;

            try {
                Class.forName(DRIVER);
            } catch(ClassNotFoundException e) {
                Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE,null,e);
            }
            connexion = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            statement = connexion.createStatement();

            String query = "SELECT * from questions";
            System.out.println("Executing command : " + query + "\n");
            ArrayList<Question> ret;
            ResultSet result = statement.executeQuery(query);
            ret = new ArrayList<Question>();
            while(result.next()) {
                int id_question =result.getInt(1);
                String statement_question=result.getString(2);
                String status = result.getString(3);

                ArrayList<Answer> answers = new ArrayList<>();

                // ***** Ajouter Answer DAO à mettre dans questions

                ret.add(new Question(id_question,statement_question,status,answers));
            }
            return ret;
        } catch(SQLException e) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }
    }
    
    @Override
    public void create(Question q) {
        try {
            Connection connexion = null;

            try {
                Class.forName(DRIVER);
            } catch(ClassNotFoundException e) {
                Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE,null,e);
            }

            connexion = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            String query = "INSERT INTO questions (statement,status) VALUES (?,?)";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setString(1,q.getStatement());
            statement.setString(2,q.getStatus());

            System.out.println("Executing command : " + query + "\n");
            statement.executeUpdate();
            statement.close();

        } catch(SQLException e) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE,null,e);           
        }
    }
    
    @Override
    public void update(Question q) {
        try {
            Connection connexion = null;

            try {
                Class.forName(DRIVER);
            } catch(ClassNotFoundException e) {
                Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE,null,e);
            }
            connexion = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String query = "UPDATE questions SET statement=?,status=? WHERE id=?;";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setString(1,q.getStatement());
            statement.setString(2,q.getStatus());
            statement.setInt(3,q.getId());
            statement.executeUpdate();
            statement.close();

        } catch(SQLException e) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
    public void delete(Question q) {
        try {
            Connection connexion = null;

            try {
                Class.forName(DRIVER);
            } catch(ClassNotFoundException e) {
                Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE,null,e);
            }

            connexion = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            String query = "DELETE FROM questions WHERE id=?";
            PreparedStatement statement = connexion.prepareStatement(query);
            statement.setInt(1,q.getId());
            statement.executeUpdate();
            connexion.commit();
            statement.close();
        } catch (SQLException e) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE,null,e);            
        }
    }
}
