package attaque;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import cible.Cible;
/**
 * Classe représentant une attaque par dictionnaire.
 * Cette classe implémente l'interface Attaque et tente une attaque par dictionnaire
 * sur une cible donnée, en utilisant les mots de passe présents dans un fichier dictionnaire.
 */
public class AttaqueDictionnaire implements Attaque {

    private static final String DICTIONARY_FILE = "../../../src/dictionnaire.txt"; 
    /**
     * Lance l'attaque par dictionnaire sur la cible spécifiée.
     * Cette méthode lit chaque ligne du fichier dictionnaire et tente de se connecter à la cible
     * avec chaque mot de passe. Si un mot de passe valide est trouvé, l'attaque s'arrête.
     * 
     * @param cible La cible sur laquelle l'attaque doit être lancée.
     */
    @Override
    public void attaquer(Cible cible) {
        System.out.println("Démarrage de l'attaque par dictionnaire...");
        try (BufferedReader br = new BufferedReader(new FileReader(DICTIONARY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Tentative de mot de passe: " + line);
                if (cible.tenterConnexion(line)) {
                    System.out.println("Mot de passe trouvé: " + line);
                    return; 
                }
            }
            System.out.println("Echec de l'attaque par dictionnaire ! Yorougnne mot de passe biii !!! ");
        } catch (IOException e) {
            System.err.println("Erreur: probleme de lecture du fichier dictionnaire " + DICTIONARY_FILE);
        }
    }
}
