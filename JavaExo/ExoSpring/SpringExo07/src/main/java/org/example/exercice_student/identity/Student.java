package org.example.exercice_student.identity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exercice_student.validation.MyValid;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "Etudiant")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Ce champ ne peut pas être vide ")
    @MyValid
    private String lastname;
    @NotBlank(message = "Ce champ ne peut pas être vide ")
    private String firstname;
    @Min(12)
    @Max(36)
    private int age;
    @NotBlank(message = "Ce champ ne peut pas être vide ")
    @Email
    private String email;
}
