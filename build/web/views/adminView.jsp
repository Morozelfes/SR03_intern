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
            <s:form action="getAll" method="post">
                <s:submit value="Lister users"></s:submit>
            </s:form>          
    </body>
</html>
