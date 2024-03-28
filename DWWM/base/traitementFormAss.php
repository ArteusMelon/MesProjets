<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    
session_start();

$point=$_SESSION["point"];

switch($point){
    case 0:
        echo "<p> Tarif bleu </p>";
        break;
    case 1:
        echo "<p> Tarif vert </p>";
        break;
    case 2:
        echo "<p> Tarif orange </p>";
        break;
    case 3:
        echo "<p> Tarif rouge </p>";
        break;
    default : 
    echo "<p> Refusé </p>";
        
}
echo $point;

 
?>
</body>

</html>