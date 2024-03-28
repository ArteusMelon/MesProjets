import 'bootstrap/dist/css/bootstrap.min.css'
import {Card} from 'react-bootstrap';
import { useSelector } from 'react-redux';
import { useParams } from 'react-router-dom';


function Detail(){

    const movie = useSelector((state)=>state.reducer.film)
    const {id} = useParams();
    const film = movie.find((movies)=>movies.id==id)


    return(
        <>
            <Card>
          
        {film&&<img
          style={{ width: "35rem" }}
          src={`https://image.tmdb.org/t/p/w500${film.poster_path}`}
        />}
      
        </Card>

        </>
    )
}

export default Detail;