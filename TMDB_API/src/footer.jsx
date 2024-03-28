import React from "react";
import { useNavigate } from "react-router-dom";


const Footer = ({setIsButtonChecked, handleHome, handleSearchTv, handleSearchFilm}) => {
  const navigate = useNavigate();
function handleclick(){
  navigate('/film')
}  
  return (
    <>
     <button
        onClick={() => {
          setIsButtonChecked(0);
          handleHome();
        }}
      >
        Home
      </button>
      <button
        onClick={() => {
          setIsButtonChecked(1);
          handleSearchTv();
        }}
      >
        Série
      </button>
      
      <button
        onClick={() => {
          handleclick();
          setIsButtonChecked(2);
          handleSearchFilm();

        }}
      >
        film
      </button>
      
    </>
  );
};

export default Footer;