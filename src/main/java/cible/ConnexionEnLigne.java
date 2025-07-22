package cible;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ConnexionEnLigne implements Cible {

    private String login;

    public ConnexionEnLigne(String login) {
        this.login = login;
    }

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
