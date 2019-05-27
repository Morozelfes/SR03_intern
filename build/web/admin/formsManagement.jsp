<%-- 
    Document   : formManagement
    Created on : 24 mai 2019, 15:39:51
    Author     : Junior
--%>

<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="form.css" />
        <title>Gestion des Formulaires</title>
    </head>
    <body>
        <h1>Gestion des formulaires</h1>
        <form action="addTheme">
            <label>Nouveau Thème</label>
            <input type="text" name="Theme.subject" value="${theme.subject}"/>
            <input type="submit" value="Nouveau Thème"/>
        </form>
        <br><br>
        <form action="addForm">
            <label>Nouveau Formulaire</label>
            <input type="submit" value="Nouveau Formulaire"/>
        </form>
        <br><br>
        
        <table>
            <tr>
                <th>Thème</th>
                <th>Sujet</th>
                <th>Statut</th>
                <th>Nb question</th>
                <th>Nb réponses</th>
                <th>Activer/Désactiver</th>
                <th>Modifier</th>
                
            </tr> 
            <s:iterator value = "forms">
                <tr>
                    <td><s:property value = "theme"/></td>
                    <td><s:property value = "subject"/></td>
                    <td><s:property value = "status"/></td>
                    <td><s:property value = "nb_question"/></td>
                    <td><s:property value = "nb_answer"/></td>
                    <td>
                        <form action="activateForm" method="post">
                            <input type="hidden" value=<s:property value="id"/>  name="modifyId" />
                            <input type="submit" value="Activer/Désactiver"/>
                        </form>
                    </td>
                    <td>
                        <form action="modifyForm" method="post">
                            <input type="hidden" value=<s:property value="id"/>  name="modifyId" />
                            <input type="submit" value="Modifier"/>
                        </form>
                    </td>
                </tr>
            </s:iterator>
        </table>
    </body>
</html>
