
<?php
include_once "Voiture.php";

class Bolide extends Voiture {

   private bool $route;
   private int $vitesseMax;

   public function __construct(string $marque,string $modele,string $couleur,int $nbrePorte, $route, $vitesseMax)
   {
    parent::__construct($marque, $modele, $couleur, $nbrePorte);
    $this->route=$route;
    $this->vitesseMax=$vitesseMax;
   } 

   public function getRoute(): bool{
    return $this->route;
   }
   public function setRoute(bool $route) : void {
    $this->route=$route;
   }
   public function getVitesseMax():int{
    return $this->vitesseMax;
   }
   public function setVitesseMax(int $vitesseMax) : void {
    $this->vitesseMax=$vitesseMax;
   }
   public function __toString()
   {
    if($this->route){
        $routes="true";
    }else{
        $routes="false";
    }
    return parent::__toString()."Route: ".$routes." VitesseMaximum: ".$this->vitesseMax."marque";
   }

}

$Bolide1=new Bolide("Lamborghini", "Revuelto", "noir", 3, false, 130);
echo $Bolide1->getRoute();
echo $Bolide1->getVitesseMax();
echo "<br/>".$Bolide1;
?>

