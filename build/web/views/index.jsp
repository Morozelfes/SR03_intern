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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
    <s:form action="save" method="post">
        <s:textfield label="Nom" name="user.lastName"></s:textfield>
        <s:textfield label="Prénom" name="user.firstName"></s:textfield>
        <s:textfield label="email" name="user.email"></s:textfield>
        <s:textfield label="Societe" name="user.company"></s:textfield>
        <s:textfield label="Tel" name="user.tel"></s:textfield>
        <s:submit value="Enregistrer"></s:submit>
    </s:form>
    </body>
</html>
