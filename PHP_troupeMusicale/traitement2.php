<?php

include "coBd.php";

$database = new Database();

    $id = $_GET['id']; 
    $nom = $_POST['nom'];
    $age = $_POST['age'];
    $type = $_POST['type'];

    $database->updateRow($id, $nom, $age, $type);
    header("Location: affichage.php");
 

?>



