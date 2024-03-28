<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>


    <?php

$accident = $_POST["accident"];
$point=$accident;
$age=$_POST["age"];
$fidelite=$_POST["fidelite"];
$tempsPermis=$_POST["permis"];
var_dump($_POST);

if($age<25){
    $point++;
}
if($tempsPermis<2){
    $point++;
}
if($fidelite<5){
    $point++;
}

session_start();
$_SESSION["point"]=$point;
$_SESSION["age"]=$age;
    header("Location: traitementFormAss.php");
exit;

?>

</body>

</html>