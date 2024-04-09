import 'bootstrap/dist/css/bootstrap.min.css';
import { Card } from 'react-bootstrap';
import { useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { fetchSerieDetails } from '../action'; 

function DetailSerie() {
  const { id } = useParams();
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(fetchSerieDetails(id)); 
  }, [id, dispatch]);

  const serie = useSelector((state) => state.reducer.serieDetail);
console.log(serie);
  return (
  <div className='d-flex justify-content-center align-items-center w-100 h-auto ' style={{height:'35rem'}}>
<Card className='bg-secondary text-white w-50 mx-auto my-4 pe-5 ps-5 pt-3 pb-5 rounded border-5'>
  {serie && (
    <div className='d-flex flex-column align-items-center'>
      <h1 className='mb-3'>{serie.original_name}</h1>
      <img
        className='mb-3 img-fluid rounded border border-dark '
        src={`https://image.tmdb.org/t/p/w500/${serie.poster_path}`}
        alt={serie.title}
      />
      <p className='text-center fs-5 '>{serie.overview}</p>
    </div>
  )}
</Card>
</div>
  );
}

export default DetailSerie;
