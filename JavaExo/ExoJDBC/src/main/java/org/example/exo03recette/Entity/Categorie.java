package org.example.exo03recette.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Categorie {
    private int id;
    private String nom;

}
