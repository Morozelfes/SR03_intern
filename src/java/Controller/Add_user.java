/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Metier.InscriptionForm;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Junior
 */
public class Add_user extends HttpServlet {
    public static final String VUE = "/WEB-INF/add_user.jsp";
    public static final String ATT_USER = "user";
    public static final String ATT_FORM = "form";
    
    private static Hashtable<Integer,User> usersTable=new Hashtable<Integer,User>();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean admin;
        if (request.getParameter("admin").equals("true")) {
            admin=true;
        }else {
            admin=false;
        }
        usersTable.put(usersTable.size(), new User(request.getParameter("name"),request.getParameter("firstname"),request.getParameter("email"),
            request.getParameter("gender"),request.getParameter("password"),request.getParameter("tel"), 
            admin, request.getParameter("society")));
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // TODO output your page here. You may use following sample code. //
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Utilisateur créé " + usersTable.get(usersTable.size()-1).toString() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } 
    }*/

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                /* affichage de la pag d'inscription */
                this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        InscriptionForm form = new InscriptionForm();
		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        User user = form.addUser( request );
		
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, user );
        
        /* Transmission de la paire d'objets request/response à notre JSP */
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }
}
