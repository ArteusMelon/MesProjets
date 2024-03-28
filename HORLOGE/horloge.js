// function time(){
// var date  = new Date();
// var hour = date.getHours();
// var minute = date.getMinutes();
// var seconde = date.getSeconds();
// var periode = "";
// if (hour >= 12){
//     periode = "PM"
// }
// else{
//     periode = "AM"
// }

// hour = (hour < 10) ? "0" + hour : hour;
// minute = (minute < 10) ? "0" + minute : minute;
// seconde = (seconde < 10) ? "0" + seconde : seconde;

// document.getElementById("horloge").innerHTML = hour + ' : ' + minute+' : '+seconde+' '+periode;
// setTimeout(time, 1000);
// }




// var stock = 0;
// var element = document.getElementById('timer');
// var intervalId;

// const depart = () => {
//     if (!intervalId) {
//         intervalId = setInterval(updateTimer, 1000);
//     }
// };

// const stop = () => {

//     clearInterval(intervalId);
//     intervalId = null;
// };

// const reset = () => {

//     clearInterval(intervalId);
//     intervalId = null;
//     stock = 0; 
//     updateTimer(); 
// };

// const updateTimer = () => {
//     var hours = Math.floor(stock / 3600);
//     var minutes = Math.floor((stock - hours * 3600) / 60);
//     var seconds = stock - hours * 3600 - minutes * 60;

//     hours = String(hours).padStart(2, '0');
//     minutes = String(minutes).padStart(2, '0');
//     seconds = String(seconds).padStart(2, '0');

//     element.innerHTML = `${hours}:${minutes}:${seconds}`;

//     stock++;
// };
// var x = document.getElementById('start');
// var y = document.getElementById('stop');
// var z = document.getElementById('reset')
// x.addEventListener('click', () => {
//     depart();
// });

// y.addEventListener('click', () => {
//     stop();
// });

// z.addEventListener('click', () => {
//     reset();
// });


// var element = document.getElementById('timer'); // Element pour afficher le temps
// var stock = 0; // Initialisation du compteur

// const updateTimer = () => {
//     var hours = Math.floor(stock / 3600);
//     var minutes = Math.floor((stock - hours * 3600) / 60);
//     var seconds = stock % 60; // Calcul des secondes restantes

//     // Mettre à jour les champs de texte avec les valeurs calculées
//     var hoursFormatted = String(hours).padStart(2, '0');
//     var minutesFormatted = String(minutes).padStart(2, '0');
//     var secondsFormatted = String(seconds).padStart(2, '0');

//     element.innerHTML = `${hoursFormatted}:${minutesFormatted}:${secondsFormatted}`;

//     stock++; // Incrémenter le compteur
// };

// var o = document.getElementById('hour');
// o.addEventListener('click', () => {
//     // Récupérer les valeurs des champs de texte
//     var hoursInput = parseInt(document.getElementById('heure').value);
//     var minutesInput = parseInt(document.getElementById('minute').value);
//     var secondsInput = parseInt(document.getElementById('seconde').value);

//     stock = hoursInput * 3600 + minutesInput * 60 + secondsInput;
//     stock++
//     updateTimer(); // Appeler updateTimer pour mettre à jour le compteur et l'affichage
// });

// let age = parseInt(prompt('age :'));
// let sexe = prompt('sexe (h ou f) :');

// while (isNaN(age) || (sexe !== 'h' && sexe !== 'f')) {
//     alert('veuillez renseigner correctement les champs.');
//     age = parseInt(prompt('age :'));
//     sexe = prompt('sexe (h ou f) :');
// }

// if ((age > 20 && sexe === 'h') || (age >= 18 && age <= 35 && sexe === 'f')) {
//     alert('tu es imposable.');
// } else {
//     alert('tu nes pas imposable.');
// }
// var div = document.getElementById('horloge');
// let candidat1 = Math.random()*100;
// let candidat2 = Math.random()*(100-candidat1);
// let candidat3 = Math.random()*(100-(candidat1+candidat2));
// let candidat4 = 100-(candidat1+candidat2+candidat3);
// if(candidat1>50){
//     div.innerHTML = `youpi tu as gagné`
// }
// else if(candidat1>= 12.5 && candidat2<51 || candidat3<51 || candidat4<51 && (candidat1>candidat2&&candidat1>candidat3&&candidat1>candidat4)){
//     div.innerHTML = "recu pour second tour FAVORABLE"
// }
// else if(candidat1>= 12.5 && candidat2<51 || candidat3<51 || candidat4<51 && (candidat1<candidat2||candidat1<candidat3||candidat1<candidat4)){
//     div.innerHTML = "recu pour second tour t'es nul quand meme"
// }

// else{
//     div.innerHTML = `bouh t'es nul`
// }

// let bouton1 = document.getElementById('cd1');
//     bouton1.value=0;

// function premierTour() {
//     let premierCandidat = parseFloat(document.getElementById('number').value);
//     let secondCandidat = parseFloat(document.getElementById('candidat2').value);
//     let troisiemeCandidat = parseFloat(document.getElementById('candidat3').value);
//     let quatriemeCandidat = parseFloat(document.getElementById('candidat4').value);


//     if (premierCandidat > 50) {
//         document.getElementById('reponse').textContent = `Félicitation ! vous avez eu un score de : ${premierCandidat}% au premier tour. Vous êtes l'elu` ;
//     } 
//     else if (premierCandidat >= 12.5 && premierCandidat > secondCandidat && premierCandidat > troisiemeCandidat && premierCandidat > quatriemeCandidat){
//         document.getElementById('reponse').textContent = `Vous avez eu un score de : ${premierCandidat}% au premier tour. Vous êtes FAVORABLE au second tour`;
//     }
//     else if (premierCandidat >= 12.5 && (premierCandidat < secondCandidat || premierCandidat < troisiemeCandidat || premierCandidat < quatriemeCandidat)) {
//         document.getElementById('reponse').textContent = `Dommage ! vous avez eu un score de : ${premierCandidat}% au premier tour. Vous passer le second tour mais DEFAVORABLE`;
//     }
//     else {
//         document.getElementById('reponse').textContent = `Dommage ! vous avez eu un score de : ${premierCandidat}% au premier tour. Vous ne passer pas le second tour`;
//     }
// }


// document.getElementById('btnMag').addEventListener('click', premierTour);


    

// var div = document.getElementById('election')
// var reponse = document.getElementById('number');

// reponse.addEventListener('click', ()=>{
//     var age = parseInt(document.getElementById('age').value);
//     var permis = parseInt(document.getElementById('agep').value);
//     var anciennete = parseInt(document.getElementById('anciennete').value);
//     var accident = parseInt(document.getElementById('accident').value);
    
// if(age>25 && permis>2){
//     if(accident == 0){
//         div.innerHTML = 'vert' 
//     }
//     else if(accident == 1){
//         div.innerHTML = 'orange'
//     }
//     else if(accident > 1){
//         div.innerHTML = 'rouge'
//     }
// }
// if((age<=25 && permis>2) || (age>25 && permis<2) ){
//     if(accident == 0){
//         div.innerHTML = 'orange' 
//     }
//     else if(accident == 1){
//         div.innerHTML = 'rouge'
//     }
//     else if(accident > 1){
//         div.innerHTML = 'refusé'
//     }
// }

// if(age<25 && permis<2){
//     if(accident == 0){
//         div.innerHTML = 'rouge' 
//     }
//     else if(accident > 0){
//         div.innerHTML = 'refusé'
//     }
// }

// if(anciennete>5){
//     if(div.innerHTML == 'vert'){
//         div.innerHTML = 'bleu'
//     }
//     else if(div.innerHTML == 'orange'){
//         div.innerHTML = 'vert'
//     }
//     else if(div.innerHTML == 'rouge'){
//         div.innerHTML = 'orange'
//     }
// }})

// var jour = parseInt(prompt('nombre du jour'));
// var mois = parseInt(prompt('nombre du mois'));
// var annee = parseInt(prompt('annee'));

// function dateValide(annee, mois, jour) {
//     var date;
//     let joursParMois = [31, (annee % 4 == 0 && (annee % 100 != 0 || annee % 400 == 0)) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

//     if (mois < 1 || mois > 12 || jour < 1 || jour > joursParMois[mois - 1]) {
//         date = false;
//     }
//     else{
//         date = true;
//     }
    
//  if (date) {
//     document.write(`La date ${jour}/${mois}/${annee} est valide.`);
// } else {
//     document.write(`La date ${jour}/${mois}/${annee} n'est pas valide.`);
// }

// }
// dateValide(annee, mois, jour);

// var number = parseInt(prompt("chiffre"));

// function countArara(param) {

//     return param%2==0 ? "adak ".repeat(param/2) : "adak ".repeat(param/2)+'anane';
    
// }

// console.log(countArara(1));
// console.log(countArara(3));
// console.log(countArara(8));

// // function whoseMove(x,y)
// // { 
// //    return y?x:(x==='black'?'white':'black')
// // }
// // console.log(whoseMove('black', false));

// function transforme(texte) {
//     // return texte.split('').map((lettre, index) => lettre.toUpperCase() + lettre.toLowerCase().repeat(index)).join('-');
//     return Array.from(texte)
// }


// console.log(transforme('aRcA'));




// let prix = parseInt(prompt('chiffre'));
// let appreciation = prompt('entrer appreciation').toLowerCase();
// function pourboire(prix, appreciation){
// switch(appreciation){
//     case 'terrible':
//         return console.log(prix*0);
        
    
//     case 'poor':
//         return console.log(prix*0.05);
       
//     case 'good':
//         return console.log(prix*0.1);
        
    
//     case 'great':
//         return console.log(prix*0.15);
        
    
//     case 'excellent':
//         return console.log(prix*0.2);
    
    
// }}



function mot(param){
    return param.replace(/\b\w/g, function(element) {
    return element.toUpperCase();})}


console.log(mot('ceci est une phrase'));