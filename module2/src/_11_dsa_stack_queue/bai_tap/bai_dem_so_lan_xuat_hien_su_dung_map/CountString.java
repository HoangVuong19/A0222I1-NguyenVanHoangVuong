package _11_dsa_stack_queue.bai_tap.bai_dem_so_lan_xuat_hien_su_dung_map;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class CountString {
    public static void main(String[] args) {
        String str = "Hello World";
        TreeMap<Character, Integer> treeMap = new TreeMap<>();

        Arrays.asList(str.toUpperCase().split("")).forEach(e -> {
            int count = 1;
            if (treeMap.containsKey(e.charAt(0))) {
                count += treeMap.get(e.charAt(0));
            }
            treeMap.put(e.charAt(0), count);
        });

        for (Map.Entry<Character, Integer> s : treeMap.entrySet()) {
            System.out.println(s);
        }
        System.out.println("--------------------------------------------");

        for (Character key: treeMap.keySet()) {
            System.out.println(key + ":" + treeMap.get(key));
        }
    }
}

