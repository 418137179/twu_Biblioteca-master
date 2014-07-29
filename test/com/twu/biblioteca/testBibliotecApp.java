package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class testBibliotecApp {

    private BibliotecaApp bibliotecaApp = new BibliotecaApp();
    private Library library;

    @Before
    public void Prepare() {

    }

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void couldReturnBooksNameFromLibrayStorageBooks() {
      /*  when(library.getCountsOfBooksInLibrary()).thenReturn(2);
        ArrayList<Book> tempBooks = new ArrayList<Book>(Arrays.asList(new Book("book1","",""),new Book("book2","","")));
        when(library.getAllBooksFromLibrary()).thenReturn(tempBooks);
ps:it doesn't work,i don't know why
*/

        ArrayList<String> expect = new ArrayList<>(Arrays.asList("book1","book2"));
        ArrayList<String> result = bibliotecaApp.getLibraryStorageBooksName();
        assertEquals(expect,result);
    }

    @Test
    public void couldReturnMoviesNameFromLibraryStorageMovies() {
        ArrayList<String> expect = new ArrayList<>(Arrays.asList("movie1","movie2"));
        ArrayList<String> result = bibliotecaApp.getLibraryStorageMoviesName();
        assertEquals(expect, result);
    }

    @Test
    public void couldReturnMoviesNameFromLibraryLendMovies() {
        ArrayList<String> expect = new ArrayList<>(Arrays.asList("movie2"));
        ArrayList<String> result = bibliotecaApp.getLibraryLendMoviesName();
        assertEquals(expect, result);
    }

    @Test
    public void couldReturnBooksNameFromLibraryLendBooks() {
        ArrayList<String> expect = new ArrayList<>(Arrays.asList("book3"));
        ArrayList<String> result = bibliotecaApp.getLibraryLendBooksName();
        assertEquals(expect, result);
    }

}
