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
    <div>
      <Card>
        {serie && (
          <img
            style={{ width: "35rem" }}
            src={`https://image.tmdb.org/t/p/w500/${serie.poster_path}`}
            alt={serie.title}
          />
        )}
      </Card>
    </div>
  );
}

export default DetailSerie;
