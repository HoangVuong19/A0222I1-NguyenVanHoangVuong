package com.codegym.controller;

import com.codegym.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping()
    public String showHome(){
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam String character, Model model){
        String result = dictionaryService.search(character);
        if (result == null) {
            result = "not found";
        }
        model.addAttribute("result", result);
        return "result";
    }
}
