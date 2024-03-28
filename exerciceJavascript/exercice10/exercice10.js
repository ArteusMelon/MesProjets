function countArara(param) {

    return param%2==0 ? "adak ".repeat(param/2) : "adak ".repeat(param/2)+'anane';
    
}

console.log(countArara(1));
console.log(countArara(3));
console.log(countArara(8));