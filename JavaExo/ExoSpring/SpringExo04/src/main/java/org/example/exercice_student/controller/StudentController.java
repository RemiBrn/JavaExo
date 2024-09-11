package org.example.exercice_student.controller;

import org.example.exercice_student.model.Student;
import org.example.exercice_student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String addOrEditStudent(@ModelAttribute("student") Student student){
        if(student.getId()!= null){
            studentService.updateStudent(student.getId(), student);
        } else {
            studentService.createStudent(student);
        }
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

//    @RequestMapping("/delete")
//    public String delete(@RequestParam("id") Long id){
//        Student student = studentService.getStudentById(id);
//        studentService.deleteStudent(student);
//        return "redirect:/students";
//    }

        @RequestMapping("/delete")
    public String delete(@RequestParam("studentId") Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @RequestMapping("/update")
    public String formUpdate(@RequestParam("studentId") Long id, Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "form";
    }
//
//    @PostMapping("/updateStud")
//    public String updateStudent(@ModelAttribute("student") Student student){
//        studentService.updateStudent(student);
//        return "redirect:/students";
//    }

}
