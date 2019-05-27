<%-- 
    Document   : modifyForm
    Created on : 27 mai 2019, 13:19:35
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
        <title>Modification d'un formulaire</title>
    </head>
    <body>
        <h1>Modification d'un formulaire</h1>
        <div>
            <form action="modifyFormSubmit">
                <label>Thème</label>
                <input type="text" value="${form.theme}" disabled="true">
                <select name="form.theme" value="${form.theme}">
                    <c:forEach items="${themes}" var="Theme">
                        <option><c:out value="${Theme.subject}"/></option> 
                    </c:forEach>
                </select>
                <br>
                <label>Sujet</label>
                <input type="text" name="Form.subject" value="${form.subject}"/>
                <input type="hidden" name="Form.id" value="${form.id}"/>
                <br>
                <label>Nombre de questions</label>
                <input type="number" name="Form.nb_question" value="${form.nb_question}"/>
                <br>
                <label>Nombre de réponses</label>
                <input type="number" name="Form.nb_answer" value="${form.nb_answer}"/>
                <br>
                <input type="hidden" name="Form.status" value="${form.status}"/>
                <br>
                <input type="submit" value="Modifier"/>
            </form>
        </div>
        <div>
            <div>
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
            </div>
            <div>
            <form action="addQuestion">
                <input type="submit" value="Ajouter une question"/>    
            </form>
            </div>
        </div>
    </body>
</html>
