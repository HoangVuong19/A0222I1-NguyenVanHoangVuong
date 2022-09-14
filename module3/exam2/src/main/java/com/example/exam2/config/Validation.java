package com.example.exam2.config;

public class Validation {
    private static String regexDate ="^[0-9]{4}-[0-9]{2}-[0-9]{2}$";
    private static String regexPhone = "^(094)\\d{7}$|^(092)\\d{7}$";
    private static String regexEmail = "^[a-z]\\w{2,}@gmail.com$";

    public static boolean checkDate(String date){
        return date.matches(regexDate);
    }
    public static boolean checkPhone(String phone) { return phone.matches(regexPhone); }
    public static boolean checkEmail(String email) { return email.matches(regexEmail); }
}
