import 'bootstrap/dist/css/bootstrap.min.css';
import { Card } from 'react-bootstrap';
import { useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { fetchFilmDetails } from '../action'; // Assure-toi d'importer fetchFilmDetails

function Detail() {
  const { id } = useParams();
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(fetchFilmDetails(id)); // Ajoute id comme dépendance
  }, [id, dispatch]); // Ajoute dispatch comme dépendance

  const film = useSelector((state) => state.reducer.filmDetail);
  console.log(film);

  return (
    <div className='d-flex justify-content-center align-items-center w-100 h-auto ' style={{height:'35rem'}}>
<Card className='bg-secondary text-white w-50 mx-auto my-4 pe-5 ps-5 pt-3 pb-5 rounded border-5'>
  {film && (
    <div className='d-flex flex-column align-items-center'>
      <h1 className='mb-3'>{film.title}</h1>
      <img
        className='mb-3 img-fluid rounded border border-dark '
        src={`https://image.tmdb.org/t/p/w500/${film.poster_path}`}
        alt={film.title}
      />
      <p className='text-center fs-5 '>{film.overview}</p>
    </div>
  )}
</Card>
</div>
  );
}

export default Detail;
