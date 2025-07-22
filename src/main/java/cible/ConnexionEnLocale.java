package cible;

public class ConnexionEnLocale implements Cible {

    private String login;

    public ConnexionEnLocale(String login) {
        this.login = login;
    }

    @Override
    public boolean tenterConnexion(String password) {
        return "admin".equals(login) && "abc".equals(password);
    }
}
