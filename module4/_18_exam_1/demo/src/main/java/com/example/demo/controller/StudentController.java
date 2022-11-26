package com.example.demo.controller;

import com.example.demo.service.IClassService;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClassService classService;

//    @GetMapping("")
//    public String showListStudent(Model model){
//        model.addAttribute("studentList", studentService.findAllStudent());
//        model.addAttribute("classList", classService.findAll());
//        return "home";
//    }

    @GetMapping("")
    public String showListSearch(Model model,
                                 @RequestParam(value = "searchName", defaultValue = "") String searchName,
                                 @RequestParam(value = "page", defaultValue = "0") int page){
        Sort sort = Sort.by("id").ascending();
        model.addAttribute("studentList", studentService.paging(searchName, PageRequest.of(page, 3, sort)));
        model.addAttribute("classList", classService.findAll());
        model.addAttribute("name", searchName);
        return "home";
    }
}
