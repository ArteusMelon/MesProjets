import { useEffect, useState } from "react"
import React from "react"

function Component1() {
    const [button, setButton] = useState(0);

    useEffect(() => {
        document.title = `Tu as cliqué ${button} fois`;
        window.addEventListener('click', handleClick);

        return()=>{
            window.removeEventListener('click', handleClick);
        }

    }, [button]);
    
   
    

    function handleClick() {
        setButton(button + 1)
    }

    return (
        <div>
            {/* <Button  button = {button} handleClick={handleClick}  /> */}
        </div>
    )
}

function Button({ button, handleClick }) {
    return (
        <>
            <button onClick={handleClick}>

                Salut tu as click {button} de fois
            </button>
        </>

    )
}

export default Component1;