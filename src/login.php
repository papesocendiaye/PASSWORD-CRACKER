<?php
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $login = $_POST['login'] ?? '';
    $password = $_POST['password'] ?? '';

    $validLogin = 'admin';
    $validPassword = 'abc';

    if ($login === $validLogin && $password === $validPassword) {
        echo "Connexion réussie";
    } else {
        echo "Échec de la connexion";
    }
}
?>
