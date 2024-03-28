<?php

class Percussionniste extends Musicien implements InstrumentPercussion {

    public function __construct(string $nom, int $age) {
        parent::__construct($nom, $age);
    }

    public function jouerPercussion() {
        return "Joue des percussions.";
    }

    public function __toString() {
        return "Nom : {$this->nom}\nÂge : {$this->age}\nType : Percussionniste\n";
    }
}


?>