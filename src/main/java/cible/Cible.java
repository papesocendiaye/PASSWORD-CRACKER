package cible;
/**
 * Interface représentant une cible d'attaque.
 * Cette interface définit la méthode `tenterConnexion` que toutes les cibles doivent implémenter.
 * Elle permet de tenter une connexion avec un mot de passe donné.
 */
public interface Cible {
        /**
     * Tente de se connecter à la cible avec le mot de passe spécifié.
     * Cette méthode vérifie si le mot de passe fourni est correct pour la cible.
     * 
     * @param password Le mot de passe à tester pour la connexion.
     * @return true si la connexion est réussie avec le mot de passe, sinon false.
     */
        boolean tenterConnexion(String password);
}
