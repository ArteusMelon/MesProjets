<?php
session_start();

if (isset($_GET["index"])) {
    $index = $_GET["index"];
    if (isset($_SESSION["tabTache"][$index])) {
        unset($_SESSION["tabTache"][$index]);
        $_SESSION["tabTache"] = array_values($_SESSION["tabTache"]);
    }
}


header("Location: tache.php");
?>