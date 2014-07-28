package com.twu.biblioteca;

/**
 * Created by yangjing on 14-7-27.
 */
public class People {

    private String name = "";
    private String emailAddress = "";
    private String phoneNumber = "";
    private String password = "";
    People(){}

    People(String name, String emailAddress, String phoneNumber, String password){
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    People(People people){
        name = people.name;
        emailAddress = people.emailAddress;
        phoneNumber = people.phoneNumber;
    }

    public People setName(String name){
        this.name = name;
        return this;
    }

    public People setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
        return this;
    }

    public People setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }

    public People setPassword(String password){
        this.password = password;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof People) {
            People people = (People) obj;
            return this.name.equals(people.name)
                    && this.emailAddress.equals(people.emailAddress)
                    && this.phoneNumber.equals(phoneNumber);
        }
        return super.equals(obj);
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }
}
