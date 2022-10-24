package com.codegym.image.controller;

import com.codegym.image.model.Image;
import com.codegym.image.service.IImageService;
import com.codegym.image.utils.FeedBackBad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ImageController {

    @Autowired
    IImageService imageService;

    @GetMapping("")
    public String showHome(Model model) {
        model.addAttribute("form", new Image());
        return "form";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute("form") Image image, RedirectAttributes redirectAttributes) throws Exception {
        imageService.save(image);
        for (String e: FeedBackBad.badFeedBack) {
            if (image.getFeedBack().equals(e)){
                throw new Exception();
            }
        }
        redirectAttributes.addFlashAttribute("urlImage",image.getUrlImage());
        redirectAttributes.addFlashAttribute("list",imageService.findById(image.getIdImage()));
        return "redirect:/";
    }

    @ExceptionHandler(Exception.class)
    public String handle() {
        return "error";
    }
}
