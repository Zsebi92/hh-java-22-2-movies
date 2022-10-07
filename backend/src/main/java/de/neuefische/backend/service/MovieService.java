package de.neuefische.backend.service;

import de.neuefische.backend.model.Movie;
import de.neuefische.backend.respository.MovieRepo;
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

    public Movie addMovie(Movie movie) {
        // Generate and set id for new movie
        movie.setId(idService.generateId());

        return repo.save(movie);
    }
}
