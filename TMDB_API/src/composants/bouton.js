import {useSelector, useDispatch} from 'react-redux';
import { pagePrev, pageSuiv, resetPage } from '../action';

function Bouton(){
    const dispatch = useDispatch();
    const totalPage= useSelector((state)=>state.reducer.totalPage);
    const page = useSelector((state)=>state.reducer.page);

    return(
    <div>
        <button onClick={()=> dispatch(pagePrev)}>Page précédente</button>
        {page} sur {totalPage}
        <button onClick={() => dispatch(pageSuiv)}>Page suivante</button>
    </div>    
    )
}

export default Bouton;