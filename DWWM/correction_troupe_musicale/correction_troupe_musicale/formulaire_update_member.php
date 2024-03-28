<?php
spl_autoload_register(function ($classname) {
    $file = "entities/" . $classname . ".php";
    $interface = "interfaces/" . $classname . ".php";
    if (file_exists($file))
        require_once $file;
    if (file_exists($interface))
        require_once $interface;
});


if ($_SERVER["REQUEST_METHOD"] == "GET" && isset($_GET['id'])) {
    $id = $_GET['id'];
    $database = new Database();
    $conn = $database->connect();
    $result = $database->getMemberById($id);
}
?>

<form action="index.php" method="post">
    <input type="hidden" name="id" value="<?php echo $result["id"]; ?>">
    <label for="nom">Nom :</label>
    <input type="text" id="nom" name="nom" value="<?php echo $result["nom"]; ?>"><br><br>
    <label for="age">Âge :</label>
    <input type="number" id="age" name="age" value="<?php echo $result["age"]; ?>"><br><br>
    <label for="type">Type de musicien :</label>
    <select id="type" name="type">
        <option value="Guitariste" <?php if($result["type"] == 'Guitariste') echo 'selected'; ?>>Guitariste</option>
        <option value="Trompettiste" <?php if($result["type"] == 'Trompettiste') echo 'selected'; ?>>Trompettiste</option>
        <option value="Batteur" <?php if($result["type"] == 'Batteur') echo 'selected'; ?>>Batteur</option>
        <option value="Chanteur" <?php if($result["type"] == 'Chanteur') echo 'selected'; ?>>Chanteur</option>
        <option value="Percussionniste" <?php if($result["type"] == 'Percussionniste') echo 'selected'; ?>>Percussionniste</option>
    </select><br><br>
    <input type="submit" name="update" value="Mettre à jour membre">
</form>

<?php
    $database->close();
?>
