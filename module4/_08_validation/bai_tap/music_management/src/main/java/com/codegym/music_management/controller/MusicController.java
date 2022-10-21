package com.codegym.music_management.controller;

import com.codegym.music_management.model.Music;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MusicController {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("music", new Music());
        return "form";
    }

    @PostMapping("/checkValid")
    public String validUser(@Valid @ModelAttribute("music") Music music, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("message", "Create Fail");
        }
        return "form";
    }
}
