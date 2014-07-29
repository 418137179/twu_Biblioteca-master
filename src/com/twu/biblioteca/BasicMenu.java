package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by yangjing on 14-7-28.
 */
public class BasicMenu {

    BasicMenu(){

    }


    public void doSomething(BibliotecaApp bibliotecaApp,String input){

    }

    public void welcomeMessage(String info) {
        System.out.println("**********************************");
        System.out.println(info);
        System.out.println("**********************************");
    }

    public void viewFaceBook(ArrayList<String> facebook){
        for(int temp=0; temp<facebook.size(); temp++){
            if(null != facebook.get(temp))
                System.out.println(facebook.get(temp));
        }
    }

    public String getInput() {

        String input = null;
//        System.out.print("Please input your operation(you could input Quit if you want to leave!):");

        try {
            input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }
}
