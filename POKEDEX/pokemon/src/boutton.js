import { Button } from 'react-bootstrap';

function Boutton({ poke }) {

    const handleAddToFavorites = () => {
        const favorites = JSON.parse(localStorage.getItem('favorites'))|| [];
        const isAlreadyFavorites = favorites.some((favorite) => favorite.id === poke.id);
        if (!isAlreadyFavorites) {
        localStorage.setItem('favorites',JSON.stringify([...favorites, poke]));
        } else {
            console.log('Ce Pokémon est déjà dans la liste des favoris.');
        }

    };

    return (
        <Button onClick={handleAddToFavorites}>Ajout Favoris</Button>
    );
}

export default Boutton;