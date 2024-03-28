<?php
include "Musicien.php";
include "Interface.php";
class Guitariste extends Musicien implements InstrumentCorde{

    public function __construct(string $nom, int $age)
    {
        parent::__construct($nom, $age);
    }

    public function joueCorde(){
        return "En train de jouer de la guitare";
    }

}
class Trompettiste extends Musicien implements InstrumentVent {

    public function __construct(string $nom, int $age)
    {
        parent::__construct($nom, $age);
    }

    public function joueVent(){
        return "En train de jouer de la trompette";
    }

}
class Batteur extends Musicien{

    public function __construct(string $nom, int $age)
    {
        parent::__construct($nom, $age);
    }

    public function joue(){
        return "En train de jouer de la batterie";
    }

}
class Chanteur extends Musicien implements Voix{

    public function __construct(string $nom, int $age)
    {
        parent::__construct($nom, $age);
    }


    public function joue(){
        return "En train de chanter";
    }
    public function typeVoix(){
        return "Alto";
    }
}
class Percussioniste extends Musicien{

    public function __construct(string $nom, int $age)
    {
        parent::__construct($nom, $age);
    }

    public function joue(){
        return "En train de jouer du triangle";
    }

}

?>