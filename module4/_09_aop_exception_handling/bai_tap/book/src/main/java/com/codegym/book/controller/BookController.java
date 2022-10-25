package com.codegym.book.controller;

import com.codegym.book.models.Book;
import com.codegym.book.models.Rent;
import com.codegym.book.service.IBookService;
import com.codegym.book.service.IRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    @Autowired
    IBookService bookService;

    @Autowired
    IRentService rentService;

    @GetMapping("")
    public String listBook(Model model) {
        model.addAttribute("list", bookService.findAll());
        return "library";
    }

    @GetMapping("/listRent")
    public String ListRent(Model model) {
        model.addAttribute("listRent", rentService.findAll());
        return "library";
    }

    @GetMapping("/rent/{id}")
    public String rentBook(@PathVariable("id") Integer id, RedirectAttributes attributes) throws Exception {
        Book book = bookService.findById(id);
        Rent rent = new Rent();
        if (book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
            bookService.save(book);
            rent.setId((int) (Math.random()*1000));
            rent.setStatus("đang thuê");
            rent.setBook(book);
            rentService.save(rent);
            attributes.addFlashAttribute("message", "rent success");
        }

        if (book.getQuantity() <= 0) throw new Exception();
        return "redirect:/";
    }

    @GetMapping("/pay")
    public String payBook(@RequestParam("idRent") Integer idRent, RedirectAttributes attributes) throws Exception {
        if (rentService.findById(idRent) == null) {
            throw new Exception();
        } else {
            Rent rent = rentService.findById(idRent);
            rent.setStatus("đã trả");
            rentService.save(rent);
            Book book = bookService.findById(rent.getBook().getId());
            book.setQuantity(book.getQuantity() + 1);
            bookService.save(book);
            attributes.addFlashAttribute("message", "pay success");
        }
        return "redirect:/";
    }

    @ExceptionHandler(Exception.class)
    public String handle() {
        return "error";
    }
}
