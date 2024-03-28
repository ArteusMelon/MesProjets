<?php

if ($_SERVER["REQUEST_METHOD"] == "GET" && isset($_GET['type']) && isset($_GET['nom'])) {
    $type = $_GET['type'];
    $nom = $_GET['nom'];
    header("Location: index.php?type=$type&nom=$nom");
    exit;
}else {
    header("Location: index.php");
    exit;
}
?>
