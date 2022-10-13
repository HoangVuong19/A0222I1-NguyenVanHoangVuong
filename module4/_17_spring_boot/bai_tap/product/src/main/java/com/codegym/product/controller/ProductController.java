package com.codegym.product.controller;

import com.codegym.product.model.Product;
import com.codegym.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showList(Model model, @RequestParam(value = "page", defaultValue = "0")int page){
        // Sort sort = Sort.by("price").descending();
        model.addAttribute("productList", productService.paging(PageRequest.of(page,1)));
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirect){
        productService.save(product);
        redirect.addFlashAttribute("success", "add thành công");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String showFormEdit(Model model, @PathVariable Long id){
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Product product, RedirectAttributes redirect){
        productService.save(product);
        redirect.addFlashAttribute("success", "edit thành công");
        return "redirect:/product";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirect){
        productService.deleteById(id);
        redirect.addFlashAttribute("success", "delete thành công");
        return "redirect:/product";
    }

    @PostMapping("/searchByName")
    public String searchByName(@RequestParam String searchName, Model model){
        model.addAttribute("productList", productService.searchByName(searchName));
        model.addAttribute("name", searchName);
        return "search";
    }

    @PostMapping("/searchByManufacturer")
    public String searchByManufacturer(@RequestParam String searchManufacturer, Model model){
        model.addAttribute("productList", productService.searchByManufacturer(searchManufacturer));
        model.addAttribute("manufacturer", searchManufacturer);
        return "search";
    }
}
