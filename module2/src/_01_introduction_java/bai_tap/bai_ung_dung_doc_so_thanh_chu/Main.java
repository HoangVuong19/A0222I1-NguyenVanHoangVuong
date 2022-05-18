package _01_introduction_java.bai_tap.bai_ung_dung_doc_so_thanh_chu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số: ");
        int num = scanner.nextInt();

        if (num >= 0 && num < 10) {
            System.out.println(oneDigit(num));
        } else if (num < 100) {
            System.out.println(twoDigit(num));
        } else {
            System.out.println(threeDigit(num));
        }
    }

    private static String oneDigit(int num) {
        switch (num) {
            case 0:
                return "rezo";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
        }
        return "night";
    }

    private static String twoDigit(int num) {
        String result;
        if (num >= 10 && num < 20) {
            int teen = num % 10;
            if (teen == 0) {
                result = "ten";
            } else if (teen == 1) {
                result = "eleven";
            } else if (teen == 2) {
                result = "twelve";
            } else if (teen == 3) {
                result = "thirteen";
            } else if (teen == 5) {
                result = "fifteen";
            } else {
                result = oneDigit(teen) + "teen";
            }
            return result;
        } else {
            int ty = num / 10;
            int lastNum = num % 10;
            switch (ty) {
                case 2:
                    result = "twenty";
                    break;
                case 3:
                    result = "thirty";
                    break;
                case 4:
                    result = "forty";
                    break;
                case 5:
                    result = "fifty";
                    break;
                case 6:
                    result = "sixty";
                    break;
                case 7:
                    result = "seventy";
                    break;
                case 8:
                    result = "eighty";
                    break;
                default:
                    result = "ninety";
            }
            if (lastNum != 0) {
                result = result + "-" + oneDigit(lastNum);
            }
            return result;
        }
    }

    private static String threeDigit(int num) {
        String result;
        int hundred = num / 100;
        int lastTwoDigits = num - (hundred * 100);
        switch (hundred) {
            case 1:
                result = "one hundred";
                break;
            case 2:
                result = "two hundred";
                break;
            case 3:
                result = "three hundred";
                break;
            case 4:
                result = "four hundred";
                break;
            case 5:
                result = "five hundred";
                break;
            case 6:
                result = "six hundred";
                break;
            case 7:
                result = "seven hundred";
                break;
            case 8:
                result = "eight hundred";
                break;
            default:
                result = "nine hundred";
        }
        if (lastTwoDigits != 0) {
            result = result + " and " + twoDigit(lastTwoDigits);
        }
        return result;
    }
}
