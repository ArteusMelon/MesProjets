function fizzBuzz() {
  let N = parseInt(prompt("ecrire un nombre entier"));
  for (let i = 0; i <= N; i++) {
    let indice = i;
    if (indice % 3 == 0 && indice % 5 == 0) {
      indice = "FizzBuzz";
    } else if (indice % 5 == 0) {
      indice = "Buzz";
    } else if (indice % 3 == 0) {
      indice = "Fizz";
    }
    document.write(indice + "<br/>");
  }
}

function justePrix() {
  let N = parseInt(prompt("ecrire un nombre entier"));
  let prix = parseInt(Math.random() * N);
  let vie = N - 1;

  console.log(prix);

  while ((N < prix && N > prix) || vie > 0) {
    if (N > prix) {
      vie--;
      alert(`tu as perdu une vie, c'est moins`);
      N = parseInt(prompt("reessais"));
    } else if (N < prix) {
      vie--;
      alert(`tu as perdu une vie, c'est plus`);
      N = parseInt(prompt("reessais"));
    }
    if (vie == 0) {
      document.write("tu as perdu");
    }
    if (prix == N) {
      document.write("tu as gagné");
    }
  }
}

function rollerCoaster() {
  let places = 5;
  let placsE = 0;
  let tours = 3;
  let file = [2, 3, 5, 4];
  let profit = 0;

  for (let i = 0; i < tours; i++) {
    for (let j = 0; j < file.length; j++) {
      if (placsE + file[j] <= places) {
        placsE += file[0];
        file.push(file[0]);
        file.shift();
      }
    }
    profit += placsE;
    placsE = 0;
  }
  console.log(profit);
}

function pendu() {
  let mot = "cheval";
  let mots = []
  let lettre = prompt("ecrire une lettre");

    for (let i = 0; i < mot.length; i++) {
      mots[i] = "_ ";

    }

while(mots != mot.split('')){
  
  for(let i =0; i< mots.length; i++){
    if(lettre == mot[i]){
      mots[i]=lettre
    }
    lettre = prompt("ecrire une lettre");
}

  
  //    }
  // console.log(motCache)
}
document.write(mots);
}

// fizzBuzz();
// justePrix();
// rollerCoaster();
pendu();
