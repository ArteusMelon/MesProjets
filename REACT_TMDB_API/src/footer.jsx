import React, { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import { useState } from "react";
import { Card, Modal } from "react-bootstrap";
import { useSelector} from "react-redux";
import { rechercheFilmsModal, recherchesTvModal } from "./action";


const Footer = ({results2, isButtonChecked ,recherche, dispatch, setIsButtonChecked, handleHome, handleSearchTv, handleSearchFilm}) => {

 const page = useSelector((state)=>state.reducer.page);
  const navigate = useNavigate();
  const [showModal, setShowModal] = useState(false);
  



function handleclickHome(){
  navigate('/')
}
function handleclick(){
  navigate('/film')
}
function handleclickSerie(){
  navigate('/serie')
}    
const handleRecherche = () => {
  // Fonction pour afficher les résultats de la recherche dans le modal
  setShowModal(true);
};

function handleClickFilm(item){
  navigate(`/detail/${item.id}`)
}
function handleClickSerie(item){
    navigate(`/detailSerie/${item.id}`)
}
  return (
  <>
  <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <div className="container">
      <button
  className={`btn btn-primary ${isButtonChecked === 0 ? 'active' : ''}`}
  onClick={() => {
    setIsButtonChecked(0);
    handleclickHome();
    handleHome();
  }}
>
  <i className="bi bi-house-fill"></i> Home
</button>
        
        <button
          className={`btn ${isButtonChecked === 1 ? 'active' : ''}`}
          onClick={() => {setIsButtonChecked(1);
                          handleclickSerie();
                          handleSearchTv();}}
        >
          Série
        </button>
        <button
          className={`btn ${isButtonChecked === 2 ? 'active' : ''}`}
          onClick={() => {setIsButtonChecked(2);
                          handleclick();
                          handleSearchFilm();}}
        >
          Film
        </button>
        <button
            className="btn btn-primary"
            onClick={handleRecherche}
          >
            Rechercher
          </button>
       
      </div>
    </nav>
    <Modal dialogClassName="modal-fullscreen" show={showModal} onHide={() => setShowModal(false)}>
   
    <Modal.Header closeButton className="flex-grow-1 mx-3 d-flex flex-column">
          <input 
            type="text"
            className="form-control w-50"
            value={recherche}
            placeholder="Recherche..."
            onChange={(event)=>{dispatch(rechercheFilmsModal(event.target.value, page));
              dispatch(recherchesTvModal(event.target.value, page));} }
           
          />
      <Modal.Title className="mt-4">Résultats de la recherche pour "{recherche}"</Modal.Title>
    </Modal.Header>
    <Modal.Body className="d-flex flex-wrap justify-content-center">
    {results2.map((item) => (
      <Card className="m-3" key={item.id} onClick={() =>{item.media_type === "movie" ?  handleClickFilm(item) : handleClickSerie(item);
      setShowModal(false)}}>
        <img className="img-fluid"
          style={{ width: "15rem" }}
          src={item.poster_path ? `https://image.tmdb.org/t/p/w1280/${item.poster_path}`:''}
          alt={item.title}
        />
      </Card>
    ))}
    </Modal.Body>
    <Modal.Footer>
      <button className="btn btn-primary" variant="secondary" onClick={() => setShowModal(false)}>
        Fermer
      </button>
    </Modal.Footer>
   
  </Modal>
  </>
  );
};

export default Footer;