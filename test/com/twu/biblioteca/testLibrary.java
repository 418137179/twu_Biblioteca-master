package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by yangjing on 14-7-27.
 */
public class testLibrary {

    private Book book1;
    private Book book2;
    private Book book3;

    private Library library = new Library();
    @Before
    public void setBook() {
        book1 = new Book("book1","author1","press1");
        book2 = new Book("book2","author2","press2");
        book3 = new Book("book3","author3","press3");

        library.addBookToLibrary(book1);
        library.addBookToLibrary(book2);
        library.addBookToLibrary(book3);
        library.lendbook(book3);
    }

    @Test
    public void couldGetBooksFromLibraryByBookName() {
        String bookname = "book1";
        ArrayList<Book> result = library.getBooksByBookName(bookname);
        ArrayList<Book> expect = new ArrayList<>(Arrays.asList(new Book(book1)));
        assertEquals(expect,result);
    }

    @Test
    public void couldGetBooksFromLibraryByBookAuthor() {
        String bookauthor = "author1";
        ArrayList<Book> expect = new ArrayList<Book>(Arrays.asList(new Book(book1)));
        ArrayList<Book> result = library.getBooksByBookAuthor(bookauthor);
        assertEquals(expect,result);
    }

    @Test
    public void couldGetBooksFromLibraryByBookPress() {
        String bookpress = "press1";
        ArrayList<Book> result = library.getBooksByBookPress(bookpress);
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
}
