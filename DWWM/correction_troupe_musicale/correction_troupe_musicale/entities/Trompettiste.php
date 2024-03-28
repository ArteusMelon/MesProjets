<?php

class Trompettiste extends Musicien implements InstrumentVent {

    public function __construct(string $nom, int $age) {
        parent::__construct($nom, $age);
    }

    public function jouerVent() {
        return "Joue de la trompette.";
    }

    public function __toString() {
        return "Nom : {$this->nom}\nÂge : {$this->age}\nType : Trompettiste\n";
    }
}

?>
