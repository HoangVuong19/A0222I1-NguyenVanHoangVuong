package com.example.user.config;

public class Validation {
    private static String regexEmail ="(^[a-zA-z]\\w{2,}@gmail.com)$";
    public static boolean checkEmail(String email){
        return email.matches(regexEmail);
    }
}
