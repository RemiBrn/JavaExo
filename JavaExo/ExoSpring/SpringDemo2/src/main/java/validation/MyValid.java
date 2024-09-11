package validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// On indique que c'est une annotation de validaton
//ValidatedBy = Spécifie la classe du validateur qui contient la logique pour valider
@Constraint(validatedBy = MyValidConstraintValidator.class)
// Indique les éléments sur lesquels l'annotation peut être appliquée
@Target({ElementType.FIELD, ElementType.METHOD})
// Indique de l'annotation sera disponible à l'exécution
@Retention(RetentionPolicy.RUNTIME)
//le @ indique une interface d'annotation
// @MyValid
public @interface MyValid {
    public String value() default "Toto";
    public String message() default "Le message doit contenir toto !";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
