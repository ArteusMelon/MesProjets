import {
  fetchPopfilm,
  rechercheFilm,
  pageSuiva,
  pagePrevi,
  rechercheTvs,
  rechercheTves,
  FETCH_FILM_DETAILS,
  FETCH_SERIE_DETAILS,
  rechercheTvModale,
  rechercheFilmModale
} from "./typeaction";
import axios from "axios";
const api_key = process.env.REACT_APP_API_KEY;

export const fetchFilmDetails = (filmId) => {
  return async (dispatch) => {
    try {
      const response = await axios.get(
        `https://api.themoviedb.org/3/movie/${filmId}?api_key=${api_key}`
      );

      dispatch({
        type: FETCH_FILM_DETAILS,
        payload: response.data 
      });
    } catch (error) {
      console.error("Error fetching film details:", error);
    }
  };
};
export const fetchSerieDetails = (serieId) => {
  return async (dispatch) => {
    try {
      const response = await axios.get(
        `https://api.themoviedb.org/3/tv/${serieId}?api_key=${api_key}`
      );

      dispatch({
        type: FETCH_SERIE_DETAILS,
        payload: response.data
      });
    } catch (error) {
      console.error("Error fetching serie details:", error);
    }
  };
};
export const fetchPopfilms = (page) => {
  return async (dispatch) => {
    const reponse = await axios.get(
      `https://api.themoviedb.org/3/trending/movie/day?api_key=${api_key}&page=${page}`
    );
    dispatch({
      type: fetchPopfilm,
      payload: { page, film: reponse.data.results, totalPage: reponse.data.total_pages  },
    });
  };
};
export const rechercheFilms = (recherche, page) => {
  return async (dispatch) => {
    const reponse = await axios.get(
      `https://api.themoviedb.org/3/search/movie?api_key=${api_key}&page=${page}&query=${recherche}`
    );
    dispatch({
      type: rechercheFilm,
      payload: { recherche, page, film: reponse.data.results, totalPage: reponse.data.total_pages  },
    });
  };
};
export const rechercheTv = (page) => {
  return async (dispatch) => {
    const reponse = await axios.get(
      `https://api.themoviedb.org/3/trending/tv/day?api_key=${api_key}&page=${page}`
    );
    dispatch({
      type: rechercheTvs,
      payload: { page, tv: reponse.data.results, totalPage: reponse.data.total_pages  },
    });
  };
};
export const recherchesTv = (recherche,page) => {
  return async (dispatch) => {
    const reponse = await axios.get(
      `https://api.themoviedb.org/3/search/tv?api_key=${api_key}&page=${page}&query=${recherche}`
    );
    dispatch({
      type: rechercheTves,
      
      payload: { recherche, page, tv: reponse.data.results, totalPage: reponse.data.total_pages },
    });
  };
};
export const recherchesTvModal = (recherche,page) => {
  return async (dispatch) => {
    const reponse = await axios.get(
      `https://api.themoviedb.org/3/search/tv?api_key=${api_key}&page=${page}&query=${recherche}`
    );
    dispatch({
      type: rechercheTvModale,
      
      payload: { recherche, page, tv: reponse.data.results, totalPage: reponse.data.total_pages },
    });
  };
};
export const rechercheFilmsModal = (recherche, page) => {
  return async (dispatch) => {
    const reponse = await axios.get(
      `https://api.themoviedb.org/3/search/movie?api_key=${api_key}&page=${page}&query=${recherche}`
    );
    dispatch({
      type: rechercheFilmModale,
      payload: { recherche, page, film: reponse.data.results, totalPage: reponse.data.total_pages  },
    });
  };
};


export const pageSuiv = {type:pageSuiva};
export const pagePrev = {type:pagePrevi};

