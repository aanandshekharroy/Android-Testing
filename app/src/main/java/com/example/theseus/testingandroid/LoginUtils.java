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

    /**
     * Method to check if entered password is atleast of
     * length 8
     * @param password
     * @return
     */
    public boolean checkPasswordSize(String password){
        return password.length()>=8;
    }

    /**
     *
     * Method to check if password has all space character
     * @param password
     * @return
     */
    public boolean checkAllSpacesInPassword(String password){
        if(password.length()==0){
            return false;
        }
        for (int i=0;i<password.length();i++){
            if(password.charAt(i)!=' '){
                return false;
            }
        }
        return true;
    }
}
