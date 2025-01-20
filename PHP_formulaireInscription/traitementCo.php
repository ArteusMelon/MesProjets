<?php
session_start();
$tab = $_SESSION["tab"];
$email = $_POST["email"];
$password = $_POST["password"];
$check = true;
$premium=$_SESSION["premium"];
var_dump($premium);
if($email !== $tab["email"]){
    $check = false;
    echo "L'email est invalide";
}
if( !password_verify($password, $tab["password"])){
    $check = false;
    echo "Le mot de passe est invalide";
}
if($premium!="on"){
if($check){
    $_SESSION["email"]=$email;
    header("Location:tache.php");
    

}}else{
    if($check){
        $_SESSION["email"]=$email;
        header("Location:tachePremium.php");}
}






?>