package com.codegym.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService {
    static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chao");
        dictionary.put("beautiful", "xinh dep");
        dictionary.put("world", "the gioi");
        dictionary.put("red", "màu đỏ");
    }

    public String search(String character) {
        return dictionary.get(character);
    }
}
