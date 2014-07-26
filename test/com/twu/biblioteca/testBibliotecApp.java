package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class testBibliotecApp {

    private BibliotecaApp biliotecaApp = new BibliotecaApp();
    private ArrayList<Book> library = new ArrayList<Book>();
    private ArrayList<Book> lendbook = new ArrayList<Book>();

    private Book book1;
    private Book book2;
    private Book book3;

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Before
    public void setArraylistAndBook() {
        book1 = new Book();
        book1.setBookName("book1");
        book1.setBookAuthor("author1");
        book1.setBookPress("press1");

        book2 = new Book();
        book2.setBookName("book2");
        book2.setBookAuthor("author2");
        book2.setBookPress("press2");

        book3 = new Book();
        book3.setBookName("book3");
        book3.setBookAuthor("author3");
        book3.setBookPress("press3");

        library.add(book1);
        library.add(book2);
        lendbook.add(book3);
    }


    @Test
    public void GivenBookExistLibrary() {
        boolean result = biliotecaApp.checkout(library,book1);
        assertTrue(result);
    }

    @Test
    public void GivenBookNotExistLibrary() {
        boolean result = biliotecaApp.checkout(library,book3);
        assertFalse(result);
    }

    @Test
    public void ReturnBookExistLendBook() {
        boolean result = biliotecaApp.checkout(lendbook,book3);
        assertTrue(result);
    }

    @Test
    public void ReturnBookNotExistLendBook() {
        boolean result = biliotecaApp.checkout(lendbook,book2);
        assertFalse(result);
    }

    @Test
    public void testBookEqualsFail() {
        boolean result = book1.equals(book2);
        assertFalse(result);
    }

    @Test
    public void testBookEqualSuccess() {
        boolean result = book1.equals(book1);
        assertTrue(result);
    }

    @Test
    public void testReturnBookName() {
        String result = book1.getName();
        assertEquals("book1",result);

    }

    @Test
    public void testReturnBookAuthor() {
        String result = book1.getAuthor();
        assertEquals("author1",result);

    }

    @Test
    public void testReturnBookPress() {
        String result = book1.getPress();
        assertEquals("press1",result);

    }

    @Test
    public void testReturnBookWhenGivenBookName() {
        String bookname = "book1";
        Book result = biliotecaApp.getBook(bookname);
        assertEquals(book1,result);
    }

    /*@Ignore
    public void testLibraryRemoveOne() {
        int result = biliotecaApp.deleteBookFromLibraryAndAddBookToLendbook(book1);
        assertEquals(1,result);

    }

    @Ignore
    public void testLibraryRemoveTwo() {
        int result = biliotecaApp.deleteBookFromLibraryAndAddBookToLendbook(book1);
        result = biliotecaApp.deleteBookFromLibraryAndAddBookToLendbook(book2);
        assertEquals(0,result);
    }*/

}
