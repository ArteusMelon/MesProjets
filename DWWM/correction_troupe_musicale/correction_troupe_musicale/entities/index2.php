<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <a href="formulaire_new_member.html">Ajouter un membre</a>
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
        
        <input type="submit" value="Rechercher">
        <a href="index.php">annuler recherche</a>
    </form>
    
    <label for="file">photo :</label>
    <input type="file" id="file" name="file">

    <?php if (isset($members)) : ?>
        <?php foreach ($members as $member) :
             ?>
            <div class="card">
                <div class="card-body">
                    <img src="<?php $tab[$member['type']] ?>" alt="">
                    <h5 class="card-title"><?php echo $member['nom']; ?></h5>
                    <p class="card-text">Âge : <?php echo $member['age']; ?></p>
                    <p class="card-text">Type : <?php echo $member['type']; ?></p>
                    <div id="actions">
                        <a href='formulaire_update_member.php?id=<?= $member['id'] ?>'>Modifier</a>
                        <a href='supprimer_membre.php?id=<?= $member['id'] ?>'>Supprimer</a>
                    </div>
                </div>
            </div>
        <?php endforeach; ?>
    <?php else : ?>
        <p>Aucun membres inscrit.</p>
    <?php endif; ?>


</body>

</html>