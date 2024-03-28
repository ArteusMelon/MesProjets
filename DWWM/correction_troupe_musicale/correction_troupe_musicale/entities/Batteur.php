<?php

class Batteur extends Musicien implements InstrumentPercussion{

    public function __construct(string $nom, int $age) {
        parent::__construct($nom, $age);
    }

    public function jouerPercussion() {
        return "Joue de la batterie.";
    }

    public function __toString() {
        return "Nom : {$this->nom}\nÂge : {$this->age}\nType : Batteur\n";
    }
}

?>
