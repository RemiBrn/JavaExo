package org.example.exercice_student.controller;

import org.example.exercice_student.model.Student;
import org.example.exercice_student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String formAddStudent(Model model){
        model.addAttribute("student", new Student());
        return "form";
    }

    @PostMapping("/add")
    public String submitFormAddStudent(@ModelAttribute("student") Student student){
        studentService.createStudent(student.getLastname()
                ,student.getFirstname()
                ,student.getAge()
                ,student.getEmail());
        return "redirect:/students";
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


    @RequestMapping("/search") // /search?lastname=Toto
    public String searchStudentByName(@RequestParam(name = "lastname", required = false) String lastname, Model model) {
        List<Student> students = studentService.searchStudents(lastname);

        if (students.isEmpty()) {
            model.addAttribute("message", "Aucun étudiant trouvé avec le nom : " + lastname);
        } else {
            model.addAttribute("students", students);
        }

        return "search"; // Redirige vers la vue search.html
    }


}
