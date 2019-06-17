/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.util.List;
import jdbc.ConnectionMySQL;

/**
 *
 * @author Junior
 */
public abstract class DAO<T> {
    //public Connection connect = ConnectionMySQL.getInstance();
    
    public abstract List<T> index() throws DAOException;
    public abstract T find(long id);
    public abstract T create(T obj);
    public abstract T update(T obj);
    public abstract void delete(T obj);
}
