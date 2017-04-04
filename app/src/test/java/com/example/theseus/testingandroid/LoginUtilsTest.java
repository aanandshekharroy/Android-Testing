package com.example.theseus.testingandroid;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LoginUtilsTest {
    private LoginUtils loginUtils;
    @Before
    public void setUp(){
        loginUtils=new LoginUtils();
    }
    @Test
    public void isEmailAddressValid() throws Exception {
        assertTrue(loginUtils.isValidEmailAddress("as@b.c"));
    }

    /**
     * Requirement 6
     * Test to test if the password length is atleast of 8 character
     * @throws Exception
     */
    @Test
    public void isPasswordSizeValid () throws Exception{
        assertTrue(loginUtils.checkPasswordSize("12345678"));
        assertFalse(loginUtils.checkPasswordSize("123"));
        assertFalse(loginUtils.checkPasswordSize(""));
    }

    /**
     * Requirement 7
     * Test if password is all spaces
     * @throws Exception
     */
    @Test
    public void isPasswordAllSpace() throws Exception{
        assertTrue(loginUtils.checkAllSpacesInPassword("       "));
        assertFalse(loginUtils.checkAllSpacesInPassword("   l    "));
        assertFalse(loginUtils.checkAllSpacesInPassword(""));
    }
}