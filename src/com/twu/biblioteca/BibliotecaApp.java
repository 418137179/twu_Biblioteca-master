package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BibliotecaApp {

    private static Library library = new Library();
    private static String[] faceBook = {"MainMenu","Check-Out Book","Return Book","Quit"};
    private static String[] mainmenu = {"List Books"};
    private static BibliotecaApp bibliotecaApp = new BibliotecaApp();


    BibliotecaApp(){
        Book book1 = new Book("book1","author1","press1");
        Book book2 = new Book("book2","auhtor2","press2");
        Book book3 = new Book("book3","auhtor3","press3");

        library.addBookToLibrary(book1);
        library.addBookToLibrary(book2);

    }

    public static void main(String[] args) {
        while(true){

            bibliotecaApp.welcomeMessage("Welcome you to Biblioteca Library!");
            viewFaceBook(faceBook);

            String input = getInput();
            assert input != null;

            if(input.equals("Quit"))  {
                System.out.println("GoodByeFace!");
                break;
            }
            else {
                switch (input) {
                    case "MainMenu":
                        mainMenu(input);
                        break;
                    case "Check-Out Book":
                        checkOutBook(input);
                        break;
                    case "Return Book":
                        returnBook(input);
                        break;
                    default:
                        System.out.println("Please confirm your selection!");
                }
            }

        }
//        System.out.println("Hello, world!");
    }

    public static void returnBook(String input) {
        while(true) {
            bibliotecaApp.welcomeMessage(input);

            String checkBook = getInput();
            assert checkBook != null;

            if("Quit".equals(checkBook)){
                System.out.println("GoodBye Return Book!");
                break;
            }

            String[] bookInfo;
            if( (bookInfo = checkBook.split(" ")).length != 3){
                System.out.println("Please input your book's name,book's author,book's press to match!");
                continue;
            }
            Book book = new Book(bookInfo[0], bookInfo[1], bookInfo[2]);

            boolean isAvaliable = library.isHaveGivenBookLendBook(book);
            if (isAvaliable) {
                library.returnBook(book);
                System.out.println("Thank you for returning the book.");
                continue;
            } else {
                System.out.println("That is not a valid book to return");
            }
        }
    }

    public static void checkOutBook(String input) {
        while(true) {
            bibliotecaApp.welcomeMessage(input);

            String checkBook = getInput();
            assert checkBook!= null;

            if("Quit".equals(checkBook)){
                System.out.println("GoodBye Check-Out Book!");
                break;
            }

            String[] bookInfo;
            if( (bookInfo = checkBook.split(" ")).length != 3){
                System.out.println("Please input your book's name,book's author,book's press to match!");
                continue;
            }
            Book book = new Book(bookInfo[0], bookInfo[1], bookInfo[2]);

            boolean isAvaliable = library.isHaveGivenBookStorage(book);
            if (isAvaliable) {
                library.lendbook(book);
                System.out.println("Thank you!Enjoy the book.");
                continue;
            } else {
                System.out.println("That book is not available");
            }
        }
    }

    public static void mainMenu(String input) {
        while(true) {

            bibliotecaApp.welcomeMessage(input);
            viewFaceBook(mainmenu);

            String mainMenuInput = getInput();
            assert mainMenuInput != null;

            if("Quit".equals(mainMenuInput))  {
                System.out.println("GoodBye MainMenu!");
                break;
            }

            boolean validMenuOption = false;
            for(int temp=0; temp<mainmenu.length; temp++){
                if(mainMenuInput.equals(mainmenu[temp])) {
                    validMenuOption = true;
                    break;
                }
            }

            if(!validMenuOption)
                System.out.println("Select a valid option!");
            else {
                bibliotecaApp.welcomeMessage(mainMenuInput);
                String[] booksName = new String[100];
                for (int temp = 0; temp <= library.getCountsOfBooksInLibrary()-1; temp++) {
                    booksName[temp] = ((Book)library.getAllBooksFromLibrary().get(temp)).getName();
                }
                viewFaceBook(booksName);

                while(true) {

                    String bookname = getInput();
                    assert bookname != null;

                    if ("Quit".equals(bookname)) {
                        System.out.println("GoodBye List Books!");
                        break;
                    } else {
                        ArrayList<Book> books = library.getBooksByBookName(bookname);
                        if(books.isEmpty())
                            System.out.println("the book is inavliable!");
                        else {
                            for(int temp=0; temp<books.size(); temp++) {
                                System.out.println("BookName:" + books.get(temp).getName());
                                System.out.println("BookAuthor:" + books.get(temp).getAuthor());
                                System.out.println("BookPress:" + books.get(temp).getPress());
                            }
                        }
                    }
                }
            }
        }
    }

    public static String getInput() {

        String input = null;
        System.out.print("Please input your operation(you could input Quit if you want to leave!):");

        try {
            input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }

    private void welcomeMessage(String info) {
        System.out.println("**********************************");
        System.out.println(info);
        System.out.println("**********************************");

    }

    public static void viewFaceBook(String[] facebook){
        for(int temp=0; temp<facebook.length; temp++){
            if(null != facebook[temp])
            System.out.println(facebook[temp]);
        }
    }
}
