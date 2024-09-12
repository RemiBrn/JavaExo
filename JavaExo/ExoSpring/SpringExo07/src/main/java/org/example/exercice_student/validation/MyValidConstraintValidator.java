package org.example.exercice_student.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MyValidConstraintValidator implements ConstraintValidator<MyValid, String> {
    private String charContain;

    @Override
    public void initialize(org.example.exercice_student.validation.MyValid constraintAnnotation) {
        // Cette ligne initialise le champ charContain avec la valeur spécifiée dans value()
        charContain = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = false;

        if(s != null){
            result = s.contains(charContain);
        }

        return result;
    }
}
