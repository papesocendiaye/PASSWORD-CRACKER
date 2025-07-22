import factory.Fabrique;
import attaque.Attaque;
import cible.Cible;

public class Main {

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
