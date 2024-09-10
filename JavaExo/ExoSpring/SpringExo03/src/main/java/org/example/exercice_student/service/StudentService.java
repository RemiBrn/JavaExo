package org.example.exercice_student.service;

import org.example.exercice_student.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final List<Student> students = new ArrayList<>();
    private Long currentId = 1L;

    public StudentService(){
        Student student = new Student(currentId++, "Macfly", "Marty", 25, "martymac@email.fr");
        students.add(student);

    }


    public Student createStudent(String lastname, String firstname, int age, String email) {
        Student student = new Student(currentId++, lastname, firstname, age, email);
        students.add(student);
        return student;
    }

    public List<Student> getAllStudents(){
        return students;
    }

    public Student getStudentById(Long id){
        return students.stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Student> searchStudents(String search){
        return students.stream().filter(student -> student.getLastname().toLowerCase().contains(search.toLowerCase())).toList();
    }
}
