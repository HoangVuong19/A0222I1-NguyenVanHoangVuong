package _18_string_regex.bai_tap.bai_validate_ten_lop_hoc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassExample {
    private static Pattern pattern;

    public static final String REGEX_CLASS = "^[CAP]\\d{4}\\w*[GHIKLM]$";

    public static final String[] value = {"C0318G", "M0318G", "P0323A", "P0323Adsf", "CA0318G"};

    public ClassExample() {
        pattern = Pattern.compile(REGEX_CLASS);
    }

    public boolean validCheck(String regex) {
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) {
        ClassExample classExample = new ClassExample();
        for (String v : value) {
            boolean check = classExample.validCheck(v);
            System.out.println("Class is " + v + " is valid: " + check);
        }
    }
}
