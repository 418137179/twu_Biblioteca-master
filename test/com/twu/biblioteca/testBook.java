package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by yangjing on 14-7-27.
 */
public class testBook {

    private Book book1;
    private Book book2;
    private Book book3;

    @Before
    public void setArraylistAndBook() {

        book1 = new Book("book1","author1","press1");
        book2 = new Book("book2","author2","press2");

        book3 = new Book();
        book3.setBookName("book1");
        book3.setBookAuthor("author1");
        book3.setBookPress("press1");
    }

    @Test
    public void testEqualsFail() {
        boolean result = book1.equals(book2);
        assertFalse(result);
    }

    @Test
    public void testEqualSuccess() {
        boolean result = book1.equals(book3);
        assertTrue(result);
    }

    @Test
    public void couldReturnBookName() {
        String result = book1.getName();
        assertEquals("book1",result);

    }

    @Test
    public void couldReturnBookAuthor() {
        String result = book1.getAuthor();
        assertEquals("author1",result);

    }

    @Test
    public void couldReturnBookPress() {
        String result = book1.getPress();
        assertEquals("press1",result);

    }
}
