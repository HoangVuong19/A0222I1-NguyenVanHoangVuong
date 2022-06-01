package _08_clean_code_and_refactoring_java.thuc_hanh.bai_tach_bien;

public class FizzBuzz {
    public static String fizzBuzz(int number) {
        boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;

        if (isFizz && isBuzz)
            return "FizzBuzz";

        if (isFizz)
            return "Fizz";

        if (isBuzz)
            return "Buzz";

        return number + "";
    }
}

// Tách biến ta trỏ vào vùng giá trị cần tách và nhấn tổ hợp ctrl + alt + V