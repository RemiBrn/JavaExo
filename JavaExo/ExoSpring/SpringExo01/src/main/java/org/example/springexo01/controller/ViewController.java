package org.example.springexo01.controller;

import org.example.springexo01.model.ToDo;
import org.example.springexo01.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ViewController {

    private final ToDoService toDoService;

    @Autowired
    public ViewController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @RequestMapping("/")
    public String index(){
        return "home";
    }


    @RequestMapping(value = "/home")
    public String home() {
        return "home";
    }


    @RequestMapping(value = "/alltodos")
    @ResponseBody
    public List<ToDo> getAllTodos() {
        return toDoService.getAllTodos();
    }


    @GetMapping("/{name}")
    public String getOneTodo(@PathVariable String name, Model model) {
        ToDo todo = toDoService.getOneTodo(name);
        model.addAttribute("todo", todo);
        return "ToDo/detail";
    }
}
