package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by yangjing on 14-7-28.
 */
public class testMovie {

    private Movie movie;

    @Before
    public void prepare() {
        movie = new Movie("movie1","","",1);
        movie.setMovieYear("year1");
        movie.setMovieDirector("director1");
    }

    @Test
    public void couldReturnMovieName() {
        String result = movie.getName();
        assertEquals("movie1",result);

    }

    @Test
    public void couldReturnMovieYear() {
        String result = movie.getYear();
        assertEquals("year1",result);

    }

    @Test
    public void couldReturnMovieDirector() {
        String result = movie.getDirector();
        assertEquals("director1",result);
    }

    @Test
    public void couldReturnMovieRating() {
        int result = movie.getRating();
        assertEquals(1,result);

    }

    @Test
    public void couldReturnMovieOwener() {
        People result = movie.getOwner();
        assertEquals(new People("library","library","library","library","library"),result);
    }
}
