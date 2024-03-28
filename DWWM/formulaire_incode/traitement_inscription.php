<?php
$userName = htmlspecialchars($_POST["userName"]);
$email = $_POST["email"];
$password= $_POST["password"];
$passwordConf = $_POST["passwordConf"];
$hash = password_hash($password, PASSWORD_DEFAULT);
$premium=$_POST['premium'];
$check = true;

if(empty($userName) || empty($password)){
    $check=false;
    echo "Il faut remplir tous les champs <br/>";
}
if($password!==$passwordConf){
    $check=false;
    echo "la Confirmation du mot de passe n'est pas valide <br/>";
}
if(!filter_var($email, FILTER_VALIDATE_EMAIL )){
    $check=false;
    echo "L'adresse email n'est pas valide <br/>";
}

if($check){
    session_start(); 
    $tab=[
        "userName"=>$userName,
        "email"=>$email,
        "password"=>$hash];
    $_SESSION["tab"]=$tab;
    $_SESSION["premium"]=$premium;
    header("Location: formulaireCo.php");


}







?>