<?php
//spl_autoload_register permet d'automatiser les includes dans l'ensemble de l'application
spl_autoload_register(function ($classname) {
    $file = "entities/" . $classname . ".php";
    $interface = "interfaces/" . $classname . ".php";
    if (file_exists($file))
        require_once $file;
    if (file_exists($interface))
        require_once $interface;
});

$database = new Database();
$conn = $database->connect();

// Vérifier si des données de recherche ont été soumises
if ($_SERVER["REQUEST_METHOD"] == "GET" && isset($_GET['type']) && isset($_GET['nom'])) {
    $type = $_GET['type'];
    $nom = $_GET['nom'];

    // Effectuer la recherche dans la base de données  
    $members = $database->searchMembers($type, $nom);
    $database->close();
} else {
    // Utilisation de la méthode pour récupérer tous les membres
    $members = $database->getAllMembers();
    $database->close();
}

// Vérifier si le formulaire d'ajout ou update est soumis
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Récupérer les données du formulaire
    $nom = $_POST['nom'];
    $age = $_POST['age'];
    $type = $_POST['type'];
    $database = new Database();

    if (isset($_POST['id'])) {
        $id = $_POST['id'];
        // Modifier les données dans la base de données
        $database->updateMember($id, $nom, $age, $type);
    } else {
        // Insérer les données dans la base de données
        $database->addMember($nom, $age, $type);
    }
}
?>

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
        <label for="file">photo :</label>
        <input type="file" id="file" name="file">

        <input type="submit" value="Rechercher">
        <a href="index.php">annuler recherche</a>
    </form>


    <?php if (isset($members)) : ?>
        <?php foreach ($members as $member) :?>
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