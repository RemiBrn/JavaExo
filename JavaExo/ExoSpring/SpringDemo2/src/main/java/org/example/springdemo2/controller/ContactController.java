package org.example.springdemo2.controller;

import jakarta.validation.Valid;
import org.example.springdemo2.model.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ContactController {

    @RequestMapping("/form")
    public String form(Model model){
        model.addAttribute("contact", new Contact());
        return "form";
    }

    @PostMapping("/add")
    public String addContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";

        }else {
            return "form-confirm";
        }
    }
}
