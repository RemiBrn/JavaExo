package org.example.exo02.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Examen {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_exam" )
    private int id;
    private String date;
    private int note; //note sur 20
    private String matiere;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;






}
