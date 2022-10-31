package com.codegym.cart.error;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleError {
    @ExceptionHandler(Exception.class)
    public String goError(Exception e, Model model) {
        model.addAttribute("message", e);
        return "error";
    }

}
