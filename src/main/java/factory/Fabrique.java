package factory;

import cible.ConnexionEnLocale;
import attaque.Attaque;
import attaque.AttaqueBruteForce;
import attaque.AttaqueDictionnaire;
import cible.Cible;
import cible.ConnexionEnLigne;
/**
 * Classe responsable de la création d'attaques et de cibles.
 * Cette classe utilise le patron de conception Fabrique pour créer des objets
 * de type Attaque et Cible en fonction des paramètres fournis.
 */
public class Fabrique {

    /**
     * Crée une attaque en fonction du type spécifié.
     * Cette méthode permet de créer soit une attaque par force brute, soit une attaque par dictionnaire.
     * 
     * @param attaqueType Le type d'attaque à créer (brute_force ou dictionnaire).
     * @return Une instance de la classe d'attaque correspondante.
     * @throws IllegalArgumentException Si le type d'attaque n'est pas pris en charge.
     */
    public Attaque createAttaque(String attaqueType) {
        if ("brute_force".equalsIgnoreCase(attaqueType)) {
            return new AttaqueBruteForce();
        } else if ("dictionnaire".equalsIgnoreCase(attaqueType)) {
            return new AttaqueDictionnaire(); // Note: Le fichier DictionaryAttaque.java n'a pas été fourni
        } else {
            throw new IllegalArgumentException("Attaque type not supported");
        }
    }

    /**
     * Crée une cible en fonction du type spécifié.
     * Cette méthode permet de créer soit une cible locale, soit une cible en ligne.
     * 
     * @param cibleType Le type de cible à créer (local ou online).
     * @param login Le login à utiliser pour la cible.
     * @return Une instance de la classe Cible correspondante.
     * @throws IllegalArgumentException Si le type de cible n'est pas pris en charge.
     */
    public Cible createCible(String cibleType, String login) {
        if ("local".equalsIgnoreCase(cibleType)) {
            return new ConnexionEnLocale(login);
        } else if ("online".equalsIgnoreCase(cibleType)) {
            return new ConnexionEnLigne(login);
        } else {
            throw new IllegalArgumentException("Cible type not supported");
        }
    }
}
