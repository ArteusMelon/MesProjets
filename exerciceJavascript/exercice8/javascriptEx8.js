let prix = parseInt(prompt('chiffre'));
let appreciation = prompt('entrer appreciation').toLowerCase();
function pourboire(prix, appreciation){
switch(appreciation){
    case 'terrible':
      return prix*0;
      
    case 'poor':
       return Math.ceil(prix*0.05);
       
    
    case 'good':
       return Math.ceil(prix*0.1);
      
    
    case 'great':
        return Math.ceil(prix*0.15);
       
    
    case 'excellent':
        return Math.ceil(prix*0.2);
    
    default :
        return  'service non reconnu'
}}

console.log(pourboire(prix, appreciation));