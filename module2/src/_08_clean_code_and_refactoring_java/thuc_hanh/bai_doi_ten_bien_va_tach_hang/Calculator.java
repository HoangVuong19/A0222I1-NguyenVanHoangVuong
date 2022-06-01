package _08_clean_code_and_refactoring_java.thuc_hanh.bai_doi_ten_bien_va_tach_hang;

public class Calculator {
    public static int calculate(int firstOperand, int secondOperand, char operator) {
        final char ADDITION = '+';
        final char SUBTRACTION = '-';
        final char MULTIPLICATION = '*';
        final char DIVISION = '/';

        switch (operator) {
            case ADDITION:
                return firstOperand + secondOperand;
            case SUBTRACTION:
                return firstOperand - secondOperand;
            case MULTIPLICATION:
                return firstOperand * secondOperand;
            case DIVISION:
                if (secondOperand != 0)
                    return firstOperand / secondOperand;
                else
                    throw new RuntimeException("Can not divide by 0");
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }
}

// Đổi tên biến ta trỏ vào biến và nhấn tổ hợp ctrl + F6
// Tách hằng ta trỏ vào giá trị cần tách và nhấn tổ hợp ctrl + alt + V
