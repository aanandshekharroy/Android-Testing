package com.example.theseus.testingandroid;

/**
 * Created by theseus on 4/4/17.
 */

public class LoginUtils {

    /**
     * A simple method to check if email address is valid
     * @param email
     * @return
     */
    public boolean isValidEmailAddress(String email){
        boolean hasAtSign=email.indexOf("@")>-1;
        return hasAtSign;
    }
}
