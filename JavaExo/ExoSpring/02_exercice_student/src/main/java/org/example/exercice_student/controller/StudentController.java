package org.example.exercice_student.controller;

import org.example.exercice_student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/formulaire")
    public String formAddStudent(){
        return "form";
    }

    @RequestMapping("/students") // /students?search=Toto
    public String showStudents(@RequestParam(name = "search", required = false) String search, Model model){
        if (search == null) {
            model.addAttribute("students", studentService.getAllStudents());
        } else {
            model.addAttribute("students", studentService.searchStudents(search));
        }
        return "list";
    }

    @RequestMapping("/student/{id}")
    public String showStudent(@PathVariable("id") Long id, Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "detail";
    }
}
