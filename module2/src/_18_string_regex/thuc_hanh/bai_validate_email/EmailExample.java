package _18_string_regex.thuc_hanh.bai_validate_email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExample {
    private static Pattern pattern;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public EmailExample() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    public boolean validate(String regex) {
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static final String[] validEmail = new String[]{"a@gmail.com", "ab@yahoo.com", "abc@hotmail.com"};
    public static final String[] invalidEmail = new String[]{"@gmail.com", "ab@gmail.", "@#abc@gmail.com"};

    public static void main(String args[]) {
        EmailExample emailExample = new EmailExample();
        for (String email : validEmail) {
            boolean isvalid = emailExample.validate(email);
            System.out.println("Email is " + email + " is valid: " + isvalid);
        }
        for (String email : invalidEmail) {
            boolean isvalid = emailExample.validate(email);
            System.out.println("Email is " + email + " is valid: " + isvalid);
        }
    }
}
