package com.example.demo.controller;

import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @Autowired
    ICategoryService categoryService;

    @RequestMapping("")
    public String goHome(Model model){
        model.addAttribute("categoryList",categoryService.findAll());
        return "home";
    }
}
