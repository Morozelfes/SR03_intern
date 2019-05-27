<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="form.css" />
        <meta charset="UTF-8">
        <title>Users</title>
    </head>
    <body>
        <div>
            Bienvenue Administrateur
        </div>
        <s:form action="usersManagement">
            <s:submit value="Gestion des users"/>
        </s:form> 
        <s:form action="getAll" method="post">
            <s:submit value="Listage des users"></s:submit>
        </s:form>    
        <s:form action="formManagement" method="post">
            <s:submit value="Gestion des Formulaires"></s:submit>
        </s:form>
    </body>
</html>
