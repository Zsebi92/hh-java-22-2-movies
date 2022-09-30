package com.example.backend.service;

import com.example.backend.model.Movie;
import com.example.backend.model.MovieDTO;
import com.example.backend.respository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepo repo;
    private final IdService idService;

    @Autowired
    public MovieService(MovieRepo repo, IdService idService) {
        this.repo = repo;
        this.idService = idService;
    }

    public List<Movie> getAllMovies() {
        return repo.findAll();
    }

    public Movie addMovie(MovieDTO movieDTO) {
        Movie movie = Movie.builder()
                .title(movieDTO.getTitle())
                .id(idService.generateId())
                .poster(movieDTO.getPoster())
                .releaseYear(movieDTO.getReleaseYear())
                .build();
        return repo.add(movie);
    }
}
