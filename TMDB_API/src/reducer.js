
import { fetchPopfilm, rechercheFilm, pagePrevi, pageSuiva, rechercheTvs, rechercheTves} from "./typeaction"

const etatInitial = {
    film : [],
    recherche : '',
    page : 1,
    tv:[],
}

const reducer = (state=etatInitial, action)=>{
    switch(action.type){
        case fetchPopfilm : return{
            ...state,
            film: action.payload.film,
            page: action.payload.page,
            recherche:'',
           totalPage: action.payload.totalPage
            
        }
        case rechercheFilm : return{
            ...state,
            film: action.payload.film,
            recherche: action.payload.recherche,
            page: action.payload.page,
            totalPage: action.payload.totalPage
           
        }
        case rechercheTvs : return{
            ...state,
            tv: action.payload.tv,
            page: action.payload.page,
            totalPage: action.payload.totalPage
            
            
        }
        case rechercheTves : return{
            ...state,
            tv: action.payload.tv,
            page: action.payload.page,
            totalPage: action.payload.totalPage
           
        }
        case pageSuiva : return{
            ...state,
            page: state.page+1
        }
        case pagePrevi : return{
            ...state,
            page : state.page-1
        }
        
        default: return state
    }
}

export default reducer;