package attaque;
import cible.Cible;

/**
 * Interface représentant une attaque.
 * Cette interface définit une méthode `attaquer` que toutes les attaques doivent implémenter.
 * Elle permet d'exécuter une attaque sur une cible donnée.
 */
public interface Attaque {
    /**
     * Lance l'attaque sur la cible spécifiée.
     * Chaque classe implémentant cette interface devra fournir une implémentation
     * de cette méthode pour effectuer l'attaque de manière spécifique.
     * 
     * @param cible La cible sur laquelle l'attaque doit être lancée.
     */
    void attaquer(Cible cible);
}
