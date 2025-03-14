package pzn.validation.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pzn.validation.data.CaseMode;

public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {
    private CaseMode caseMode;


    @Override
    public void initialize(CheckCase constraintAnnotation) {
        this.caseMode = constraintAnnotation.mode();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) return true;

        if (caseMode == CaseMode.UPPER){
            return s.equals(s.toUpperCase());
        } else if (caseMode == CaseMode.LOWER){
            return s.equals(s.toLowerCase());
        }

        return false;
    }
}
