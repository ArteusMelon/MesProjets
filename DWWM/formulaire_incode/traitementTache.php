<?php
session_start();

$titre = $_POST["titre"];
$date = $_POST["date"];
$heure = $_POST["heure"];


$newTask = [
    "titre" => $titre,
    "date" => $date,
    "heure" => $heure
];

$_SESSION["tabTache"][] = $newTask;

header("Location: tache.php");
?>
