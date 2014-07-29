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
    private People owner;

    Movie(){
        this.owner = new People("library","library","library","library","library");
    }

    Movie(String name, String year, String director, int rating){
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.owner = new People("library","library","library","library","library");
    }

    Movie(Movie movie){
        this.name = movie.name;
        this.year = movie.year;
        this.director = movie.director;
        this.rating = movie.rating;
        this.owner = new People("library","library","library","library","library");
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

    public People getOwner(){
        People result = new People(owner);
        result.setPassword("");
        return result;
    }

    public void setMovieYear(String movieYear) {
        this.year = movieYear;
    }

    public void setMovieDirector(String movieDirector) {
        this.director = movieDirector;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Movie) {
            Movie movie = (Movie) obj;
            return this.name.equals(movie.name)
                    && this.year.equals(movie.year)
                    && this.director.equals(movie.director)
                    && this.rating == movie.rating
                    && this.owner.equals(owner);
        }
        return super.equals(obj);
    }

    public void setMovieOwner(People owner) {
        this.owner = owner;
    }
}
