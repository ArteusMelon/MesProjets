<?php
class Database {
    private $host = 'localhost';
    private $db_name = 'orchestre';
    private $username = 'root';
    private $password = '';
    private $conn;

    public function connect() {
        $this->conn = null;

        try {
            $this->conn = new PDO('mysql:host=' . $this->host . ';dbname=' . $this->db_name,
                $this->username, $this->password);
            $this->conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        } catch(PDOException $e) {
            echo 'Erreur de connexion : ' . $e->getMessage();
        }

        return $this->conn;
    }

    public function addMember($nom, $age, $type) {
        $conn = $this->connect();

        try {
            $query = "INSERT INTO troupemusicale (nom, age, type) VALUES (:nom, :age, :type)";
            $stmt = $conn->prepare($query);
            $stmt->bindParam(':nom', $nom);
            $stmt->bindParam(':age', $age);
            $stmt->bindParam(':type', $type);
            $stmt->execute();
            // 
            // $tpm=$_FILES['file']['tpm']
          
          
        } catch(PDOException $e) {
            echo 'Erreur lors de l\'ajout du membre : ' . $e->getMessage();
        }

        $this->close();
    }

    public function getAllMembers() {
        $query = "SELECT * FROM troupemusicale";
        $stmt = $this->conn->prepare($query);
        $stmt->execute();
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }

    public function getMemberById($id) {
        $query = "SELECT * FROM troupemusicale WHERE id = :id";
        $stmt = $this->conn->prepare($query);
        $stmt->bindParam(':id', $id);
        $stmt->execute();
        return $stmt->fetch(PDO::FETCH_ASSOC);
    }

    public function updateMember($id, $nom, $age, $type) {
        
        $conn = $this->connect();

        $query = "UPDATE troupemusicale SET nom = :nom, age = :age, type = :type WHERE id = :id";
        $stmt = $conn->prepare($query);
        $stmt->bindParam(':id', $id);
        $stmt->bindParam(':nom', $nom);
        $stmt->bindParam(':age', $age);
        $stmt->bindParam(':type', $type);
        return $stmt->execute();
    }

    public function deleteMember($id) {
        $query = "DELETE FROM troupemusicale WHERE id = :id";
        $stmt = $this->conn->prepare($query);
        $stmt->bindParam(':id', $id);
        return $stmt->execute();
    }

    public function searchMembers($type, $nom) {
        $query = "SELECT * FROM troupemusicale WHERE type LIKE :type AND nom LIKE :nom";
        $stmt = $this->conn->prepare($query);
        $type = '%' . $type . '%'; // Ajout des wildcards pour correspondre à n'importe quelle partie du type
        $nom = '%' . $nom . '%'; // Ajout des wildcards pour correspondre à n'importe quelle partie du nom
        $stmt->bindParam(':type', $type);
        $stmt->bindParam(':nom', $nom);
        $stmt->execute();
        return $stmt->fetchAll(PDO::FETCH_ASSOC);
    }
    

    public function close() {
        $this->conn = null;
    }
}

?>