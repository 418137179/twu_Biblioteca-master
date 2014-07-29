package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yangjing on 14-7-28.
 */
public class MainMenu extends BasicMenu{

    private ArrayList<String> mainmenu = new ArrayList<String>(Arrays.asList("List Books", "List Movies"));

    public void doSomething(BibliotecaApp bibliotecaApp, String input){
        while(true) {

            welcomeMessage(input);
            viewFaceBook(mainmenu);

            String mainMenuInput = getInput();
            assert mainMenuInput != null;

            if("Quit".equals(mainMenuInput))  {
                System.out.println("GoodBye MainMenu!");
                break;
            }

            if(!mainmenu.contains(mainMenuInput))
                System.out.println("Select a valid option!");
            else {

                welcomeMessage(mainMenuInput);

                if("List Books".equals(mainMenuInput)) {
                    viewFaceBook(bibliotecaApp.getLibraryStorageBooksName());
                    while (true) {

                        String bookname = getInput();
                        assert bookname != null;

                        if ("Quit".equals(bookname)) {
                            System.out.println("GoodBye List Books!");
                            break;
                        } else {
                            bibliotecaApp.giveBooksDetail(bookname);
                        }
                    }
                }
                else if("List Movies".equals(mainMenuInput)){
                    viewFaceBook(bibliotecaApp.getLibraryStorageMoviesName());
                    while (true) {

                        String moviename = getInput();
                        assert moviename != null;

                        if ("Quit".equals(moviename)) {
                            System.out.println("GoodBye List Movies!");
                            break;
                        } else {
                            bibliotecaApp.giveMoviesDetail(moviename);
                        }
                    }
                }


            }
        }

    }
}
