import { useEffect, useState } from "react";
import axios from "axios";
import Pokemon from "./pokemoncard";
import RechercheP from "./recherche";
import "bootstrap/dist/css/bootstrap.min.css";
import Favoris from "./favoris";

function App() {
  const [vue, setVue] = useState("main");
  const [pokemon, setPokemon] = useState([]);
  const [recherche, setRecherche] = useState("");
  const  [page, setPage] = useState(1)
  const nbrPokeAff=15;
  const [nbre,setNbre]=useState([]);
  const handlePokemonClick = () => {
    setVue("details");
  };

  useEffect(() => {
    if (!recherche) {

      axios
        .get(`https://pokebuildapi.fr/api/v1/pokemon `)
        .then((reponse) => (setNbre(reponse.data)));
        
    } else {
      axios
        .get(`https://pokebuildapi.fr/api/v1/pokemon/${recherche}`)
        .then((reponse) => setPokemon(reponse.data));
    }
    
    
  }, [recherche]);

  useEffect(() => {
  if (nbre.length > 0) {
    setPokemon(nbre.slice(nbrPokeAff * (page - 1), nbrPokeAff * page));
  }
}, [page, nbre]);
  
  return (
    <div className="App ">
      
      {vue === "main" && (
        <div>
          <div className="d-flex justify-content-center">
            <RechercheP setRecherche={setRecherche} setPokemon={setPokemon} handlePokemonClick={handlePokemonClick} />
          </div>
          <div className="d-flex flex-wrap justify-content-evenly">
            {Array.isArray(pokemon) ? (
              pokemon.map((poke) => {
                return (
                  <Pokemon key={poke.id} poke={poke}  />
                );
              })
            ) : (
              <Pokemon key={pokemon.id} poke={pokemon}  />
            )}
            <button onClick={()=>setPage(page-1)}>precedent</button>{page}<button onClick={()=>setPage(page+1)}>suivant</button>
          </div>{" "}
        </div>
      )}
      {vue==='details' &&(<Favoris pokemon={pokemon}/>

      )}
    </div>
  );
}

export default App;
