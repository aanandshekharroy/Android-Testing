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
}