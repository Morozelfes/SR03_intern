<%-- 
    Document   : addForm
    Created on : 24 mai 2019, 16:21:08
    Author     : Junior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="form.css" />
        <title>Nouveau Formulaire</title>
    </head>
    <body>
        <h1>Nouveau Formulaire</h1>
        <form action="addFormSubmit">
            <label>Theme</label>
            <select name="form.theme">
                <c:forEach items="${themes}" var="Theme">
                    <option><c:out value="${Theme.subject}"/></option>
                </c:forEach>
            </select>
            <br/>
            <label>Sujet</label>
            <input type="text" name="form.subject">
            <br/>
            <label>Nombre de questions</label>
            <input type="number" name="form.nb_question">
            <br/>
            <label>Nombre de réponses par question</label>
            <input type="number" name="form.nb_answer">
            <br/>
            <label>Actif</label>
            <input type="radio" name="form.status" value="actif">
            <label>Inactif</label>
            <input type="radio" name="form.status" value="inactif">
            <br/>
            <input type="submit" value="Créer Formulaire"/>
        </form>
    </body>
</html>
