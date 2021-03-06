<%-- 
    Document   : usersManagement
    Created on : 22 mai 2019, 16:26:26
    Author     : Junior
--%>

<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="form.css" />
        <meta charset="UTF-8">
        <title>Gestion des Users</title>
    </head>
    <body>
        <h1>Gestion des Utilisateurs</h1>
        <s:form action="addUserForm" method="post">
            <s:submit value="Creer un utilisateur"></s:submit>
        </s:form>
        <br>

        <c:forEach items="${users}" var="User">
            <c:out value="${User.lastname}"/>
            <c:out value="${User.firstname}"/>
            <c:out value="${User.email}"/>
            <form action="modifyUser">
                <input type="hidden" name="modifyEmail" value="${User.email}"/>
                <input type="submit" value="modifier"/>
            </form>
            <br>
        </c:forEach>
    </body>
</html>
