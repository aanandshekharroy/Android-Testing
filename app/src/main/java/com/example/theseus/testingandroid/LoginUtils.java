package com.example.theseus.testingandroid;

/**
 * Created by theseus on 4/4/17.
 */

public class LoginUtils {

    /**
     * A simple method to check if email address is valid according to
     * following criteria.
     * --- has an "@" sign,
     * --- has at least 1 character before the "@" sign,
     * --- has at least 3 characters, including a "." after the "@" sign
     * @param email
     * @return
     */
    public static boolean isValidEmailAddress(String email){
        int index_of_at=email.indexOf("@");
        if(index_of_at==-1){
            return false;
        }
        if(index_of_at==0){
            return false;
        }
        String sub_string=email.substring(index_of_at);
        if(sub_string.length()>3&&sub_string.contains(".")){
            return true;
        }
        return false;
    }

    /**
     * Method to check if entered password is atleast of
     * length 8
     * @param password
     * @return
     */
    public static boolean checkPasswordSize(String password){
        return password.length()>=8;
    }

    /**
     *
     * Method to check if password has all space character
     * @param password
     * @return
     */
    public static boolean isPasswordAllSpace(String password){
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
