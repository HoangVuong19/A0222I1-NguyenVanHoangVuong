package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/product")
@Controller
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("productList", iProductService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirect){
        product.setId((int) (Math.random()*1000));
        iProductService.save(product);
        redirect.addFlashAttribute("success", "add new succeeded");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String showFormEdit(@PathVariable int id, Model model){
        model.addAttribute("product", iProductService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Product product, RedirectAttributes redirect){
        iProductService.update(product.getId(), product);
        redirect.addFlashAttribute("success", "edit succeeded");
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String remove(@PathVariable int id, RedirectAttributes redirect){
        iProductService.delete(id);
        redirect.addFlashAttribute("success", "delete succeeded");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String showFormView(@PathVariable int id, Model model){
        model.addAttribute("product", iProductService.findById(id));
        return "view";
    }
}
