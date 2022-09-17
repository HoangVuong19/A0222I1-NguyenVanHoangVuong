package com.example.ss14_examination.util;

import com.example.ss14_examination.modal.Product;

import java.util.HashMap;
import java.util.Map;

public class Validation {
    public static Map<String, String> checkValidAdd(Product product) {
        Map<String, String> map = new HashMap<>();

        if (product.getName().equals("")) {
            map.put("name", "name is not null");
        }
        if (product.getPrice() == -1) {
            map.put("price", "price is not null");
        } else if (product.getPrice() < 0) {
            map.put("price", "price must not have negative value");
        }
        if (product.getQuantity() == -1) {
            map.put("quantity", "quantity is not null");
        } else if (product.getQuantity() < 0) {
            map.put("quantity", "quantity must not have negative value");
        }
        if (product.getColor().equals("")) {
            map.put("color", "color is not null");
        }
        if (product.getDescription().equals("")) {
            map.put("description", "description is not null");
        }
        return map;
    }
}
