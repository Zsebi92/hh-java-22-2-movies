package de.neuefische.backend.respository;

import de.neuefische.backend.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepo {

    HashMap<String, Movie> movieDB = new HashMap<>();


    public List<Movie> findAll() {
        return new ArrayList<>(movieDB.values());
    }

    public Movie add(Movie movie) {
        movieDB.put(movie.getId(), movie);
        return movie;
    }
}
