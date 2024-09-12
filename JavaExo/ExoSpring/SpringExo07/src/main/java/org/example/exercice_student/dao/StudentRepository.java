package org.example.exercice_student.dao;

import jakarta.validation.constraints.NotBlank;
import org.example.exercice_student.identity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // Rechercher par nom de famille
    List<Student>  findByLastname(String search);

    List<Student> findByLastnameContainingIgnoreCaseOrFirstnameContainingIgnoreCase(String  lastname, String firstname);

    // Trouver des étudiants par âge
    List<Student> findByAgeBetween(int startAge, int endAge);


}
