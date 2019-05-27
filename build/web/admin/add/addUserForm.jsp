<%-- 
    Document   : index.jsp
    Created on : 13 mai 2019, 17:05:56
    Author     : Junior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
       <link type="text/css" rel="stylesheet" href="form.css" />
       <title>Users</title>
    </head>
    <body>
    <form action="addUser">
        <label>Nom</label>
        <input type="text" name="user.lastname">
        <br/>
        <label>Prénom</label>
        <input type="text" name="user.firstname">
        <br/>
        <label>Email</label>
        <input type="text" name="user.email">
        <br/>
        <label>Company</label>
        <input type="text" name="user.company">
        <br/>
        <label>Tel</label>
        <input type="text" name="user.tel">
        <br/>
        <label>Homme</label>
        <input type="radio" name="user.gender" value="male">
        <label>Femme</label>
        <input type="radio" name="user.gender" value="female">
        <br/>
        <label>Admin</label>
        <input type="radio" name="user.is_admin" value="true">
        <label>Stagiaire</label>
        <input type="radio" name="user.is_admin" value="false">
        <br/>
        <input type="submit" value="Ajouter"/>
    </form>
    </body>
</html>
