package org.example.spring_demo_base_01.controller;

import org.example.spring_demo_base_01.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller

public class HelloController {

    //Injection de dépendance
    private final GreetingService greetingService;

//    @Autowired
    public HelloController(@Qualifier("salutations") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @RequestMapping("/")
    public String home(){
        return "hello";
    }

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println(greetingService.sayHello());
        return "hello";

    }

    @RequestMapping("/json")
    // Conversion automatique de la valeur de retour en format JSON
    @ResponseBody
    public List<String> getPersons(){
        return List.of("John", "Jane", "Jean");

    }

    @RequestMapping("/person")
    public String personName(Model model){
        model.addAttribute("firstname", "June"); //on envoie une variable du nom de firstname avec une valeur "June"
        model.addAttribute("lastname", "Gray");

        List<String> persons = List.of("John", "Jane", "June");
        model.addAttribute("persons", persons);
        return "person/details";
    }


}
