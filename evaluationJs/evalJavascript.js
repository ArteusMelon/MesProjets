function bienvenue() {
  let nom = prompt("ecrire le nom");
  document.write("Bienvenue " + nom);
}

function somme() {
  let nombre1 = parseInt(prompt("entrer un nombre entier 1"));
  let nombre2 = parseInt(prompt("entrer un nombre entier 2"));

  while (isNaN(nombre1) && isNaN(nombre2)) {
    nombre1 = parseInt(prompt("entrer un nombre entier 1"));
    nombre2 = parseInt(prompt("entrer un nombre entier 2"));
  }
  let somme = nombre1 + nombre2;
  document.write("La somme est : " + somme);
}

function profitPerte() {
  let prixFab = parseInt(prompt("entrer un nombre entier"));
  let prixVente = parseInt(prompt("entrer un nombre entier"));
  let perte = prixFab - prixVente;
  let profit = prixVente - prixFab;
  while (isNaN(prixFab) && isNaN(prixVente)) {
    prixFab = parseInt(prompt("entrer un nombre entier "));
    prixVente = parseInt(prompt("entrer un nombre entier "));
  }

  if (prixFab > prixVente) {
    document.write("Perte de" + perte + "€");
  } else if (prixFab < prixVente) {
    document.write("Profit de" + profit + "€");
  } else {
    document.write("Pas de gain ni de perte");
  }
}

function plusGrandNombre() {
  let nombre1 = parseInt(prompt("entrer un nombre entier 1"));
  let nombre2 = parseInt(prompt("entrer un nombre entier 2"));
  let nombre3 = parseInt(prompt("entrer un nombre entier 2"));
  document.write(Math.max(nombre1, nombre2, nombre3));
}

function profFlemmard() {
  let note = parseInt(prompt("entrer un nombre entier"));
  if (note <= 4) {
    document.write("Catastrophique, il faut tout revoir");
  } else if (note <= 10) {
    document.write("Insuffisant");
  } else if (note <= 14) {
    document.write("Peut mieux faire");
  } else if (note <= 17) {
    document.write("Bien");
  } else {
    document.write("Excellent, bon travail");
  }
}

function calculatrice(){
    let operande1 = parseInt(prompt("entrer un nombre entier 1"));
    let operande2 = parseInt(prompt("entrer un nombre entier 2"));
    let operateur = prompt("ecire une operateur +,-,*,/")
    switch(operateur){
        case '+':
            document.write(operande1+' + '+operande2+' = '+(operande1+operande2))
            break
        case '-':
            document.write(operande1+' - '+operande2+' = '+(operande1-operande2))
            break
        case '*':
            document.write(operande1+' * '+operande2+' = '+(operande1*operande2))
            break
        default :
            document.write(operande1+' / '+operande2+' = '+(operande1/operande2))
    }
}

function sommeBetw(){
    let nombre = parseInt(prompt("entrer un nombre entier "));
    let somme = 0;
    for(let i=1; i<=nombre; i++){
        somme +=i
        
    }
    document.write(somme)
}

function escalier(){
    let taille = parseInt(prompt("entrer un nombre entier "));
    let asterix ='';
   
    for(let i=1; i<=taille; i++){
        asterix +='*'
        document.write(asterix+'<br/>')

    }
}
function escalier2(){
    let taille = parseInt(prompt("entrer un nombre entier "));
    let asterix ='';
    
   
    for(let i=0; i<taille; i++){
        asterix +='*'
        document.write(asterix+'<br/>')

    }
    for(i= taille; i>1; i--){
        asterix = asterix.replace('*','')
        document.write(asterix+'<br/>')
    }
}

// bienvenue();
// somme();
// profitPerte();
// plusGrandNombre();
// profFlemmard();
// calculatrice();
// sommeBetw();
// escalier();
// escalier2();
