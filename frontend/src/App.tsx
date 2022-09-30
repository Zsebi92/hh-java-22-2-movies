import React from 'react';
import './App.css';
import useMovies from "./hooks/useMovies";
import MovieGallery from "./components/MovieGallery";

function App() {

    const {movies, getAllMovies, postNewMovie} = useMovies();

    return (
        <div className="App">
            <header className={"App-header"}>
                <h1> Movie Gallery</h1>
                <MovieGallery movies={movies} getAllMovies={getAllMovies} postNewMovie={postNewMovie}/>
            </header>
        </div>
    );
}

export default App;
