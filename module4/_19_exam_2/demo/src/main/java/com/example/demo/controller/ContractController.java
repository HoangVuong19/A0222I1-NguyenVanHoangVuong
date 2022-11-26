package com.example.demo.controller;

import com.example.demo.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContractController {

    @Autowired
    private IContractService contractService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("contractList", contractService.findAll());
        return "home";
    }
}
