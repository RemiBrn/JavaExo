package org.example.exo02zoo.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Repas {
    private int id;
    private int animalId;
    private String raceAnimal;
    private int gardienId;
    private LocalDate dateRepas;
    private LocalTime heureRepas;
    private String detailsNourriture;

}

