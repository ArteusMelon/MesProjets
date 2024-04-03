
import 'bootstrap/dist/css/bootstrap.min.css';
import {Card} from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import Bouton
 from './bouton';
function Film({results}){
  const navigate = useNavigate();

function handleClick(item){
  navigate(`/detail/${item.id}`)
}

return (
 <>
  <div className='d-flex flex-wrap justify-content-center mt-4'>
    {results.map((item) => (
      <Card className='m-3' key={item.id} onClick={() => handleClick(item)}>
        <img className='img-fluid'
          style={{ width: "20rem" }}
          src={`https://image.tmdb.org/t/p/w1280/${item.poster_path}`}
          alt={item.title}
        />
      </Card>
    ))}
    
  </div>
  <Bouton />
  </>
);
}

export default Film;