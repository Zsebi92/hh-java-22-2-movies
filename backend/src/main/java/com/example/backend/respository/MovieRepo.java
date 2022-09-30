package com.example.backend.respository;

import com.example.backend.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepo {

    Movie movie1 = new Movie("1", "Test", "2020", "https://www.ndr.de/pizza460_v-contentxl.jpg");
    Movie movie2 = new Movie("2", "Test2", "2020", "https://www.ndr.de/pizza460_v-contentxl.jpg");
    Movie movie3 = new Movie("3", "Test3", "2020", "https://www.ndr.de/pizza460_v-contentxl.jpg");

    HashMap<String, Movie> movieDB = new HashMap<>();


    public List<Movie> findAll() {
        return new ArrayList<>(movieDB.values());
    }

    public Movie add(Movie movie) {
        movieDB.put(movie.getId(), movie);
        return movie;
    }
}
