package org.training.springblogger.validationConstraints.validatorClasses;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;
import org.training.springblogger.validationConstraints.constraints.MatchField;

public class FieldMatchValidator implements ConstraintValidator<MatchField, Object> {
    private String field;
    private String fieldMatch;
    private String message;


    @Override
    public void initialize(MatchField constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatcher();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(value).getPropertyValue(fieldMatch);

        boolean isValid = fieldValue != null && fieldValue.equals(fieldMatchValue);

        if (!isValid) handleViolation(context);

        return isValid;
    }

    private void handleViolation(ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message).addPropertyNode(fieldMatch).addConstraintViolation();
    }
}
