package _18_string_regex.bai_tap.bai_validate_so_dien_thoai;

import _18_string_regex.bai_tap.bai_validate_ten_lop_hoc.ClassExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneExample {
    private static Pattern pattern;

    public static final String REGEX_PHONE = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";

    public static final String[] value = {"(84)-(0978489648)", "(a8)-(22222222)"};

    public PhoneExample() {
        pattern = Pattern.compile(REGEX_PHONE);
    }

    public boolean validCheck(String regex) {
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) {
        PhoneExample phoneExample = new PhoneExample();
        for (String v : value) {
            boolean check = phoneExample.validCheck(v);
            System.out.println("Phone is " + v + " is valid: " + check);
        }
    }
}
