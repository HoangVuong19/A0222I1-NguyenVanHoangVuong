package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping()
    public String showHome(){
        return "index";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam Double num1, Double num2, String operator, Model model) {
        String result = "";

        switch (operator) {
            case "+":
                result = String.valueOf(num1 + num2);
                break;
            case "-":
                result = String.valueOf(num1 - num2);
                break;
            case "*":
                result = String.valueOf(num1 * num2);
                break;
            case "/":
                result = num2 == 0 ? "Cannot division to zero" : String.valueOf(num1 / num2);
                break;
        }

        model.addAttribute("result", result);
        return "index";
    }
}
