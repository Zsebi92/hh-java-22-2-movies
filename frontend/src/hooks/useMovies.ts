import {useEffect, useState} from "react";
import axios from "axios";
import {Movie} from "../model/Movie";

export default function useMovies(){

    const [movies, setMovies] = useState([]);

    useEffect(()=>{
        getAllMovies()
    }, [])


    const getAllMovies = () => {
        axios.get("/api/movie")
            .then(res => res.data)
            .then(d => setMovies(d))
            .catch(console.error)
    }

    const postNewMovie = (movie:Movie) => {
        axios.post("/api/movie", movie)
            .then(getAllMovies)
    }

    return {movies, getAllMovies, postNewMovie}
}