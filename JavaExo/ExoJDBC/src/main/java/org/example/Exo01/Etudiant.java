package org.example.Exo01;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private String numClasse;
    private int anneeDiplome;
}