package com.example.backend.controller;

import com.example.backend.model.Movie;
import com.example.backend.model.MovieDTO;
import com.example.backend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    private final MovieService service;

    @Autowired
    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public List<Movie> getAllMovies(){
        return service.getAllMovies();
    }

    @PostMapping
    public Movie addMovie(@RequestBody MovieDTO movieDTO){
        return service.addMovie(movieDTO);
    }

}
