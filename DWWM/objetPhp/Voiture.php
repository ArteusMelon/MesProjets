<?php

 class Voiture
{
    private string $marque;
    private string $modele;
    private string $couleur;
    private int $nbrePorte;

    public function __construct($marque, $modele, $couleur, $nbrePorte)
    {
        $this->marque = $marque;
        $this->modele = $modele;
        $this->couleur = $couleur;
        $this->nbrePorte = $nbrePorte;
    }
    private function demarrage()
    {
        return "Moteur demarré";
    }
    public function contact()
    {
        $this->demarrage();
    }
    public function Accelerer()
    {
        return "en cours d'acceleration";
    }
    public function Freinage()
    {
        return "en cours de freinage";
    }
    public function getMarque(): string
    {
        return $this->marque;
    }
    public function getModele(): string{
        return $this->modele;
    }
    public function setMarque(string $marque): void
    {
        $this->marque = $marque;
    }

    public function __toString()
    {
       return "marque".$this->marque;
    }
}

$voiture1 = new Voiture("Renault", "205", "rouge", 5);
$voiture2 = new Voiture("Peugeot", "306", "grise", 3);
$voiture3 = new Voiture("Audi", "a4", "bleu", 5);

echo $voiture1->getMarque();
$voiture1->setMarque("208");
echo $voiture1;


