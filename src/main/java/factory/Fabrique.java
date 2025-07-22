package factory;

import cible.ConnexionEnLocale;
import attaque.Attaque;
import attaque.AttaqueBruteForce;
import attaque.AttaqueDictionnaire;
import cible.Cible;
import cible.ConnexionEnLigne;

public class Fabrique {

    // Crée l'attaque selon le type spécifié (BruteForce ou Dictionnaire)
    public Attaque createAttaque(String attaqueType) {
        if ("brute_force".equalsIgnoreCase(attaqueType)) {
            return new AttaqueBruteForce();
        } else if ("dictionnaire".equalsIgnoreCase(attaqueType)) {
            return new AttaqueDictionnaire(); // Note: Le fichier DictionaryAttaque.java n'a pas été fourni
        } else {
            throw new IllegalArgumentException("Attaque type not supported");
        }
    }

    // Crée la cible selon le type spécifié (local ou online)
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
