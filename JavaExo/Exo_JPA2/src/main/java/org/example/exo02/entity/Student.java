package org.example.exo02.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private int id;
    private String firstname;
    private String lastname;
    private String classe;
    @OneToOne(mappedBy="student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Adresse adresse;
    @OneToMany(mappedBy="student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Examen> examen;



}
