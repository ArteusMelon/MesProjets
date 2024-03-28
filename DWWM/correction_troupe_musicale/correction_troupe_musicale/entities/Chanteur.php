<?php

class Chanteur extends Musicien implements Voix {

    private string $typeVoix;

    public function __construct(string $nom, int $age) {
        parent::__construct($nom, $age);
    }


    public function typeVoix() {
        return "Type de voix : " . $this->getTypeVoix();
    }

    public function getTypeVoix()
    {
        return $this->typeVoix;
    }
 
    public function setTypeVoix($typeVoix)
    {
        $this->typeVoix = $typeVoix;

        return $this;
    }

    public function __toString() {
        return "Nom : {$this->nom}\nÂge : {$this->age}\nType : Chanteur\n";
    }
}


?>