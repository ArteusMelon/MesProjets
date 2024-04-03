
import 'bootstrap/dist/css/bootstrap.min.css';
import {Card, Carousel} from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

function Home({results}){
const films = results.filter(item => item.media_type === 'movie');
const series = results.filter(item => item.media_type === 'tv');    
  const navigate = useNavigate();


function handleClickFilm(item){
  navigate(`/detail/${item.id}`)
}
function handleClickSerie(item){
    navigate(`/detailSerie/${item.id}`)
}

return (
    <div className='d-flex flex-column align-items-center mt-4'>
    <h1>Films tendances</h1>
    <Carousel className='d-flex flex-wrap justify-content-center' interval={null}>
  {films.map((film, index) => (
    index % 5 === 0 && (
      <Carousel.Item key={index}>
        <div className="d-flex">
          {films.slice(index, index + 5).map((film, filmIndex) => (
            <Card className='m-3' key={filmIndex} onClick={() => handleClickFilm(film)}>
              <img className='img-fluid'
                style={{ width: "35rem" }}
                src={`https://image.tmdb.org/t/p/w1280/${film.poster_path}`}
                alt={film.title}
              />
            </Card>
          ))}
        </div>
      </Carousel.Item>
    )
  ))}
</Carousel>

<h1>Series tendances</h1>
<Carousel className='d-flex flex-wrap justify-content-center' interval={null}>
  {series.map((serie, index) => (
    index % 5 === 0 && (
      <Carousel.Item key={index}>
        <div className="d-flex">
          {series.slice(index, index + 5).map((serie, serieIndex) => (
            <Card className='m-3' key={serieIndex} onClick={() => handleClickSerie(serie)}>
              <img className='img-fluid'
                style={{ width: "35rem" }}
                src={`https://image.tmdb.org/t/p/w1280/${serie.poster_path}`}
                alt={serie.title}
              />
            </Card>
          ))}
        </div>
      </Carousel.Item>
    )
  ))}
</Carousel>
  </div>
);
}

export default Home;