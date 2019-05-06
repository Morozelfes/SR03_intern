<%-- 
    Document   : add_user
    Created on : 4 mai 2019, 19:07:10
    Author     : Junior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <input type="text" id="firstname" name="firstname" value="" size="20" maxlength="60" />
                <br/>
                
                <label for="name">Nom<span class="requis">*</span></label>
                <input type="text" id="name" name="name" value="" size="20" maxlength="60" />
                <br/>
                
                <label for="email">Adresse email<span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="" size="20" maxlength="60" />
                <br/>
                
                <label for=pwd>Mot de passe <span class="requis">*</span></label>
                <input type="password" id="pwd" name="password" value="" size="20" maxlength="20" />
                <br />

                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
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
            </fieldset>
        </form>
    </body>
</html>

