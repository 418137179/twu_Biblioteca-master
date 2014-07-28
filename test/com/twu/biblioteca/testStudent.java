package com.twu.biblioteca;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by yangjing on 14-7-27.
 */
public class testStudent {

    @Test
    public void student1EqualsStudent2() {
        Student student1 = new Student("student1","","","");
        Student student2 = new Student("student1","","","");
        assertTrue(student1.equals(student2));
    }

    @Test
    public void couldReturnStudentWhenCallSetStudentName() {
        Student expect = new Student("student1","","","");
        Student result = (Student)new Student().setName("student1");
        assertTrue(expect.equals(result));
    }

    @Test
    public void couldReturnStudentWhenCallSetStuedentEmailAddress() {
        Student expect = new Student("","emailaddress1","","");
        Student result = (Student)new Student().setEmailAddress("emailaddress1");
        assertTrue(expect.equals(result));
    }

    @Test
    public void couldReturnStudentWhenCallSetStudentPhoneNumber() {
        Student expect = new Student("","","phonenumber1","");
        Student result = (Student)new Student().setPhoneNumber("phonenumber1");
        assertTrue(expect.equals(result));
    }

    @Test
    public void couldReturnStudentWhenCallSetStudentPassword() {
        Student expect = new Student("","","","password1");
        Student result = (Student)new Student().setPassword("password1");
        assertTrue(expect.equals(result));
    }

    @Test
    public void couldReturnstudent1NameWhenCallGetName() {
        String result  = new Student("student1","","","").getName();
        assertEquals("student1",result);
    }

    @Test
    public void couldReturnemailaddress1WhenCallGetEmailAddress() {
        String result  = new Student("","emailaddress1","","").getEmailAddress();
        assertEquals("emailaddress1",result);
    }

    @Test
    public void couldReturnphonenumber1NameWhenCallGetPhoneNumber() {
        String result  = new Student("student1","","phonenumber1","").getPhoneNumber();
        assertEquals("phonenumber1",result);
    }

    @Test
    public void couldReturnpassword1NameWhenCallGetPassword() {
        String result  = new Student("student1","","phonenumber1","password1").getPassword();
        assertEquals("password1",result);
    }

}
