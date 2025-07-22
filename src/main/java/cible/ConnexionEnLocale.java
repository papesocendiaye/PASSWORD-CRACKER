package cible;
/**
 * Classe représentant une cible d'authentification locale.
 * Cette classe implémente l'interface Cible et tente de se connecter à une cible locale
 * avec des informations de connexion en dur (login et mot de passe prédéfinis).
 */
public class ConnexionEnLocale implements Cible {

    private String login;
    /**
     * Constructeur de la classe ConnexionEnLocale.
     * Initialise la cible avec un login pour la tentative de connexion.
     * 
     * @param login Le nom d'utilisateur utilisé pour l'authentification.
     */
    public ConnexionEnLocale(String login) {
        this.login = login;
    }
    /**
     * Tente de se connecter à la cible locale en vérifiant si le login et le mot de passe
     * fournis correspondent aux valeurs en dur ("admin" pour le login et "abc" pour le mot de passe).
     * 
     * @param password Le mot de passe à tester pour la connexion.
     * @return true si le login et le mot de passe sont corrects, sinon false.
     */
    @Override
    public boolean tenterConnexion(String password) {
        return "admin".equals(login) && "abc".equals(password);
    }
}
