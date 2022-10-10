package com.codegym.student_management.controller;

import com.codegym.student_management.model.Student;
import com.codegym.student_management.service.IClassRoomService;
import com.codegym.student_management.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassRoomService classRoomService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("studentList", studentService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("classRooms", classRoomService.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String save(Student student, RedirectAttributes redirect){
        studentService.save(student);
        redirect.addFlashAttribute("success", "add thành công");
        return "redirect:/student";
    }

    @GetMapping("/{id}/edit")
    public String showFormEdit(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.findById(id));
        model.addAttribute("classRooms", classRoomService.findAll());
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Student student, RedirectAttributes redirect){
        studentService.save(student);
        redirect.addFlashAttribute("success", "edit thành công");
        return "redirect:/student";
    }

    @GetMapping("/{id}/view")
    public String showFormView(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.findById(id));
        return "view";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirect){
        studentService.deleteById(id);
        redirect.addFlashAttribute("success", "delete thành công");
        return "redirect:/student";
    }
}
