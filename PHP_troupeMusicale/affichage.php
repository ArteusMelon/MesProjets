<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

</head>

<body>
    <a href="formulaire.php"><input type="button" value='formulaire' id='search'></a>
    <form action="recherche.php" method="GET">
        <label for="type">Type de musicien :</label>
        <select id="type" name="type">
            <option value="">Tous</option>
            <option value="Guitariste">Guitariste</option>
            <option value="Trompettiste">Trompettiste</option>
            <option value="Batteur">Batteur</option>
            <option value="Chanteur">Chanteur</option>
            <option value="Percussionniste">Percussionniste</option>
        </select>
        <label for="nom">Nom :</label>
        <input type="text" id="nom" name="nom">
        <label for="file">photo :</label>
        <input type="file" id="file" name="file">

        <input type="submit" value="Rechercher">
        <a href="index.php">annuler recherche</a>
    </form>
    <?php
    include "coBd.php";
    $database = new Database();
    
    
    ?>
    <script src="fonction.js"></script>
</body>

</html>