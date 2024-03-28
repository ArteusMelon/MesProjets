<?
abstract class Musicien{
    //Attributs
private string $nom;
private int $age;

//Constructeur
public function __construct($nom, $age)
{
    $this->nom=$nom;
    $this->age=$age;
}

//getter

public function getAge(): int{
    return $this->age;
}

public function getNom(): string{
    return $this->nom;
}
//setter
public function setAge($age): void{
     $this->age=$age;
}

public function setNom($nom): void{
    return $this->nom=$nom;
}
//affichage
public function __toString()
{
    return "Le Musicien ".$this->nom." est agé de ".$this->age." ans";
}
}

?>