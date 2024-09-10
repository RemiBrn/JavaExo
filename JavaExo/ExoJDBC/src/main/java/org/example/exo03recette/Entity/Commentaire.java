package org.example.exo03recette.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Commentaire {
    private int id;
    private String description;
    private int recetteId;
}
