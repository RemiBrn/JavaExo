package org.example.exo03recette.Entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class Recette
{
    private String nom;
    private int tempsPrep; // le temps sera exprimé en nombre de minutes
    private int tempsCuisson;
    private String difficulte;
    private List<Ingredient> ingredients;
    private List<Etape> etapes;
    private List<Commentaire> commentaires;
    private Categorie categorie;
}
