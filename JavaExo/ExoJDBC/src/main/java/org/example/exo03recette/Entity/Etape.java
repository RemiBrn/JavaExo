package org.example.exo03recette.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder


public class Etape {
    private int id;
    private String description;
    private int recetteId;

}
