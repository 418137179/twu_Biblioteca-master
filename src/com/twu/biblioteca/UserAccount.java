package com.twu.biblioteca;

/**
 * Created by yangjing on 14-7-29.
 */
public class UserAccount extends BasicMenu {

    public void doSomething(BibliotecaApp bibliotecaApp, String input){
        welcomeMessage(input);
        bibliotecaApp.showLoginUserAccounts();
    }
}
