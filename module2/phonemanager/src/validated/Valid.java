package validated;

import java.util.Scanner;

public class Valid {
    public static boolean checkDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean checkInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean checkName(String name) {
        return name.matches("[A-Z][a-z]*");
    }

    public static String inputWithEmpty(String field) {
        Scanner sc = new Scanner(System.in);
        String value = "nothing";
        do {
            if (value.isEmpty()){
                System.out.print("Nhập lại " + field + ": ");
            }
            value = sc.nextLine();
        } while (value.trim().isEmpty());

        return value;
    }
}

/*
        1	^regex	    Biểu thức chính quy phải  khớp tại điểm bắt đầu
        2	regex$	    Biểu thức chính quy phải khớp ở cuối dòng
        3	[abc]	    Có thể khớp với a hoặc b hoặc c
        4	[abc][vz]	Có thể khớp với a hoặc b hoặc c theo sau là v hay z
        5	[^abc]	    Khớp với bất kỳ ký tự nào ngoại trừ a hoặc b hoặc c
        6	[a-d1-7]	Phù hợp với một chuỗi giữa a và điểm d và con số từ 1 đến 7
        7	X|Z	        Tìm X hoặc Z
        8	XZ	        Tìm X và theo sau là Z

        9	\d	Số bất kỳ, viết ngắn gọn cho [0-9]
        10	\D	Ký tự không phải là số, viết ngắn gon cho [^0-9]
        11	\s	Ký tự khoảng trắng
        12	\S	Ký tự không phải khoản trắng
        13	\w	Ký tự chữ, viết ngắn gọn cho [a-zA-Z0-9]
        14	\W	Ký tự không phải chữ, viết ngắn gọn cho [^\w]
        15	\S+	Một số ký tự không phải khoảng trắng (Một hoặc nhiều)
        16	\b	Ký tự thuộc a-z hoặc A-Z hoặc 0-9 hoặc _, viết ngắn gọn cho [a-zA-Z0-9_]

        17	*	    Xuất hiện 0 hoặc nhiều lần, viết ngắn gọn cho {0,}
        18	+	    Xuất hiện 1 hoặc nhiều lần, viết ngắn gọn cho {1,}
        19	?	    Xuất hiện 0 hoặc 1 lần, ? viết ngắn gọn cho {0,1}
        20	{X}	    Xuất hiện X lần
        21	{X,Y}	Xuất hiện trong khoảng X tới Y lần.

        22    \.[{(*+?^$|  dùng \\ để mô tả
*/