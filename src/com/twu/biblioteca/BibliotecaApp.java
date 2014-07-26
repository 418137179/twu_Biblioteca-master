package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BibliotecaApp {

    private static ArrayList<Book> library = new ArrayList<Book>();
    private static ArrayList<Book> lendbook = new ArrayList<Book>();
    private static String[] faceBook = {"MainMenu","Check-Out Book","Return Book","Quit"};
    private static String[] mainmenu = {"List Books"};

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


    public static void main(String[] args) {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        while(true){

            bibliotecaApp.welcomeMessage("Welcome you to Biblioteca Library!");
            viewFaceBook(faceBook);

            System.out.print("Please input your operation:");
            String input = null;
            try {
                input = new BufferedReader(new InputStreamReader(System.in)).readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            assert input != null;
            if(input.equals("Quit"))  {
                System.out.println("GoodByeFace!");
                break;
            }
            else {
                switch (input) {
                    case "MainMenu":
                        while(true) {

                            bibliotecaApp.welcomeMessage(input);
                            viewFaceBook(mainmenu);
                            System.out.print("Please input your choice(Quit will return previous level):");

                            String mainMenuInput = null;
                            try {
                                mainMenuInput = new BufferedReader(new InputStreamReader(System.in)).readLine();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            if("Quit".equals(mainMenuInput))  {
                                System.out.println("GoodBye MainMenu!");
                                break;
                            }

                            boolean validMenuOption = false;
                            for(int temp=0; temp<mainmenu.length; temp++){
                                assert mainMenuInput != null;
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
                                System.out.println(library.size());
                                for (int temp = 0; temp <= library.size()-1; temp++) {
                                    booksName[temp] = ((Book)library.get(temp)).getName();
                                }
                                viewFaceBook(booksName);

                                while(true) {
                                    System.out.print("Please input your book that you want to check its information.(Quit will return previous level):");
                                    String bookname = null;
                                    try {
                                        bookname = new BufferedReader(new InputStreamReader(System.in)).readLine();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                    assert bookname != null;
                                    if ("Quit".equals(bookname)) {
                                        System.out.println("GoodBye List Books!");
                                        break;
                                    } else {
                                        Book book = getBook(bookname);
                                        if(null == book)
                                            System.out.println("the book is inavliable!");
                                        else {
                                            System.out.println("BookName:" + book.getName());
                                            System.out.println("BookAuthor:" + book.getAuthor());
                                            System.out.println("BookPress:" + book.getPress());
                                        }
                                    }
                                }
                            }
//                            then,need to show the details of every book.tomorrow task!  fixed.
                        }
                        break;
                    case "Check-Out Book":
                       while(true) {
                           bibliotecaApp.welcomeMessage(input);
                           System.out.print("Please input your check book(If you don't know the bookname,you can go to MainMenu to find!):");

                           String checkBook = null;
                           try {
                               checkBook = new BufferedReader(new InputStreamReader(System.in)).readLine();
                           } catch (IOException e) {
                               e.printStackTrace();
                           }
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
                           boolean isAvaliable = checkout(library, book);
                           if (isAvaliable) {
                               deleteBookFromLibraryAndAddBookToLendbook(book);
                               System.out.println("Thank you!Enjoy the book.");
                               continue;
                           } else {
                               System.out.println("That book is not available");
                           }
                       }
                        break;
                    case "Return Book":
                        while(true) {
                            bibliotecaApp.welcomeMessage(input);
                            System.out.print("Please input return book(example:book1 author1 press1):");

                            String checkBook = null;
                            try {
                                checkBook = new BufferedReader(new InputStreamReader(System.in)).readLine();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
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
                            boolean isAvaliable = checkout(lendbook, book);
                            if (isAvaliable) {
                                deleteBookFromLendbookAndAddBookToLibrary(book);
                                System.out.println("Thank you for returning the book.");
                                continue;
                            } else {
                                System.out.println("That is not a valid book to return");
                            }
                        }
                        break;
                    default:
                        System.out.println("Please confirm your selection!");
                }
            }

        }
//        System.out.println("Hello, world!");
    }

    private static void deleteBookFromLendbookAndAddBookToLibrary(Book book) {
        if(lendbook.contains(book)){
            lendbook.remove(book);
            library.add(book);
        }
    }

    public static void deleteBookFromLibraryAndAddBookToLendbook(Book book) {

      /*  book.getName().equals(((Book)library.get(temp)).getName())
                && book.getAuthor().equals(((Book)library.get(temp)).getAuthor())
                && book.getPress().equals(((Book)library.get(temp)).getPress())*/

        if(library.contains(book)){
            library.remove(book);
            lendbook.add(book);
        }
    }

    private void welcomeMessage(String info) {
        System.out.println("**********************************");
        System.out.println(info);
        System.out.println("**********************************");

    }

    public static boolean checkout(ArrayList<Book> list,Book book1) {
        return list.contains(book1);
    }

    public static void viewFaceBook(String[] facebook){
        for(int temp=0; temp<facebook.length; temp++){
            if(null != facebook[temp])
            System.out.println(facebook[temp]);
        }
    }

    public static Book getBook(String bookname) {
        Book book = null;
        for(int temp=0; temp<library.size(); temp++){
            if(library.get(temp).getName().equals(bookname)){
                book = new Book();
                book.setBookName(library.get(temp).getName());
                book.setBookAuthor(library.get(temp).getAuthor());
                book.setBookPress(library.get(temp).getPress());
            }
        }
        return book;
    }
}
