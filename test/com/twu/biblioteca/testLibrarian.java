package com.twu.biblioteca;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by yangjing on 14-7-28.
 */
public class testLibrarian {

    @Test
    public void couldReturnDutyWhenCallGetDuty() {
        Librarian librarian = new Librarian("librarian1","emailaddress1","phonenumber1","password1","admin");
        String result = librarian.getDuty();
        assertEquals("admin",result);
    }
}
