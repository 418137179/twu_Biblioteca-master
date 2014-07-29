package com.twu.biblioteca;

/**
 * Created by yangjing on 14-7-27.
 */
public class Student extends People {

    private String duty = "student";
    Student(){super();}

    Student(String name, String emailAddress, String phoneNumber, String password,String duty){
        super(name,emailAddress,phoneNumber,password,duty);
    }
}

