package com.twu.biblioteca;

/**
 * Created by yangjing on 14-7-27.
 */
public class People {

    protected String name = "";
    protected String emailAddress = "";
    protected String phoneNumber = "";
    protected String password = "";
    protected String duty;

    People(){}

    People(String name, String emailAddress, String phoneNumber, String password,String duty){
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.duty = duty;
    }

    People(People people){
        name = people.name;
        emailAddress = people.emailAddress;
        phoneNumber = people.phoneNumber;
        password = people.password;
        duty = people.duty;
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

    public void setDuty(String duty){
        this.duty = duty;
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

    public String getDuty() {
        return duty;
    }
}
