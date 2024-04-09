import "bootstrap/dist/css/bootstrap.min.css";
import { useSelector, useDispatch } from "react-redux";
import {
  fetchPopfilms,
  rechercheFilms,
  rechercheFilmsModal,
  rechercheTv,
  recherchesTv,
  recherchesTvModal,
} from "./action";
import { useEffect } from "react";
import { useState } from "react";
import { BrowserRouter, Routes, Route,} from "react-router-dom";
import Film from "./composants/film";
import Footer from "./footer";
import Detail from "./composants/detail";
import Serie from "./composants/serie";
import DetailSerie from "./composants/detailSerie";
import Home from "./composants/home";


function App() {
  const dispatch = useDispatch();
  const recherche = useSelector((state) => state.reducer.recherche);
  const film = useSelector((state) => state.reducer.film);
  const filmModale = useSelector((state) => state.reducer.filmModale);
  const page = useSelector((state) => state.reducer.page);
  const tvs = useSelector((state) => state.reducer.tv);
  const tvsModale = useSelector((state) => state.reducer.tvModale);
  const [results, setResults] = useState([]);
  const [results2, setResults2]= useState([]);

  const [isButtonChecked, setIsButtonChecked] = useState(0);
  console.log(results2);
  const handleSearchTv = () => {
  
    if (!recherche) {
      dispatch(rechercheTv(1));
     
    } else {
      dispatch(recherchesTv(recherche, 1));
    }
  };

  const handleHome = () => {
    
      dispatch(fetchPopfilms(1));
      dispatch(rechercheTv(1));
    
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
        dispatch(rechercheFilmsModal(recherche, page));
        dispatch(recherchesTvModal(recherche, page));
      } else if (isButtonChecked == 1) {
        dispatch(recherchesTv(recherche, page));
        dispatch(recherchesTvModal(recherche, page));
      } else if (isButtonChecked == 2) {
        dispatch(rechercheFilms(recherche, page));
        dispatch(rechercheFilmsModal(recherche, page));
      }
    }
  }, [recherche, page]);

  useEffect(() => {
    setResults2([...filmModale, ...tvsModale]);
    setResults([...film, ...tvs]);
    if (isButtonChecked == 1) {
      setResults([...tvs]);
    } else if (isButtonChecked == 2) {
      setResults([...film]);
    }
  }, [film, tvs, filmModale, tvsModale]);


  return (
    <BrowserRouter>
    <div>
    <Footer setResults2={setResults2} results2={results2} isButtonChecked={isButtonChecked} recherche={recherche} dispatch={dispatch} setIsButtonChecked={setIsButtonChecked} handleHome={handleHome} handleSearchTv={handleSearchTv} handleSearchFilm={handleSearchFilm}/>
      <Routes>
        <Route path="/" element={<Home results={results}/>}/>
        <Route path="/serie" element={<Serie results={results}/>}/>
        <Route path='/film' element={<Film results={results}/>}/>
        <Route path="/detail/:id" element={<Detail />}/>
        <Route path="/detailSerie/:id" element={<DetailSerie />}/>
      </Routes>
    
    </div>
    </BrowserRouter>
  );
}

export default App;
