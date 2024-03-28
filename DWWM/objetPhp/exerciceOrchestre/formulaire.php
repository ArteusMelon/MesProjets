<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <a href="affichage.php"><input type="button" value='home'></a>
    <form action="traitement.php" method="post" enctype="multipart/form-data" >
        <label for="nom">Nom musicien</label>
        <input type="text" name="nom" require>
        <label for="age">Age</label>
        <input type="number" name="age" require>
        <label for="type">Type musicien</label>
        <select name="type" id="type" require>
            <option>Guitariste</option>
            <option>Trompettiste</option>
            <option>Chanteur</option>
            <option>Batteur</option>
            <option>Percussionniste</option>
        </select>
        <label for="file">photo :</label>
        <input type="file" name="file">
        <button type='submit'>envoyer</button>



    </form>
</body>

</html>