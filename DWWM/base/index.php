<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h1>Depuis le php</h1>
    <?php
    include('texteInclude.php');
    echo '<h1>HelloWord</h1>';
    // echo phpinfo();




    ?>
    <hr>
    <h2>les variables : </h2>
    <?php
    define("myConst", 5);
    $a = "Salut";
    $b = "$a tout le monde";
    echo $b;
    var_dump($b);
    echo gettype($b);
    echo "<br/>" . myConst;
    $tab = ['Pomme', 'Fraise', 'Orange'];
    echo $tab[1];
    $Personne = [
        "nom" => "John",
        "Prenom" => "Doe",
        "Age" => 99
    ];
    var_dump($Personne);
    echo "<br/>" . $Personne["nom"];
    $animals = [
        "Chat" => [
            "nom" => "Minou",
            "age" => 50,
            "couleur" => "chartreuse",
            "vie" => 9
        ],
        "Chien" => [
            "nom" => "Paf",
            "age" => 9,
            "couleur" => "brun",
            "vie" => 9
        ]
    ];
    echo "<hr/>"."<br/>" . $animals["Chat"]["nom"];
    $heure = date("H:i:s");
    echo $heure;
    if ($heure > 12) {
        echo "c'est l'aprem";
    } else {
        echo " c'est le matin";
    }
    $resultat;
    $heure > 12 ? $resultat = "c'est l'aprem" : $resultat = "c'est le matin";
    echo $resultat;
    foreach ($tab as $fruit) {
        echo "<br/>" . $fruit;
    }
    foreach ($Personne as $key => $value) {
        echo "<br/>" . $key . ":" . $value;
    }

    foreach ($animals as $key=>$value) {
        
        echo "<br/>" . $key;

        foreach ($value as $cle => $value) {
            
            echo "<br/>" . $cle . ":" . $value;
        }
    }

    // session_start();
    // $_SESSION["fruit"]=$tab;
    
    ?>
    <?php
    
    $people = [
        "Smith" => [
            "Father" => "John Smith",
            "Mother" => "Alice Smith",
            "Child" => "David Smith"
        ],
        "Johnson" => [
            "Father" => "Michael Johnson",
            "Mother" => "Emily Johnson",
            "Child" => "Sophia Johnson"
        ],
        "Garcia" => [
            "Father" => "Carlos Garcia",
            "Mother" => "Maria Garcia",
            "Child" => "Mateo Garcia"
        ],
        "Wang" => [
            "Father" => "Wei Wang",
            "Mother" => "Li Wang",
            "Child" => "Lily Wang"
        ],
        "Mueller" => [
            "Father" => "Max Mueller",
            "Mother" => "Anna Mueller",
            "Child" => "Lukas Mueller"
        ],
        "Dubois" => [
            "Father" => "Pierre Dubois",
            "Mother" => "Marie Dubois",
            "Child" => "Sophie Dubois"
        ]
    ];
    
    session_start();
    $_SESSION["people"]=$people;
    header("Location: listPersonne.php");
exit;
    ?>
</body>

</html>