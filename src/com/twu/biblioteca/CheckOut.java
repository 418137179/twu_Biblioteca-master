package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yangjing on 14-7-28.
 */
public class CheckOut extends BasicMenu {

    private ArrayList<String> mainmenu = new ArrayList<String>(Arrays.asList("CheckOut Books", "CheckOut Movies"));

    public void doSomething(BibliotecaApp bibliotecaApp, String input){

        while(true) {

            welcomeMessage(input);
            viewFaceBook(mainmenu);

            String mainMenuInput = getInput();
            assert mainMenuInput != null;

            if("Quit".equals(mainMenuInput))  {
                System.out.println("GoodBye CheckOut!");
                break;
            }

            if(!mainmenu.contains(mainMenuInput))
                System.out.println("Select a valid option!");
            else {
                welcomeMessage(mainMenuInput);

                if("CheckOut Books".equals(mainMenuInput)) {
                    while (true) {
                        String checkout = getInput();
                        assert checkout!= null;

                        if("Quit".equals(checkout)){
                            System.out.println("GoodBye Books!");
                            break;
                        }

                        String[] bookInfo;
                        if ((bookInfo = checkout.split(" ")).length != 3) {
                            System.out.println("Please input your book's name,book's author,book's press to match!");
                            continue;
                        }
                        Book book = new Book(bookInfo[0], bookInfo[1], bookInfo[2]);

                        bibliotecaApp.checkOutBook(book);
                    }
                }
                else if("CheckOut Movies".equals(mainMenuInput)){
                    while (true) {
                        String checkout = getInput();
                        assert checkout!= null;

                        if("Quit".equals(checkout)){
                            System.out.println("GoodBye Movies!");
                            break;
                        }

                        String[] movieInfo;
                        if ((movieInfo = checkout.split(" ")).length != 4) {
                            System.out.println("Please input your movie's name,movie's Year,movie's director,movie's rating to match!");
                            continue;
                        }
                        Movie movie = new Movie(movieInfo[0], movieInfo[1], movieInfo[2],Integer.parseInt(movieInfo[3]));

                        bibliotecaApp.checkOutMovie(movie);
                    }
                }
            }
        }
    }
}
