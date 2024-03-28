<?php
class Database
{

    private $host = 'localhost';
    private $dbName = 'orchestre';
    private $user = 'root';
    private $mdp = '';
    private $connexion;

    public function __construct()
    {

        $this->connexion = new PDO("mysql:host=$this->host;dbname=$this->dbName", $this->user, $this->mdp);

        $this->connexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    }

    public function insertRow($nom, $age, $type)
    {
        try {

            $query = "INSERT INTO troupeMusicale(nom, age, type) VALUES(:nom, :age, :type)";
            $statement = $this->connexion->prepare($query);


            $statement->bindParam(":nom", $nom);
            $statement->bindParam(":age", $age);
            $statement->bindParam(":type", $type);


            $statement->execute();
            echo "<br/> Insertion réussie";
        } catch (PDOException $e) {

            echo "Error: " . $e->getMessage();
        }
    }

    public function updateRow($id, $nom, $age, $type)
    {

        try {

            $query = "UPDATE troupeMusicale SET nom=:nom, age=:age, type=:type WHERE id=:id";
            $statement = $this->connexion->prepare($query);


            $statement->bindParam(":id", $id);
            $statement->bindParam(":nom", $nom);
            $statement->bindParam(":age", $age);
            $statement->bindParam(":type", $type);


            $statement->execute();
            echo "<br/> Mise à jour réussie";
        } catch (PDOException $e) {

            echo "Error: " . $e->getMessage();
        }
    }

    public function supprimer($id)
    {
        try {

            $query = "DELETE FROM troupeMusicale WHERE id=:id";
            $statement = $this->connexion->prepare($query);


            $statement->bindParam(":id", $id);

            $statement->execute();
            echo "<br/> Mise à jour réussie";
        } catch (PDOException $e) {

            echo "Error: " . $e->getMessage();
        }
    }

    public function affichage()
    {
        $query = "SELECT *FROM troupeMusicale";
        $statement = $this->connexion->prepare($query);
        $statement->execute();
        $musiciens = $statement->fetchAll(PDO::FETCH_ASSOC);
        $tab = [
            "Guitariste" => "../image/pikaguitare.jpg",
            "Trompettiste" => "../image/lucariotrompette.jpg",
            "Chanteur" => "../image/rondoudouchante.jpg",
            "Batteur" => "../image/pkbatteur.jpg",
            "Percussionniste" => "../image/pokepercu.jpg"

        ];
        foreach ($musiciens as $musicien) {

            echo "<div>
                <img src='" . $tab[$musicien["type"]] . "'>
                <form action='traitement2.php?id=" . $musicien['id'] . "' method='post' class='form' id='form_" . $musicien['id'] . "' type='submit'>
                 ID :  " . $musicien['id'] . " <br>
                 Nom : <input value='" . $musicien['nom'] . "' disabled='disabled' class='nom' name='nom'> <br>
                 Age : <input value='" . $musicien['age'] . "' disabled='disabled' class='age' name='age'> <br>
                 Type : <input value='" . $musicien['type'] . "' disabled='disabled' class='type' name='type'> <br>
                 <button type='button' class='btn'>Modifier</button><button class='btnV' type='submit' style='display:none'>Valider</button><br>
                 </form>
                 <a href='traitement3.php?id=" . $musicien['id'] . "'><button class=btnSupp>Supprimer</button></a><hr></div>";
        }
    }

    public function zero()
    {
        $query = "ALTER TABLE troupeMusicale AUTO_INCREMENT=0";
        $this->connexion->exec($query);
    }
}
