import { Card, Modal } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import { useState } from "react";
import Boutton from './boutton'
function Pokemon({ poke }) {
  const statsKey = Object.keys(poke.stats);
  const statsValue = Object.values(poke.stats);
  
  const Stat = () => {
      return (
        <table className="d-flex">
        
        { statsKey.map((key, index)=>(
          <tbody key={index}>
           <tr className="border">
            <td>{key}</td>
          </tr>
          <tr className="border">
            <td>{statsValue[index]}</td>
          </tr>
          </tbody>
        ))
         }
        
        </table>
      ); 
  };
  const type = poke.apiTypes;

  const [fenetre, setFenetre] = useState(false);


  const toggleModal = ()=> setFenetre(!fenetre);




  return (
    <div className="d-flex">
   
          <Card>
            <Card.Body onClick={toggleModal}>
              <img src={poke.image} alt="" />
            </Card.Body>
            <Card.Footer>
              <Boutton poke={poke} />
            </Card.Footer>
          </Card>
          <Modal show={fenetre} onHide={toggleModal}>
            <Modal.Body className="d-flex flex-column">
              <h1>{poke.name}</h1>
              <img src={poke.image} alt="" />
              <p>{poke.stat}</p>
              <div className="d-flex flex-wrap">
                {type.map((types, index) => (
                  <div key={index}>
                    <div>{types.name}</div>
                    <img className="w-25" src={types.image} alt="" />
                  </div>
                ))}
                <Stat />
              </div>
            </Modal.Body>
          </Modal>
      </div>
      
    
  );
}

export default Pokemon;
