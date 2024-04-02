import 'bootstrap/dist/css/bootstrap.min.css';
import {Card} from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import Bouton from './bouton';
function Serie({results}){
  const navigate = useNavigate();

function handleClick(item){
  navigate(`/detailSerie/${item.id}`)
}

return (
  <>
    {results.map((item) => (
      <Card key={item.id} onClick={() => handleClick(item)}>
        <img
          style={{ width: "35rem" }}
          src={`https://image.tmdb.org/t/p/w1280/${item.poster_path}`}
          alt={item.title}
        />
      </Card>
    ))}
    <Bouton />
  </>
);
}
export default Serie;