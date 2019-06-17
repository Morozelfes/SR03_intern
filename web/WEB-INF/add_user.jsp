<%-- 
    Document   : add_user
    Created on : 4 mai 2019, 19:07:10
    Author     : Junior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Ajout Utilisateur</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form action="add_user" method="post">
            <fieldset>
                <legend> Ajout Utilisateur</legend>
                <p> Vous pouvez ajouter un utlisateur via ce formulaire/</p>
                
                <label for="firstname">Prénom<span class="requis">*</span></label>
                <input type="text" id="firstname" name="firstname" value="<c:out value="${user.firstName}"/>" size="20" maxlength="60" />
                <br/>
                
                <label for="name">Nom<span class="requis">*</span></label>
                <input type="text" id="name" name="name" value="<c:out value="${user.lastName}"/>" size="20" maxlength="60" />
                <br/>
                
                <label for="email">Adresse email<span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="<c:out value="${user.email}"/>" size="20" maxlength="60" />
                <br/>
                
                <label for="company">Company<span class="requis">*</span></label>
                <input type="text" id="company" name="company" value="<c:out value="${user.company}"/>" size="20" maxlength="60" />
                <br/>
                
                <label for="phone">Téléphone<span class="requis">*</span></label>
                <input type="text" id="phone" name="phone" value="<c:out value="${user.tel}"/>" size="20" maxlength="60" />
                <br/>
                
                <label for=pwd>Mot de passe <span class="requis">*</span></label>
                <input type="password" id="pwd" name="password" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['password']}</span>
                <br />

                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['confirmation']}</span>
                <br />
                
                <label for="male">Male<span class="requis">*</span></label>
                <input type="radio" id="male" name="gender" value="male" size="20" maxlength="20" checked />
                <br />
                
                <label for="female">Female<span class="requis">*</span></label>
                <input type="radio" id="female" name="gender" value="female" size="20" maxlength="20" />
                <br />
                
                <label for="administrateur">Administrateur<span class="requis">*</span></label>
                <input type="radio" id="administrateur" name="admin" value="true" checked />
                <br />
                
                <label for="intern">Stagiaire<span class="requis">*</span></label>
                <input type="radio" id="intern" name="admin" value="false" />
                <br />

                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </fieldset>
        </form>
    </body>
</html>

