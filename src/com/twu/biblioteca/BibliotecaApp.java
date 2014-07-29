package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApp {

    private static Library library;
    private static ArrayList<String> faceBook = new ArrayList<String>(Arrays.asList("MainMenu","CheckOut","Return","UserAccounts","Quit"));
    private static ArrayList<String> superfaceBook = new ArrayList<String>(Arrays.asList("MainMenu","Lend","CheckOut","Return","UserAccounts","Quit"));
    private static BasicMenu basicmenu = new BasicMenu();

    BibliotecaApp(){

        Book book1 = new Book("book1","author1","press1");
        Book book2 = new Book("book2","auhtor2","press2");
        Book book3 = new Book("book3","auhtor3","press3");

        Movie movie1 = new Movie("movie1","1942","director1",1);
        Movie movie2 = new Movie("movie2","1943","director2",2);

        library = new Library();
        library.addBookToLibrary(book1);
        library.addBookToLibrary(book2);
        library.addBookToLibrary(book3);
        library.lendbook(book3);

        library.addMovieToLibrary(movie1);
        library.addMovieToLibrary(movie2);
        library.lendMovie(movie2);
    }

    public static void main(String[] args) throws Exception{
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
//        People tempLoginUser = new People(library.getLoginUser());

        while (login()) {
//            library.setLoginUser(tempLoginUser);
            while(true) {
                basicmenu.welcomeMessage("Welcome you to Biblioteca Library!");

                if ("admin".equals(library.getLoginUser().getDuty())) {
                    basicmenu.viewFaceBook(superfaceBook);
                } else
                    basicmenu.viewFaceBook(faceBook);

                String input = basicmenu.getInput();
                assert input != null;

                if ("Quit".equals(input)) {
                    System.out.println("GoodByeFace!");
                    break;
                } else {
                    switch (input) {
                        case "MainMenu":
                            basicmenu = new MainMenu();
                            break;
                        case "CheckOut":
                            basicmenu = new CheckOut();
                            break;
                        case "UserAccounts":
                            basicmenu = new UserAccount();
                            break;
                        case "Return":
                            basicmenu = new Return();
                            break;
                        case "Lend":
                            if ("admin".equals(library.getLoginUser().getDuty())) {
                                basicmenu = new Lend();
                            }
                        default:
                            System.out.println("Please confirm your selection!");
                            break;
                    }

                    basicmenu.doSomething(bibliotecaApp, input);
                }
            }

        }
//        System.out.println("Hello, world!");
    }

    public static void showLoginUserAccounts() {
        System.out.println("userName:" + library.getLoginUser().getName());
        System.out.println("emailAddress:" + library.getLoginUser().getEmailAddress());
        System.out.println("phoneNumber:" + library.getLoginUser().getPhoneNumber());
        System.out.println("password:" + library.getLoginUser().getPassword());
        System.out.println("duty:" + library.getLoginUser().getDuty());

        while("Quit".equals(basicmenu.getInput())) break;
    }

    public static boolean login() {
        int time = 0;
        while(time++ < 3) {
            System.out.println("you have " + (3 - time) + "chances.");
            System.out.print("Please input your username and password:xxx-xxxxx.:");
            String userinfo = basicmenu.getInput();

            if("Quit".equals(userinfo)) return false;

            String[] userInfo;
            if ((userInfo = userinfo.split("-")).length==2 && library.isHaveGivenUser(userInfo[0], userInfo[1])) {
                library.setLoginUser(library.returnPeopleByGivenUsernameAndPassword(userInfo[0], userInfo[1]));
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getLibraryStorageBooksName() {

        ArrayList<String> booksName = new ArrayList<>();
        for (int temp = 0; temp <= library.getCountsOfBooksInLibrary()-1; temp++) {
            booksName.add(((Book)(library.getAllBooksFromLibrary().get(temp))).getName());
        }

        return booksName;
    }

    public void giveBooksDetail(String bookname) {
        ArrayList<Book> books = library.getBooksByBookName(bookname);
        if(books.isEmpty())
            System.out.println("the book is invalid!");
        else {
            for(int temp=0; temp<books.size(); temp++) {
                System.out.println("Book Name:" + books.get(temp).getName());
                System.out.println("Book Author:" + books.get(temp).getAuthor());
                System.out.println("Book Press:" + books.get(temp).getPress());
            }
        }
    }

    public ArrayList<String> getLibraryStorageMoviesName() {
        ArrayList<String> moviesName = new ArrayList<>();
        for (int temp = 0; temp <= library.getCountsOfMoviesInLibraryStorage() - 1; temp++) {
            moviesName.add(((Movie) library.getAllMoviesFromLibrary().get(temp)).getName());
        }
        return moviesName;
    }

    public void giveMoviesDetail(String moviename) {
        ArrayList<Movie> movies = library.getMoviesByMovieName(moviename);
        if(movies.isEmpty())
            System.out.println("the movie is invalid!");
        else {
            for(int temp=0; temp<movies.size(); temp++) {
                System.out.println("Movie Name:" + movies.get(temp).getName());
                System.out.println("Movie Year:" + movies.get(temp).getYear());
                System.out.println("Movie Director:" + movies.get(temp).getDirector());
                System.out.println("Movie Rating:" + movies.get(temp).getRating());
            }
        }
    }

    public void checkOutBook(Book book) {
        if (library.isHaveGivenBookStorage(book) && library.lendbook(book)) {
            System.out.println("Thank you!Enjoy the book.");
        } else {
            System.out.println("That book is not available");
        }
    }

    public void checkOutMovie(Movie movie) {
        if (library.isHaveGivenMovieInMovieStorage(movie) && library.lendMovie(movie)) {
            System.out.println("Thank you!Enjoy the movie.");
        } else {
            System.out.println("That movie is not available");
        }
    }

    public void returnBook(Book book) {
        if (library.isHaveGivenBookLendBook(book) && library.returnBook(book)) {
            System.out.println("Thank you for returning the book.");
        } else {
            System.out.println("That is not a valid book to return");
        }
    }

    public void returnMovie(Movie movie) {
        if (library.isHaveGivenMovieInLendMovies(movie) && library.returnMovie(movie)) {
            System.out.println("Thank you for returning the book.");
        } else {
            System.out.println("That is not a valid book to return");
        }
    }

    public ArrayList<String> getLibraryLendMoviesName() {
        ArrayList<String> moviesName = new ArrayList<>();
        for (int temp = 0; temp <= library.getCountsOfMoviesInLibraryLend() - 1; temp++) {
            moviesName.add(((Movie) library.getAllMoviesFromLendMovies().get(temp)).getName());
        }
        return moviesName;
    }

    public ArrayList<String> getLibraryLendBooksName() {
        ArrayList<String> moviesName = new ArrayList<>();
        for (int temp = 0; temp <= library.getCountsOfBooksOutLibrary() - 1; temp++) {
            moviesName.add(((Book) library.getAllBooksFromLendBooks().get(temp)).getName());
        }
        return moviesName;
    }

    public void giveMoviesOwnerDetail(String moviename) {
        ArrayList<Movie> movies = library.getAllMoviesFromLendMovies();
        if(movies.isEmpty())
            System.out.println("the movie is invalid!");
        else {
            for(int temp=0; temp<movies.size(); temp++) {
                if(moviename.equals(((Movie)movies.get(temp)).getName())) {
                    System.out.println("Movie Name:" + movies.get(temp).getName());
                    System.out.println("Movie's Owner name:" + movies.get(temp).getOwner().getName());
                    System.out.println("Movie's Owner phonenumber:" + movies.get(temp).getOwner().getPhoneNumber());
                }
            }
        }
    }

    public void giveBooksOwnerDetail(String bookname) {
        ArrayList<Book> books = library.getAllBooksFromLendBooks();
        if(books.isEmpty())
            System.out.println("the book is invalid!");
        else {
            for(int temp=0; temp<books.size(); temp++) {
                if(bookname.equals(((Book) books.get(temp)).getName())) {
                    System.out.println("Book Name:" + books.get(temp).getName());
                    System.out.println("Book's Owner name:" + books.get(temp).getOwner().getName());
                    System.out.println("Book's Owner phonenumber:" + books.get(temp).getOwner().getPhoneNumber());
                }
            }
        }
    }
}
