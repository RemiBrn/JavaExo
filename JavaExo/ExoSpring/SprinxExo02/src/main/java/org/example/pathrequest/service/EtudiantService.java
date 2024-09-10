package org.example.pathrequest.service;

import org.example.pathrequest.model.Etudiant;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EtudiantService {
    private final List<Etudiant> etudiants;

    public EtudiantService() {
        etudiants = new ArrayList<>();

        Etudiant etudiantA = Etudiant.builder()
                .lastname("MacFly")
                .firstname("Jack")
                .age(17)
                .email("jack@gmail.com")
                .build();


        Etudiant etudiantB = Etudiant.builder()
                .lastname("MacLane")
                .firstname("John")
                .age(16)
                .email("john@gmail.com")
                .build();

        etudiants.add(etudiantA);
        etudiants.add(etudiantB);


    }

    public Etudiant createStudent(String lastname, String firstname, int age, String email) {
        Etudiant etudiant = new Etudiant(lastname, firstname, age, email);
        etudiants.add(etudiant);
        return etudiant;
    }

    public List<Etudiant> getAllStudents() {
        return etudiants;
    }

    public Etudiant findStudentByName(String lastname) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getLastname().equalsIgnoreCase(lastname)) {
                return etudiant;
            }
        }
        return null;
    }

    public Etudiant getStudentDetails(String lastname) {
        return findStudentByName(lastname);
    }


}
