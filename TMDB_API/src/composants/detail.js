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
    <div>
      <Card>
        {film && (
          <img
            style={{ width: "35rem" }}
            src={`https://image.tmdb.org/t/p/w500/${film.poster_path}`}
            alt={film.title}
          />
        )}
      </Card>
    </div>
  );
}

export default Detail;
