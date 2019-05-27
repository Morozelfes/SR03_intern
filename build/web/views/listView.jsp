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
        <table>
            <tr>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Email</th>
                <th>Société</th>
                <th>Téléphone</th>
                <th>Status</th>
                <th>Admin</th>
                <th>Gender</th>
                <th>Modifier</th>
                <th>Activer/Désactiver</th>
                
            </tr>         
            <s:iterator value = "users" status="user">
            <tr>
                <td><s:property value = "lastname"/></td>
                <td><s:property value = "firstname"/></td>
                <td><s:property value = "email"/></td>
                <td><s:property value = "company"/></td>
                <td><s:property value = "tel"/></td>
                <td><s:property value = "status"/></td>
                <td><s:property value = "is_admin"/></td>
                <td><s:property value= "gender"/></td>
                <td>
                    <s:form action="modifyUser" method="post">
                        <input type="hidden" value=<s:property value="email"/>  name="modifyEmail" />
                        <s:submit value="Modifier"/>
                    </s:form>
                </td>
                <td>
                    <s:form action="activateUser" method="post">
                        <input type="hidden" value=<s:property value="email"/>  name="modifyEmail" />
                        <s:submit value="Activer/Désactiver"/>
                    </s:form>
                </td>
            </tr>
            </s:iterator>

        </table>
    </body>
</html>
