<%-- 
    Document   : modifyView
    Created on : 20 mai 2019, 18:42:00
    Author     : Junior
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="form.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modification d'un user</h1>
        <form action="modifyUserSubmit">
            <label>Prénom</label>
            <input type="text" name="User.firstname" value="${user.firstname}"/>
            <br>
            <label>Nom</label>
            <input type="text" name="User.lastname" value="${user.lastname}"/>
            <input type="hidden" name="User.email" value="${user.email}"/>
            <br>
            <label>Mot de Passe</label>
            <input type="text" name="User.password" value="${user.password}"/>
            <br>
            <label>Société</label>
            <input type="text" name="User.company" value="${user.company}"/>
            <br>
            <label>Téléphone</label>
            <input type="text" name="User.tel" value="${user.tel}"/>
            <br>
            <label>Admin</label>
            <input type="radio" name="User.is_admin" value="true"/>
            <br>
            <label>Stagiaire</label>
            <input type="radio" name="User.is_admin" value="false"/>
            <input type="hidden" name="User.status" value="${user.status}"/>
            <br>
            <input type="submit" value="Modifier">
        </form>
    </body>
</html>
