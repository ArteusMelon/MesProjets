import { useState } from "react"
import {Card, Modal, Button} from 'react-bootstrap'

function Favoris(){
    
    const[favorites, setFavorites] = useState(JSON.parse(localStorage.getItem('favorites'))||[]);

    const removeFav=(id)=>{
        const updateFav = favorites.filter(poke=>poke.id!==id);
        setFavorites(updateFav);
        localStorage.setItem('favorites', JSON.stringify(updateFav));
    }


    return(
        <div>
        {favorites.map(poke=>(
            <div>
          <Card>
            <Card.Body >
              <img src={poke.image} alt="" />
              <Button onClick={()=>removeFav(poke.id)}> remove </Button>
            </Card.Body>
            
          </Card>
          <Modal >
            <Modal.Body className="d-flex flex-column">
              <h1>{poke.name}</h1>
              <img src={poke.image} alt="" />
              <p>{poke.stat}</p>
              <div className="d-flex flex-wrap">
               
              </div>
            </Modal.Body>
          </Modal></div>))}
        </div>
    )
}

export default Favoris