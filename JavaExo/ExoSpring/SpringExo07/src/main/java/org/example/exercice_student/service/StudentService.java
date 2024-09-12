package org.example.exercice_student.service;


import org.example.exercice_student.dao.StudentRepository;
import org.example.exercice_student.identity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final List<Student> students = new ArrayList<>();
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);

    }

    public Student updateStudent(Long id, Student updateStudent){
        Student studentExist = getStudentById(id);
        if(studentExist != null){
            studentRepository.save(updateStudent);
        }
        return studentExist;
    }


    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }



    public List<Student> findByLastname(String search) {
        return studentRepository.findByLastname(search);
    }

    public void delete (Student student) {
        studentRepository.delete(student);
    }



}
