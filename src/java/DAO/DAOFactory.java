/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Junior
 */
public class DAOFactory {
    private static String url ="";
    private static String username="root";
    private static String password="";
    
    public DAOFactory() {
        DAOFactory.url = "jdbc:mysql://localhost:3306/sr03_intern";
    }
    
}
