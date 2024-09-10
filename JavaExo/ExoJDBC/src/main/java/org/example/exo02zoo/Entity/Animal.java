package org.example.exo02zoo.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Animal {
    private int id;
    private String nom;
    private String race;
    private String habitat;
    private String description;
    private int age;


}
