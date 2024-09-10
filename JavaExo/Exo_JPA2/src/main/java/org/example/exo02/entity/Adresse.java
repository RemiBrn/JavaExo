package org.example.exo02.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="adresse")


public class Adresse {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_adresse" )
    private int id;
    private int numero;
    private String rue;
    private String ville;
    private int codePostal;

    @OneToOne
    @JoinColumn(name = "id_student")
    private Student student;
}

