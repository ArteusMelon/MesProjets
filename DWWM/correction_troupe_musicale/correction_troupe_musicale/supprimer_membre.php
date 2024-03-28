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


if ($_SERVER["REQUEST_METHOD"] == "GET" && isset($_GET['id'])) {
    // Récupérer l'ID du membre à supprimer
    $id = $_GET['id'];

    // Supprimer le membre de la base de données
    $database = new Database();
    $conn = $database->connect();
    $result = $database->deleteMember($id);
    $database->close();
}

header("Location: index.php");
exit;

?>