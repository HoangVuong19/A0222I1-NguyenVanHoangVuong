package com.codegym.cart.controller;

import com.codegym.cart.model.Product;
import com.codegym.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    IProductService productService;

    @ModelAttribute("cart")
    public List<Product> cartDetail() {
        return new ArrayList<>();
    }

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("list", productService.findAll());
        return "home";
    }

    @GetMapping("/add/{id}")
    public String addCart(@PathVariable Long id, @ModelAttribute("cart") List<Product> carts, RedirectAttributes attributes) {
        Product product = productService.findById(id);
        carts.add(product);
        attributes.addFlashAttribute("message", "Add Cart Success!!!");
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String getCart(@ModelAttribute("cart") List<Product> carts, Model model) {
        model.addAttribute("list", carts);
        return "cart";
    }
}
