package com.twu.biblioteca;

/**
 * Created by yangjing on 14-7-28.
 */
public class Movie {
// name, year, director and movie rating

    private String name = "";
    private String year = "";
    private String director = "";
    private int rating = 0;

    Movie(){}

    Movie(String name, String year, String director, int rating){
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    Movie(Movie movie){
        this.name = movie.name;
        this.year = movie.year;
        this.director = movie.director;
        this.rating = movie.rating;
    }


    public void setMovieName(String movieName) {
        this.name = movieName;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }

    public void setMovieYear(String movieYear) {
        this.year = movieYear;
    }

    public void setMovieDirector(String movieDirector) {
        this.director = movieDirector;
    }


}
