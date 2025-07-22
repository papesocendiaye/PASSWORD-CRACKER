import factory.Fabrique;
import attaque.Attaque;
import cible.Cible;
/**
 * Classe principale qui exécute l'attaque spécifiée sur la cible donnée.
 * La classe prend des arguments en ligne de commande pour spécifier le type d'attaque,
 * le type de cible et le login à utiliser.
 */
public class Main {
    /**
     * Point d'entrée du programme.
     * Cette méthode crée une attaque et une cible en fonction des arguments passés en ligne de commande,
     * puis lance l'attaque sur la cible.
     * 
     * @param args Les arguments passés en ligne de commande.
     *             - args[0] : Option (non utilisée dans ce code)
     *             - args[1] : Type d'attaque (brute_force ou dictionnaire)
     *             - args[2] : Option (non utilisée dans ce code)
     *             - args[3] : Type de cible (local ou online)
     *             - args[4] : Option (non utilisée dans ce code)
     *             - args[5] : Login utilisé pour la cible
     */
    public static void main(String[] args) {
        if (args.length < 6) {
            System.out.println("Usage: java Main --type <brute_force|dictionnaire> --cible <local|online> --login <login>");
            return;
        }

        String attaqueType = args[1];
        String cibleType = args[3];
        String login = args[5];

        Fabrique factory = new Fabrique();
        Attaque attaque = factory.createAttaque(attaqueType);
        Cible cible = factory.createCible(cibleType, login);

        attaque.attaquer(cible);
    }
}
