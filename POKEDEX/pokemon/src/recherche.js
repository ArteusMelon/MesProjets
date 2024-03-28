import React, { useState } from 'react';
import Navbar from 'react-bootstrap/Navbar';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';


function RechercheP({setRecherche, handlePokemonClick }) {
    const [searchTerm, setSearchTerm] = useState('');

    const handleChange = (event) => {
        setSearchTerm(event.target.value);
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        setRecherche(searchTerm);
    };
    
    return (
        // <form onSubmit={handleSubmit}>
        //     <input
        //         value={searchTerm}
        //         onChange={handleChange}
        //         placeholder="...Rechercher"
        //         type="text"
        //     />
        //     <input type="submit" value="Envoyer" />
        // </form>
    <Navbar className="bg-danger justify-content-between w-100">
       <h1 className='d-Flex ms-5 text-white'>POKEDEX</h1>      
      <Form onSubmit={handleSubmit} className='d-flex justify-content-end w-100 me-5'>
        <Row>
          <Col xs="auto">
            <Button onClick={handlePokemonClick} >Favoris</Button>
          </Col>
          <Col xs="auto">
            <Form.Control
              type="search"
              placeholder="Search"
              value={searchTerm}
              onChange={handleChange}
            />
          </Col>
          <Col xs="auto">
            <Button className='bg-white text-black ' type="submit">Submit</Button>
          </Col>
        </Row>
      </Form>
    </Navbar>
  );
}



export default RechercheP;