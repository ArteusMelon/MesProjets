function mot(param){
    return param.replace(/\b\w/g, (element)=> element.toUpperCase())}

console.log(mot('ceci est une phrase'));