<?php
include "coBd.php";

$database = new Database();
    $id = $_GET['id']; 
    $database->supprimer($id);
    $database->zero();
    header("Location:affichage.php");


?>
