<?php
try{
$host='localhost';
$dbName='garage';
$user='root';
$mdp="";

$connexion = new PDO("mysql:host=$host;dbname=$dbName",$user,$mdp);
$connexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
echo "connexion reussie! <hr/>";
$query = "CREATE TABLE voiture2 (
    id int AUTO_INCREMENT PRIMARY KEY,
    marque VARCHAR(25),
    modele VARCHAR(25),
    couleur VARCHAR(25)
)";
$connexion->exec($query);
// $query="INSERT INTO voiture(marque, modele, couleur) VALUES('peugeot', '306', 'gris')";
// $connexion->exec($query);


// $querys="INSERT INTO voiture(marque, modele, couleur) VALUES(:marque, :modele, :couleur)";
// $statement=$connexion->prepare($querys);
// $marque="renault";
// $modele="205";
// $couleur="rouge";
// $statement->bindParam(":marque", $marque);
// $statement->bindParam(":modele", $modele);
// $statement->bindParam(":couleur", $couleur);

// $statement->execute();
// echo "<br/> insertion reussi";
// $connexion->beginTransaction();
// $connexion->exec("INSERT INTO voiture(marque, modele, couleur) VALUES('lamborghini', 'revuelto', 'jaune')");
// $connexion->exec("UPDATE voiture SET modele = 'dontknow' WHERE marque='lamborghini'");
// $connexion->commit();
// echo "transaction effectué <hr>";
$query2 = "SELECT * FROM voiture";
$statement2 = $connexion->prepare($query2);
$statement2->execute();
$voiture=$statement2->fetchAll(PDO::FETCH_ASSOC);

foreach($voiture as $voitures){
    echo "id: ".$voitures['id'].'<br/>';
    echo "marque: ".$voitures['marque'].'<br/>';
    echo "modele: ".$voitures['modele'].'<br/>';
    echo "couleur: ".$voitures['couleur'].'<hr/>';
}

}catch(PDOException $e){
    // $connexion->rollback();
    echo "erreur: ".$e->getMessage();
}


?>
