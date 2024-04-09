import {useSelector, useDispatch} from 'react-redux';
import { pagePrev, pageSuiv } from '../action';

function Bouton(){
    const dispatch = useDispatch();
    const totalPage= useSelector((state)=>state.reducer.totalPage);
    const page = useSelector((state)=>state.reducer.page);

    return(
    <div className="d-flex justify-content-center align-items-center gap-4 mb-4 mt-5">
        <button className='btn btn-primary' onClick={()=> dispatch(pagePrev())}>Page précédente</button>
        {page} sur {totalPage}
        <button className='btn btn-primary' onClick={() => dispatch(pageSuiv())}>Page suivante</button>
    </div>    
    )
}

export default Bouton;