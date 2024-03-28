<?php

class Guitariste extends Musicien implements InstrumentCorde {

    public function __construct(string $nom, int $age) {
        parent::__construct($nom, $age);
    }

    public function jouerCorde() {
        return "Joue de la guitare.";
    }

    public function __toString() {
        return "Nom : {$this->nom}\nÂge : {$this->age}\nType : Guitariste\n";
    }
}


?>
