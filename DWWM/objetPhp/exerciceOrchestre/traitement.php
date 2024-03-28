<?php
include "coBd.php";
var_dump($_FILES);
 $sizeMax=400000;
 $extensions=['png','jepg',];

if (isset($_POST['nom']) && isset($_POST['age']) && isset($_POST['type'])) {
    $nom = $_POST['nom'];
    $age = $_POST['age'];
    $types = $_POST['type'];
    if(isset($_FILES['file'])){
        $tpm=$_FILES['file']['tmp_name'];
        $name=$_FILES['file']['name'];
        $size=$_FILES['file']['size'];
        $error=$_FILES['file']['error'];
        $tabExtension=explode('.',$name);
        $extension=strtolower(end($tabExtension));
    }
}
$database = new Database();
if (isset($nom) && isset($age) && isset($types)) {
    $database->insertRow($nom, $age, $types);
    header("Location:affichage.php");
    if(in_array($extension,$extensions)&&$size<=$sizeMax){
    $addImg =  move_uploaded_file($tpm,'../image'.$name);
    var_dump($addImg);

    }
}
