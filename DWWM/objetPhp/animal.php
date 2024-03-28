<?php
include "interfaceAnimal.php";


class Chat implements Animal
{
//attributs
    private int $vitesse;

//constructeur
    public function __construct($vitesse)
    {
        $this->vitesse = $vitesse;
    }

//getter et setter
    public function getVitesse(): int
    {
        return $this->vitesse;
    }
    public function setVitesse($vitesse): void
    {
        $this->vitesse = $vitesse;
    }

//fonctionnalité de l'animal

    public function ouvrirYeux()
    {
        return "Les yeux sont ouvert";
    }



    public function changerVitesse()
    {
        return "le chat change sa vitesse de course à " . $this->vitesse . " km/h";
    }
    public function miauler()
    {
        return "le chat miaule";
    }
    public function __toString()
    {
        return $this->ouvrirYeux() . ", " . $this->changerVitesse() . ", " . $this->miauler();
    }
}

$chat1 = new chat(65);
echo $chat1;
