package com.example.backend.service;

import com.example.backend.model.Movie;
import com.example.backend.respository.MovieRepo;
import de.neuefische.booklibrary.model.Book;
import de.neuefische.booklibrary.repository.BookRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class MoiveServiceTest {

    private final MovieRepo repo = mock(MovieRepo.class);
    private final IdService idService = mock(IdService.class);
    private final MovieService service = new MovieService(repo, idService);

    @Test
    void getAllMovies() {
        //GIVEN
        when(repo.findAll()).thenReturn(List.of(new Movie("1", "Matrix", "1990", "test"), new Movie("Test", "Test", "Test", "Test")));

        //WHEN
        List<Movie> actual = service.getAllMovies();

        //THEN
        List<Movie> expected = List.of(new Book("1", "IKEA Catalog", "IKEA AG"), new Book("978-3-8362-8745-6", "Java ist auch eine Insel", "Christian Ullenboom"));
        verify(repo).getAllBooks();
        assertEquals(expected, actual);
    }

    @Test
    void addBook() {
        //GIVEN
        Book dummyBook = new Book("ISBN42", "Hitchhiker's Guide To The Universe", "IKEA AG");
        when(repo.addBook("ISBN42", dummyBook)).thenReturn(dummyBook);

        //WHEN
        Book actual = service.addBook(dummyBook);

        //THEN
        verify(repo).addBook("ISBN42", dummyBook);
        assertEquals(dummyBook, actual);
    }

    @Test
    void deleteBook_whenBookExists() {
        //GIVEN
        when(repo.getBookByIsbn("ISBN123")).thenReturn(Optional.ofNullable(new Book("ISBN123", "IKEA Catalog", "IKEA AG")));

        //WHEN
        service.deleteBook("ISBN123");

        //THEN
        verify(repo).deleteBook("ISBN123");
    }

    @Test
    void deleteBook_whenBookDoesNotExist() {
        //GIVEN

        //WHEN
        service.deleteBook("ISBN123");

        //THEN
        verify(repo, never()).deleteBook("ISBN123");
    }

    @Test
    void addBookByIsbn() {
        //GIVEN

        String isbn = "123";
        Book book = new Book(isbn, "test-title", "test-author");

        when(repo.addBook(isbn, book)).thenReturn(book);

        //WHEN

        Book actual = service.addBookByIsbn(isbn, book);

        //THEN
        verify(repo).addBook(isbn, book);

        assertEquals(book, actual);
    }
}
