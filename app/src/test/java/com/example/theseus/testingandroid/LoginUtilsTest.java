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

    /**
     * Requirement 8
     * Test if the email is according to following criteria.
     * --- has an "@" sign,
     * --- has at least 1 character before the "@" sign,
     * --- has at least 3 characters, including a "." after the "@" sign
     * @throws Exception
     */
    @Test
    public void isEmailAddressValid() throws Exception {
        assertTrue(loginUtils.isValidEmailAddress("a@bcc.sd"));
        assertFalse(loginUtils.isValidEmailAddress("@b.c"));
        assertFalse(loginUtils.isValidEmailAddress("as@b."));
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
        assertTrue(loginUtils.isPasswordAllSpace("       "));
        assertFalse(loginUtils.isPasswordAllSpace("   l    "));
        assertFalse(loginUtils.isPasswordAllSpace(""));
        assertFalse(loginUtils.isPasswordAllSpace("123456789"));
    }
}