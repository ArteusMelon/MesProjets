<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

</head>

<body>
    <a href="formulaire.php"><input type="button" value='formulaire'></a>
    <?php
    include "coBd.php";
    $database = new Database();
    var_dump($_POST);
    $database->affichage();
    ?>
    <script src="fonction.js"></script>
</body>

</html>