
import {
    fetchPopfilm,
    rechercheFilm,
    pagePrevi,
    pageSuiva,
    rechercheTvs,
    rechercheTves,
    FETCH_FILM_DETAILS,
    FETCH_SERIE_DETAILS,
    rechercheTvModale,
    rechercheFilmModale,
  } from "./typeaction";
  

  const etatInitial = {
    tvModale:[],
    filmModale:[],
    filmDetail: [],
    film: [],
    recherche: '',
    page: 1,
    totalPage: 1,
    tv: [],
    serieDetail: [],
};

const reducer = (state = etatInitial, action) => {
    switch (action.type) {
        case FETCH_FILM_DETAILS: 
        return {
          ...state,
          filmDetail: action.payload, 
        };
        case fetchPopfilm:
            return {
                ...state,
                film: action.payload.film,
                page: action.payload.page,
                recherche: '',
                totalPage: action.payload.totalPage,
            };
        case rechercheFilm:
            return {
                ...state,
                film: action.payload.film,
                recherche: action.payload.recherche,
                page: action.payload.page,
                totalPage: action.payload.totalPage,
            };
        case rechercheFilmModale:
            return {
                ...state,
                filmModale: action.payload.film,
                recherche: action.payload.recherche,
                page: action.payload.page,
                totalPage: action.payload.totalPage,
            };
            case rechercheTvModale:
                return {
                    ...state,
                    tvModale: action.payload.tv,
                    recherche: action.payload.recherche,
                    page: action.payload.page,
                    totalPage: action.payload.totalPage,
                };
        case rechercheTvs:
            return {
                ...state,
                recherche:'',
                tv: action.payload.tv,
                page: action.payload.page,
                totalPage: action.payload.totalPage,
            };
        case FETCH_SERIE_DETAILS:
            return {
                ...state,
                serieDetail: action.payload,
              };
            
        case rechercheTves:
            return {
                ...state,
                tv: action.payload.tv,
                recherche: action.payload.recherche,
                page: action.payload.page,
                totalPage: action.payload.totalPage,
            };
        case pageSuiva:
            return {
                ...state,
                page: state.page + 1,
            };
        case pagePrevi:
            return {
                ...state,
                page: state.page - 1,
            };
        default:
            return state;
    }
};


  
  export default reducer;
  