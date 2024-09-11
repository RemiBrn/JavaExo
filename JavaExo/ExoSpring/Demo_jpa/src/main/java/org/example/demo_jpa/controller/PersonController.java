package org.example.demo_jpa.controller;

import org.example.demo_jpa.dao.PersonRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.PersonService;

public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("personnes", personService.findAll());
        return "home";

    }
}
