package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by yangjing on 14-7-27.
 */
public class Library {

    private ArrayList<Book> bookStorage = new ArrayList<Book>();
    private ArrayList<Book> lendBooks = new ArrayList<Book>();
    private ArrayList<Movie> movieStorage = new ArrayList<Movie>();
    private ArrayList<Movie> lendMovies = new ArrayList<Movie>();
    private ArrayList<People> customer = new ArrayList<People>();
    private People loginUser = new People();

    Library(){
        customer.add(new People("student","emailaddress1","phonenumber1","password1","student"));
        customer.add(new People("admin","emailaddress2","phonenumber2","password2","admin"));
    }

    Library(Library library){
        bookStorage.addAll(library.bookStorage);
        lendBooks.addAll(library.lendBooks);
        movieStorage.addAll(library.movieStorage);
        lendMovies.addAll(library.lendMovies);
        customer.addAll(library.customer);
    }

    public void addBookToLibrary(Book book){
        bookStorage.add(book);
    }
    public void addMovieToLibrary(Movie movie){
        movieStorage.add(movie);
    }

    public ArrayList<Book> getBooksByBookName(String bookname) {
        ArrayList<Book> result = new ArrayList<Book>();
        for(int temp=0; temp<bookStorage.size(); temp++){
            if(bookname.equals(bookStorage.get(temp).getName())){
                result.add(bookStorage.get(temp));
            }
        }
        return result;
    }

    public ArrayList<Book> getBooksByBookAuthor(String bookauthor) {
        ArrayList<Book> result = new ArrayList<Book>();
        for(int temp=0; temp<bookStorage.size(); temp++){
            if(bookauthor.equals(bookStorage.get(temp).getAuthor())){
                result.add(bookStorage.get(temp));
            }
        }
        return result;
    }

    public ArrayList<Book> getBooksByBookPress(String bookpress) {
        ArrayList<Book> result = new ArrayList<Book>();
        for(int temp=0; temp<bookStorage.size(); temp++){
            if(bookpress.equals(bookStorage.get(temp).getPress())){
                result.add(bookStorage.get(temp));
            }
        }
        return result;
    }

    public boolean lendbook(Book book1) {
        boolean result = false;
        if(isHaveGivenBookStorage(book1)){
            bookStorage.remove(book1);
            book1.setBookOwner(loginUser);
            lendBooks.add(book1);
            result = true;
        }
        return result;
    }

    public int getCountsOfBooksInLibrary() {
        return bookStorage.size();
    }

    public int getCountsOfBooksOutLibrary() {
        return lendBooks.size();
    }

    public ArrayList<Book> getAllBooksFromLibrary() {
        return bookStorage;
    }

    public boolean isHaveGivenBookStorage(Book book1) {
        return bookStorage.contains(book1);
    }

    public boolean isHaveGivenBookLendBook(Book book3) {
        return lendBooks.contains(book3);
    }

    public boolean returnBook(Book book3) {
        boolean result = false;
        if(isHaveGivenBookLendBook(book3)){
            bookStorage.add(book3);
            book3.setBookOwner(new People("library","library","library","library","library"));
            lendBooks.remove(book3);
            result = true;
        }
        return result;
    }

    public ArrayList<Movie> getMoviesByMovieName(String name) {
        ArrayList<Movie> result = new ArrayList<>();
        for(int temp=0; temp<movieStorage.size(); temp++){
            if(name.equals(movieStorage.get(temp).getName())){
                result.add(movieStorage.get(temp));
            }
        }
        return result;
    }

    public ArrayList<Movie> getMoviesByMoiveYear(String year) {
        ArrayList<Movie> result = new ArrayList<>();
        for(int temp=0; temp<movieStorage.size(); temp++){
            if(year.equals(movieStorage.get(temp).getYear())){
                result.add(movieStorage.get(temp));
            }
        }
        return result;
    }

    public ArrayList<Movie> getMoviesByMoiveDirector(String director) {
        ArrayList<Movie> result = new ArrayList<>();
        for(int temp=0; temp<movieStorage.size(); temp++){
            if(director.equals(movieStorage.get(temp).getDirector())){
                result.add(movieStorage.get(temp));
            }
        }
        return result;
    }

    public ArrayList<Movie> getMoviesByMoiveRating(int rating) {
        ArrayList<Movie> result = new ArrayList<>();
        for(int temp=0; temp<movieStorage.size(); temp++){
            if(rating == movieStorage.get(temp).getRating()){
                result.add(movieStorage.get(temp));
            }
        }
        return result;
    }

    public boolean isHaveGivenMovieInMovieStorage(Movie movie1) {
        return movieStorage.contains(movie1);
    }

    public boolean lendMovie(Movie movie) {
        boolean result = false;
        if(isHaveGivenMovieInMovieStorage(movie)){
            movieStorage.remove(movie);
            movie.setMovieOwner(loginUser);
            lendMovies.add(movie);
            result = true;
        }
        return result;
    }

    public boolean isHaveGivenMovieInLendMovies(Movie movie) {
        return lendMovies.contains(movie);
    }

    public ArrayList<Movie> getAllMoviesFromLibrary() {
        return movieStorage;
    }

    public boolean returnMovie(Movie movie) {
        boolean result = false;
        if(lendMovies.contains(movie)){
            lendMovies.remove(movie);
            movie.setMovieOwner(new People("library","library","library","library","library"));
            movieStorage.add(movie);
            result = true;
        }
        return result;
    }

    public int getCountsOfMoviesInLibraryStorage() {
        return movieStorage.size();
    }

    public int getCountsOfMoviesInLibraryLend() {
        return lendMovies.size();
    }

    public boolean isHaveGivenUser(String username, String password) {
        boolean result = false;
        for(int temp=0; temp<customer.size(); temp++){
            if(username.equals(customer.get(temp).getName()) && password.equals(customer.get(temp).getPassword())){
                result = true;
            }
        }
        return result;
    }


    public void setLoginUser(People people){
         loginUser = new People(people);
    }

    public People returnPeopleByGivenUsernameAndPassword(String username, String password) {
        People result = new People();

        for(int temp=0; temp<customer.size(); temp++){
            if(username.equals(customer.get(temp).getName()) && password.equals(customer.get(temp).getPassword())){
                result = new People(customer.get(temp));
                break;
            }
        }

        return result;
    }


    public People getLoginUser() {
        return loginUser;
    }

    public ArrayList<Book> getAllBooksFromLendBooks() {
        return lendBooks;
    }

    public ArrayList<Movie> getAllMoviesFromLendMovies() {
        return lendMovies;
    }
}
