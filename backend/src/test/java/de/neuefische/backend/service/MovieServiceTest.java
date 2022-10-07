package de.neuefische.backend.service;

import de.neuefische.backend.model.Movie;
import de.neuefische.backend.respository.MovieRepo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;

class MovieServiceTest {

    private final MovieRepo repo = mock(MovieRepo.class);
    private final IdService idService = mock(IdService.class);
    private final MovieService service = new MovieService(repo, idService);

    @Test
    void getAllMovies() {
        //GIVEN
        when(repo.findAll())
                .thenReturn(List.of(
                new Movie("1", "Matrix", "1999", "www.post.com/image1.jpeg"),
                new Movie("2", "Pulp Fiction", "1994", "www.post.com/image2.jpeg")));

        //WHEN
        List<Movie> actual = service.getAllMovies();

        //THEN
        List<Movie> expected = List.of(
                new Movie("1", "Matrix", "1999", "www.post.com/image1.jpeg"),
                new Movie("2", "Pulp Fiction", "1994", "www.post.com/image2.jpeg"));
        verify(repo).findAll();
        assertEquals(expected, actual);
    }

    @Test
    void addMovie() {
        //GIVEN
        Movie dummyMovie = new Movie("1", "Matrix", "1999", "www.post.com/image1.jpeg");
        when(repo.save(dummyMovie)).thenReturn(dummyMovie);

        //WHEN
        Movie actual = service.addMovie(dummyMovie);

        //THEN
        verify(repo).save(dummyMovie);
        assertEquals(dummyMovie, actual);
    }
}
