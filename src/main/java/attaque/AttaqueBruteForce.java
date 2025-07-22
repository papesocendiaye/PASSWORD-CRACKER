package attaque;

import cible.Cible;
/**
 * Classe représentant une attaque par force brute.
 * Cette classe implémente l'interface Attaque et permet de tenter une attaque par force brute
 * sur une cible donnée, en essayant toutes les combinaisons possibles de mots de passe.
 */
public class AttaqueBruteForce implements Attaque {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final int MAX_LENGTH = 4;
    /**
     * Lance l'attaque par force brute sur la cible spécifiée.
     * Cette méthode génère et teste toutes les combinaisons possibles de mots de passe
     * à partir de l'alphabet défini et de la longueur maximale.
     * 
     * @param cible La cible sur laquelle l'attaque doit être lancée.
     */
    @Override
    public void attaquer(Cible cible) {
        System.out.println("Démarrage de l'attaque par force brute...");
        for (int length = 2; length <= MAX_LENGTH; length++) {
            if (genererEtTester(new StringBuilder(), length, cible)) {
                return;
            }
        }
        System.out.println("Echec de l'attaque. On a tout tenté mais cela nous a pas laissé faire ");
    }
    /**
     * Génère et teste récursivement toutes les combinaisons possibles de mots de passe
     * en fonction de la longueur spécifiée. Si un mot de passe valide est trouvé, l'attaque s'arrête.
     * 
     * @param current Le mot de passe actuellement généré.
     * @param length La longueur du mot de passe à tester.
     * @param cible La cible sur laquelle tenter la connexion avec le mot de passe.
     * @return true si un mot de passe valide a été trouvé, sinon false.
     */
    private boolean genererEtTester(StringBuilder current, int length, Cible cible) {

        if (current.length() == length) {
            String password = current.toString();
            System.out.println("Tentative de mot de passe: " + password);
            if (cible.tenterConnexion(password)) {
                System.out.println("Mot de passe trouvé: " + password);
                return true;
            }
            return false;
        }

        for (char c : ALPHABET.toCharArray()) {
            current.append(c);
            if (genererEtTester(current, length, cible)) {
                return true; 
            }
            current.deleteCharAt(current.length() - 1); 
        }
        return false;
    }
}
