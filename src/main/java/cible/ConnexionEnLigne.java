package cible;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Classe représentant une cible d'authentification en ligne.
 * Cette classe implémente l'interface Cible et tente de se connecter à un serveur
 * distant via une requête HTTP POST pour vérifier les informations de connexion.
 */
public class ConnexionEnLigne implements Cible {

    private String login;
    /**
     * Constructeur de la classe ConnexionEnLigne.
     * Initialise la cible avec un login pour la tentative de connexion.
     * 
     * @param login Le nom d'utilisateur utilisé pour l'authentification.
     */
    public ConnexionEnLigne(String login) {
        this.login = login;
    }
    /**
     * Tente de se connecter à la cible en envoyant une requête HTTP POST avec le mot de passe spécifié.
     * Cette méthode se connecte à un serveur distant en envoyant les informations de connexion (login et mot de passe)
     * et attend une réponse pour déterminer si la connexion est réussie.
     * 
     * @param password Le mot de passe à tester pour la connexion.
     * @return true si la connexion est réussie, sinon false.
     */
    @Override
    public boolean tenterConnexion(String password) {
        try {
            String urlStr = "http://localhost:8000/login.php";
            URL url = new URL(urlStr);

            String postData = "login=" + login + "&password=" + password;

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            try (OutputStream os = connection.getOutputStream()) {
                os.write(postData.getBytes(StandardCharsets.UTF_8));
            }

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder content = new StringBuilder();
                    String line;
                    while ((line = in.readLine()) != null) {
                        content.append(line);
                    }
                    String response = content.toString().trim();
                    return response.equalsIgnoreCase("Connexion réussie");
                }
            } else {
                System.err.println("Code HTTP inattendu : " + connection.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("Erreur de connexion au serveur : " + e.getMessage());
        }
        return false;
    }
}
