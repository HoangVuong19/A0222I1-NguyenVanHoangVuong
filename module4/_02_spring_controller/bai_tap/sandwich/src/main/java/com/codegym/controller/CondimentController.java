package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class CondimentController {

    @GetMapping()
    public String showHome(){
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam("condiment") String[] condiment, Model model){
        List<String> result = new ArrayList<>();
        Collections.addAll(result, condiment);

        model.addAttribute("result", result);
        return "index";
    }
}
