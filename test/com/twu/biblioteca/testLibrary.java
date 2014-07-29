package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by yangjing on 14-7-27.
 */
public class testLibrary {

    private Book book1;
    private Book book2;
    private Book book3;
    private Movie movie1;
    private Movie movie2;

    private Library library = new Library();
    @Before
    public void setBook() {
        book1 = new Book("book1","author1","press1");
        book2 = new Book("book2","author2","press2");
        book3 = new Book("book3","author3","press3");

        movie1 = new Movie("movie1","1942","director1",1);
        movie2 = new Movie("movie2","1943","director2",2);

        library.addBookToLibrary(book1);
        library.addBookToLibrary(book2);
        library.addBookToLibrary(book3);
        library.lendbook(book3);

        library.addMovieToLibrary(movie1);
        library.addMovieToLibrary(movie2);
        library.lendMovie(movie2);
    }

    @Test
    public void couldGetBooksFromLibraryByBookName() {
        ArrayList<Book> result = library.getBooksByBookName("book1");
        ArrayList<Book> expect = new ArrayList<>(Arrays.asList(new Book(book1)));
        assertEquals(expect,result);
    }

    @Test
    public void couldGetBooksFromLibraryByBookAuthor() {
        ArrayList<Book> expect = new ArrayList<Book>(Arrays.asList(new Book(book1)));
        ArrayList<Book> result = library.getBooksByBookAuthor("author1");
        assertEquals(expect,result);
    }

    @Test
    public void couldGetBooksFromLibraryByBookPress() {
        ArrayList<Book> result = library.getBooksByBookPress("press1");
        ArrayList<Book> expect = new ArrayList<>(Arrays.asList(new Book(book1)));
        assertEquals(expect,result);
    }

    @Test
    public void returnTrueWhenLendBookSuccessful() {
        boolean result = library.lendbook(book1);
        assertTrue(result);
    }

    @Test
    public void returnFalseWhenLendBooksFailed() {
        Library library1 = new Library();
        boolean result = library1.lendbook(book1);
        assertFalse(result);

    }

    @Test
    public void couldGetCountsOfBooksInLibrary() {
        int result = library.getCountsOfBooksInLibrary();
        assertEquals(2,result);

    }

    @Test
    public void couldGetCountsOfBOoksOutLibrary() {
        int result = library.getCountsOfBooksOutLibrary();
        assertEquals(1,result);

    }

    @Test
    public void couldGetAllBooksFromLibrary() {
        ArrayList<Book> expect = new ArrayList<>(Arrays.asList(book1,book2));
        ArrayList<Book> result = library.getAllBooksFromLibrary();
        assertEquals(expect,result);
    }

    @Test
    public void couldReturnTrueIfGivenBookInLibrary() {
        boolean result = library.isHaveGivenBookStorage(book1);
        assertTrue(result);
    }

    @Test
    public void couldReturnFalseIfGivenBookOutLibrary() {
        boolean result = library.isHaveGivenBookStorage(book3);
        assertFalse(result);
    }

    @Test
    public void couldReturnTrueIfGivenBookInLendBooks() {
        boolean result = library.isHaveGivenBookLendBook(book3);
        assertTrue(result);
    }

    @Test
    public void couldReturnFalseIfGivenBookOutLendBooks() {
        boolean result = library.isHaveGivenBookLendBook(book2);
        assertFalse(result);
    }

    @Test
    public void couldReturnTrueIfReturnBookSuccessful() {
        boolean result = library.returnBook(book3);
        assertTrue(result);
    }

    @Test
    public void couldReturnFalseIfReturnBookFailed() {
        boolean result = library.returnBook(book2);
        assertFalse(result);
    }

    @Test
    public void couldReturnMoviesByGivenMovieName() {
        ArrayList<Movie> expect = new ArrayList<Movie>(Arrays.asList(new Movie(movie1)));
        ArrayList<Movie> result = library.getMoviesByMovieName("movie1");
        assertEquals(expect, result);
    }

    @Test
    public void couldReturnMoviesByGivenMovieYear() {
        ArrayList<Movie> expect = new ArrayList<>(Arrays.asList(new Movie(movie1)));
        ArrayList<Movie> result = library.getMoviesByMoiveYear("1942");
        assertEquals(expect,result);

    }

    @Test
    public void couldReturnMoviesByGivenMoviedirector() {
        ArrayList<Movie> expect = new ArrayList<>(Arrays.asList(new Movie(movie1)));
        ArrayList<Movie> result = library.getMoviesByMoiveDirector("director1");
        assertEquals(expect,result);

    }

    @Test
    public void couldReturnMoviesByGivenMovieRating() {
        ArrayList<Movie> expect = new ArrayList<>(Arrays.asList(new Movie(movie1)));
        ArrayList<Movie> result = library.getMoviesByMoiveRating(1);
        assertEquals(expect,result);

    }

    @Test
    public void couldReturnTrueIfGivenMovieInLibraryStorage() {
        boolean result = library.isHaveGivenMovieInMovieStorage(movie1);
        assertTrue(result);
    }

    @Test
    public void couldReturnFalseIfGivenMovieOutLibraryStorage() {
        Movie movie3 = new Movie("movie3","1944","director3",3);
        boolean result = library.isHaveGivenMovieInMovieStorage(movie3);
        assertFalse(result);
    }

    @Test
    public void returnTrueWhenLendMovieSuccessful() {
        boolean result = library.lendMovie(movie1);
        assertTrue(result);
    }

    @Test
    public void returnFalseWhenLendMovieFailed() {
        Movie movie3 = new Movie("movie3","1944","director3",3);
        boolean result = library.lendMovie(movie3);
        assertFalse(result);
    }

    @Test
    public void couldReturnTrueIfGivenMovieInLibraryLend() {
        boolean result = library.isHaveGivenMovieInLendMovies(movie2);
        assertTrue(result);
    }

    @Test
    public void couldReturnFalseIfGivenMovieOutLibraryLend() {
        Movie movie3 = new Movie("movie3","1944","director3",3);
        boolean result = library.isHaveGivenMovieInLendMovies(movie3);
        assertFalse(result);
    }

    @Test
    public void couldGetAllMoviesFromLibrary() {
        ArrayList<Movie> expect = new ArrayList<>(Arrays.asList(movie1));
        ArrayList<Movie> result = library.getAllMoviesFromLibrary();
        assertEquals(expect,result);
    }

    @Test
    public void couldReturnTrueIfReturnMovieSuccessful() {
        boolean result = library.returnMovie(movie2);
        assertTrue(result);
    }

    @Test
    public void couldReturnFalseIfReturnMovieFailed() {
        boolean result = library.returnMovie(movie1);
        assertFalse(result);
    }

    @Test
    public void couldReturnCountsOfMoviesInLibrayStorage() {
        int result = library.getCountsOfMoviesInLibraryStorage();
        assertEquals(1,result);
    }

    @Test
    public void couldReturnCountsOfMoviesInLibrayLend() {
        int result = library.getCountsOfMoviesInLibraryLend();
        assertEquals(1,result);
    }

    @Test
    public void couldReturnTrueIfUserExisted() {
        boolean result = library.isHaveGivenUser("student","password1");
        assertTrue(result);
    }

    @Test
    public void couldReturnFalseIfUserNotExisted() {
        boolean result = library.isHaveGivenUser("name1","password1");
        assertFalse(result);
    }

    @Test
    public void couldReturnPeopleByGivenUsernameAndPassword() {
        People expect = new People("student","emailaddress1","phonenumber1","password1","student");
        People result = library.returnPeopleByGivenUsernameAndPassword("student","password1");
        assertEquals(expect,result);
    }

    @Test
    public void couldReturnLoginUser() {
        People expect = new People("student","emailaddress1","phonenumber1","password1","student");
        library.setLoginUser(expect);
        People result = library.getLoginUser();
        assertEquals(expect,result);
    }

    @Test
    public void couldReturnBooksFromLendBooks() {
        ArrayList<Book> expect = new ArrayList<>(Arrays.asList(book3));
        ArrayList<Book> result = library.getAllBooksFromLendBooks();
        assertEquals(expect,result);
    }

    @Test
    public void couldReturnMoviesFromLendMovies() {
        ArrayList<Movie> expect = new ArrayList<>(Arrays.asList(movie2));
        ArrayList<Movie> result = library.getAllMoviesFromLendMovies();
        assertEquals(expect,result);
    }

}
