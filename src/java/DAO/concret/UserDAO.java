/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.concret;

import DAO.DAO;
import DAO.DAOException;
import DAO.DAOFactory;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Junior
 */
public class UserDAO extends DAO<User> {
    private DAOFactory daoFactory;
    
    private static final String SQL_SELECT_ALL = "SELECT * FROM users";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM users WHERE users.id= ?";
    private static final String SQL_INSERT = "INSERT INTO users (email,password, lastname, firstname, status, tel, is_admin, company) VALUES (?,?,?,?,?,?,?,?)";;
    private static final String SQL_UPDATE = "UPDATE users SET email=?,lastname=?, firstname=?, status=?, tel=?, is_admin=?, company=? WHERE id=?";;
    private static final String SQL_DELETE = "UPDATE users SET status= 'inactif' WHERE id = ?";
    
    public UserDAO(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public User create(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User update(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> index() throws DAOException {
        List<User> users = new ArrayList();
        
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try{
            /* Récupération d'une connexion depuis la Factory */
            connexion = DAOFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_ALL,false);
            resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
            
            ResultSetMetaData metadata = resultSet.getMetaData();
            while (resultSet.next()) {
                users.add(map(resultSet));
            }
            
            if(resultSet.next()) {
                System.out.println(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException (e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }
        
        return users;
    }
    

    @Override
    public User find(long id) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            /* Récupération d’une connexion depuis la Factory */
            connexion = DAOFactory.getConnection();
            preparedStatement = initialisationRequetePrepared( connexion,
            SQL_SELECT_BY_ID, false, id );
            resultSet = preparedStatement.executeQuery();
            //Parcours de la ligne de données de l’éventuel ResulSet retourné
            */
            if ( resultSet.next() ) {
            user = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null,
            ex);
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
        return user;
    }
    
    @Override
    public void create(User user) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            /* Récupération d’une connexion depuis la Factory */
            connexion = DAOFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion,
            SQL_INSERT, true, user.getEmail(), user.getPwd(), user.
            getLastName(),
            user.getFirstName(), user.getStatus(), user.
            getTel(), user.is_admin(), user.
            getCompany() );
            int status = preparedStatement.executeUpdate();
            System.out.println(status);
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null,
            ex);
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
    }
    
    @Override
    public void update(int id, User user) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            /* Récupération d’une connexion depuis la Factory */
            connexion = DAOFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion,
            SQL_UPDATE, true, user.getEmail(), user.getLastName(), user.getFirstName(),user.getStatus(), user.getTel(), user.is_admin(), user.getCompany(), id );
            int status = preparedStatement.executeUpdate();
            System.out.println(status);
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null,
            ex);
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
    }
    
    @Override
    public void delete(int id) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            /* Récupération d’une connexion depuis la Factory */
            connexion = DAOFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion,
            SQL_SOFT_DELETE, true, id );
            int status = preparedStatement.executeUpdate();
            System.out.println(status);
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null,
            ex);
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
    }
    
    private static User map(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setFirst_name(resultSet.getString("firstname"));
        user.setName_user(resultSet.getString("lastname"));
        user.setEmail(resultSet.getString("email"));
        user.setPwd(resultSet.getString("password"));
        user.setPhone(resultSet.getString("tek"));
        user.setIs_admin(resultSet.getBoolean("is_admin"));
        user.setStatus(resultSet.getString("status"));
        user.setCompany(resultSet.getString("company"));
        user.setCreated_date(resultSet.getDate("created_date"));
        return user;
    }
}
