
import 'bootstrap/dist/css/bootstrap.min.css';
import {Card} from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

function Film({results}){
  const navigate = useNavigate();

function handleClick(item){
  navigate(`/detail/${item.id}`)
}

    return(
        <Card onClick={()=>handleClick(results)}>
         {results.map((item) => ( 
        <img
          style={{ width: "35rem" }}
          key={item.id}
          src={`https://image.tmdb.org/t/p/w1280/${item.poster_path}`}
        /> ))}
    
        </Card>
    )
}

export default Film;