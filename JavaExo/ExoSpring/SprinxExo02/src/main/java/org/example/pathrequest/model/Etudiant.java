package org.example.pathrequest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Etudiant {
    private String lastname;
    private String firstname;
    private int age;
    private String email;

}
