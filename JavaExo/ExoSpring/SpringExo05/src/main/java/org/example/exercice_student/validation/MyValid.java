package org.example.demo_validation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// On indique que c'est une annotation de validation
// ValidatedBy = Spécifie la classe du validateur qui contient la logique pour valider
@Constraint(validatedBy = org.example.exercice_student.validation.MyValidConstraintValidator.class)
// Indique les éléments sur lequels l'annotation peut être appliquée
@Target({ElementType.FIELD, ElementType.METHOD})
// Indique que l'annotation sera disponible à l'exécution
@Retention(RetentionPolicy.RUNTIME)
// le @ pour indiquer une interface d'annotation
// @MyValid
public @interface MyValid {
    //  @MyValid(value="tata", message = "Le message doit contenir tata !")
    public String value() default "toto";
    public String message() default "Le message doit contenir toto !";
    // Permet de regrouper des contraintes de validation
    public Class<?>[] groups() default {};
    // Peut servir pour spécifier le niveau de gravité d'une erreur, pour une gestion plus poussée
    public Class<? extends Payload>[] payload() default {};
}
