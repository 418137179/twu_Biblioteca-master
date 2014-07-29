package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yangjing on 14-7-29.
 */
public class Lend extends BasicMenu {
    private ArrayList<String> mainmenu = new ArrayList<String>(Arrays.asList("Lend Books", "Lend Movies"));

    public void doSomething(BibliotecaApp bibliotecaApp,String input){
        while(true) {

            welcomeMessage(input);
            viewFaceBook(mainmenu);

            String mainMenuInput = getInput();
            assert mainMenuInput != null;

            if("Quit".equals(mainMenuInput))  {
                System.out.println("GoodBye Lend!");
                break;
            }

            if(!mainmenu.contains(mainMenuInput))
                System.out.println("Select a valid option!");
            else {
                welcomeMessage(mainMenuInput);
                if("Lend Books".equals(mainMenuInput)) {
                    viewFaceBook(bibliotecaApp.getLibraryLendBooksName());
                    while (true) {

                        String bookname = getInput();
                        assert bookname != null;

                        if ("Quit".equals(bookname)) {
                            System.out.println("GoodBye Lend Books!");
                            break;
                        } else {
                            bibliotecaApp.giveBooksOwnerDetail(bookname);
                        }
                    }
                }
                else if("Lend Movies".equals(mainMenuInput)){
                    viewFaceBook(bibliotecaApp.getLibraryLendMoviesName());
                    while (true) {

                        String moviename = getInput();
                        assert moviename != null;

                        if ("Quit".equals(moviename)) {
                            System.out.println("GoodBye Lend Movies!");
                            break;
                        } else {
                            bibliotecaApp.giveMoviesOwnerDetail(moviename);
                        }
                    }
                }
            }
        }
    }
}
