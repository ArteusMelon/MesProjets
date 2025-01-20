<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
    include "navbar.php";
    ?>
    <h1>Gestion des taches</h1>
    <?php
    session_start();
    if(isset($_SESSION["tabTache"])){
        $tab = $_SESSION["tabTache"];
    }
    
        if (isset($tab) && !empty($tab)) {

            foreach ($tab as $index=>$task) {
                echo "<div>";
                echo "<p><strong>Titre:</strong> " . $task["titre"] . "</p>";
                echo "<p><strong>Date:</strong> " . $task["date"] . "</p>";
                echo "<p><strong>Heure:</strong> " . $task["heure"] . "</p>";
                echo "<a href='traitementSupp.php?index=$index'><button>supprimer</button></a>";
                echo "<hr>";
                echo "</div>";
            }
        } else {
            echo "<p>Aucune tâche enregistrée.</p>";
        }
        ?>
    

    <a href="formTache.php"><button>Inscrire des taches</button></a>
</body>
</html>