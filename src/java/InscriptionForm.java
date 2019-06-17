
import Model.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Junior
 */
public class InscriptionForm {
    private static final String CHAMP_EMAIL  = "email";
    private static final String CHAMP_PASS   = "password";
    private static final String CHAMP_CONF   = "confirmation";
    private static final String CHAMP_NOM    = "name";
    private static final String CHAMP_PRENOM = "firstname";
    private static final String CHAMP_GENDER = "gender";
    private static final String CHAMP_ADMIN    = "admin";
    private static final String CHAMP_COMPANY = "company";
    private static final String CHAMP_PHONE = "phone";
    
    private String resultat;
    private Map<String, String> erreurs = new HashMap<String,String>();
    
    public String getResultat() {
        return resultat;
    }
    
    public Map<String, String> getErreurs() {
        return erreurs;
    }
    
    public User addUser(HttpServletRequest request) {
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );
        String confirmation = getValeurChamp( request, CHAMP_CONF );
        String nom = getValeurChamp( request, CHAMP_NOM );
        String prenom = getValeurChamp(request, CHAMP_PRENOM);
        String genre = getValeurChamp(request, CHAMP_GENDER);
        String admin = getValeurChamp(request, CHAMP_ADMIN);
        String company = getValeurChamp(request, CHAMP_COMPANY);
        String phone = getValeurChamp(request, CHAMP_PHONE);

        User User = new User();

        User.setEmail( email );

        try {
            validationMotsDePasse( motDePasse, confirmation );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
            setErreur( CHAMP_CONF, null );
        }
        User.setPwd( motDePasse );
        User.setLastName( nom );
        User.setFirstName( prenom );
        User.setGender( genre );
        User.setTel( phone );
        User.setDate_creat();
        User.setstatus('actif');
        User.setCompany(company);
        
        if(admin == "true") {
            User.setAdmin(true);
        } else {
            User.setAdmin(false);
        }
        

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription.";
        } else {
            resultat = "Échec de l'inscription.";
        }

        return User;
    }

    private void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception {
        if ( motDePasse != null && confirmation != null ) {
            if ( !motDePasse.equals( confirmation ) ) {
                throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
            } else if ( motDePasse.length() < 3 ) {
                throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
}
