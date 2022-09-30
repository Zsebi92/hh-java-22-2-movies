import { Link } from 'react-router-dom';

export default function NavBar(){

    return(
        <>
            <Link to={"/"}> Homepage </Link>
            <Link to={"/movies"}> Movies </Link>
        </>
    )
}