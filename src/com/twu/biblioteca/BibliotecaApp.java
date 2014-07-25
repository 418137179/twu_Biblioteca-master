package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BibliotecaApp {

    private ArrayList<Book> library = new ArrayList<Book>();
    private ArrayList<Book> lendbook = new ArrayList<Book>();
    private static String[] faceBook = {"1.MainMenu","2.Check-Out Book","3.Return Book","4.Quit"};
    private static String[] mainmenu = {"1.List Books"};
    private static String[] booksName = {};

    BibliotecaApp(){
        Book book1 = new Book();
        book1.setBookName("book1");
        book1.setBookAuthor("author1");
        book1.setBookPress("press1");

        Book book2 = new Book();
        book2.setBookName("book2");
        book2.setBookAuthor("author2");
        book2.setBookPress("press2");

        library.add(book1);
        library.add(book2);
    }


    public void main(String[] args) {

        while(true){

            BibliotecaApp bibliotecaApp = new BibliotecaApp();
            bibliotecaApp.welcomeMessage("Welcome you to Biblioteca Library!");
            viewFaceBook(faceBook);

            String input = null;
            try {
                input = new BufferedReader(new InputStreamReader(System.in)).readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(input.equals("4.Quit"))
                System.out.println("GoodBye!");
            else {
                switch (input) {
                    case "1.MainMenu":
                        bibliotecaApp.welcomeMessage("1.MainMenu");
                        viewFaceBook(mainmenu);
                        if(!mainMenu()) {
                            System.out.print("Select a valid option!");
                        }
                        else {
                            bibliotecaApp.welcomeMessage("1.List Books");
                            for(int temp=0; temp<library.size(); temp++) {
                                booksName[temp] = library.get(temp).getName();
                            }
                            viewFaceBook(booksName);
//                            then,need to show the details of every book.tomorrow task!
                        }
                        break;
                    /*case "2.Check-Out Book":
                        boolean isAvaliable = checkOutBook();
                        if () {
                            System.out.println("Thank you!Enjoy the book.");
                            break;
                        } else {
                            System.out.println("That book is not available");
                        }
                    case "3.Return Book":
                        returnBook();
                        break;*/
                    default:
                        System.out.println("Please confirm your selection!");
                }
            }

        }
//        System.out.println("Hello, world!");
    }

    public boolean mainMenu() {

        String input = null;
        try {
            input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean validMenuOption = false;
        for(int temp=0; temp<mainmenu.length; temp++){
            if(input.equals(mainmenu[temp])) {
                validMenuOption = true;
                break;
            }
        }

        return validMenuOption;
    }

    private void welcomeMessage(String info) {
        System.out.println("**********************************");
        System.out.println(info);
        System.out.println("**********************************");

    }

    public boolean checkout(ArrayList<Book> list,Book book1) {
        return list.contains(book1);
    }

    public static void viewFaceBook(String[] facebook){
        for(int temp=0; temp<facebook.length; temp++){
            System.out.println(facebook[temp]);
        }

    }

}
