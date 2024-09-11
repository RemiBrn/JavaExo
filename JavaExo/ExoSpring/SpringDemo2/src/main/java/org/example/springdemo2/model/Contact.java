package org.example.springdemo2.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class Contact {
    @NotNull(message = "Ce champ ne peut pas être vide")
    @NotBlank()
    private String firstname;
    @Size(min = 3, message = "Minimum 3 lettres svp !")
    private String lastname;
    @Min(18)
    @Max(77)
    private int age;
}

