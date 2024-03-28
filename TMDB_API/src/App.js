import "bootstrap/dist/css/bootstrap.min.css";
import { useSelector, useDispatch } from "react-redux";
import {
  fetchPopfilms,
  rechercheFilms,
  rechercheTv,
  recherchesTv,
} from "./action";
import { useEffect } from "react";
import Bouton from "./composants/bouton";
import { useState } from "react";
import { BrowserRouter, Routes, Route, Link, useNavigate } from "react-router-dom";
import Film from "./composants/film";
import Footer from "./footer";
import Detail from "./composants/detail";


function App() {
  const dispatch = useDispatch();
  const recherche = useSelector((state) => state.reducer.recherche);
  const film = useSelector((state) => state.reducer.film);
  const page = useSelector((state) => state.reducer.page);
  const tvs = useSelector((state) => state.reducer.tv);
  const [results, setResults] = useState([]);
  const [isButtonChecked, setIsButtonChecked] = useState(0);

  const handleSearchTv = () => {
  
    if (!recherche) {
      dispatch(rechercheTv(1));
     
    } else {
      dispatch(recherchesTv(recherche, 1));
    }
  };

  const handleHome = () => {
    if (!recherche) {
      dispatch(fetchPopfilms(1));
      dispatch(rechercheTv(1));
    } else {
      dispatch(rechercheFilms(recherche, 1));
      dispatch(recherchesTv(recherche, 1));
    }
  };

  const handleSearchFilm = () => {

    if (!recherche) {
      dispatch(fetchPopfilms(1));
    } else {
      dispatch(rechercheFilms(recherche, 1));
    }
    
  };

  useEffect(() => {
    if (!recherche) {
      dispatch(fetchPopfilms(page));
      dispatch(rechercheTv(page));
    } else {
      if (isButtonChecked == 0) {
        dispatch(rechercheFilms(recherche, page));
        dispatch(recherchesTv(recherche, page));
      } else if (isButtonChecked == 1) {
        dispatch(recherchesTv(recherche, page));
      } else if (isButtonChecked == 2) {
        dispatch(rechercheFilms(recherche, page));
      }
    }
  }, [recherche, page]);

  useEffect(() => {
    setResults([...film, ...tvs]);
    if (isButtonChecked == 1) {
      setResults([...tvs]);
    } else if (isButtonChecked == 2) {
      setResults([...film]);
    }
  }, [film, tvs]);

console.log(page);

  return (
    <BrowserRouter>
    <div>
      <input
        type="text"
        value={recherche}
        placeholder="...recherche"
        onChange={(event) => dispatch(rechercheFilms(event.target.value, 1))}
      />
    <Footer setIsButtonChecked={setIsButtonChecked} handleHome={handleHome} handleSearchTv={handleSearchTv} handleSearchFilm={handleSearchFilm}/>
      
      <Routes>
        <Route path='/film' element={<Film results={results}/>}/>
        <Route path="/detail/:id" element={<Detail />}/>
      </Routes>
      <Bouton />
    
    </div>
    </BrowserRouter>
  );
}

export default App;
