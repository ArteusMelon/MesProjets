let nom = document.getElementsByClassName('nom');
let age = document.getElementsByClassName('age');
let type = document.getElementsByClassName('type');
let btn = document.getElementsByClassName('btn');
let form = document.getElementsByClassName('form');
let btnV = document.getElementsByClassName('btnV');
let recherche = document.getElementById('search');

for (let i = 0; i < btn.length; i++) {
    btn[i].addEventListener('click', () => {
        if (nom[i].disabled) {
            nom[i].disabled = false;
            age[i].disabled = false;
            type[i].disabled = false;
            btnV[i].style.display = 'inline';
        }
    });
}

