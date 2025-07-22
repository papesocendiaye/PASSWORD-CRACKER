package attaque;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import cible.Cible;

public class AttaqueDictionnaire implements Attaque {

    private static final String DICTIONARY_FILE = "../../../src/dictionnaire.txt"; 

    @Override
    public void attaquer(Cible cible) {
        System.out.println("Démarrage de l'attaque par dictionnaire...");
        try (BufferedReader br = new BufferedReader(new FileReader(DICTIONARY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Tentative de mot de passe: " + line);
                if (cible.tenterConnexion(line)) {
                    System.out.println("Mot de passe trouvé: " + line);
                    return; // Mot de passe trouvé, on arrête
                }
            }
            System.out.println("Echec de l'attaque par dictionnaire ! Yorougnne mot de passe biii !!! ");
        } catch (IOException e) {
            System.err.println("Erreur: probleme de lecture du fichier dictionnaire " + DICTIONARY_FILE);
        }
    }
}
