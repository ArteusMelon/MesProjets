<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="ass.css">
</head>

<body>

    <?php
        include('navbar.php');
        ?>

    <form action="assurance.php" method="post" classe="form">

        <div class="input">
            <label for="accident"> Nombre accident:</label>
            <input type="number" id="accident" name="accident">
        </div>
        <div class="input">
            <label for="permis"> Annee permis:</label>
            <input type="number" id="permis" name="permis">
        </div>
        <div class="input">
            <label for="fidelite"> Annee assurance:</label>
            <input type="number" id="fidelite" name="fidelite">
        </div>
        <div class="input">
            <label for="age"> Age:</label>
            <input type="number" name="age" id="age">
        </div>
        <div class="input">
            <input type="submit" id="age" value="envoyer">
        </div>

    </form>
</body>

</html>