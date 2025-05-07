package org.training.springblogger.validationConstraints.validatorClasses;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;
import org.training.springblogger.validationConstraints.constraints.FieldMatcher;

public class FieldMatchValidator implements ConstraintValidator<FieldMatcher, Object> {
    private String field;
    private String fieldMatch;
    private String message;


    @Override
    public void initialize(FieldMatcher constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatcher();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(value).getPropertyValue(fieldMatch);

        boolean isValid = (fieldValue == null && fieldMatchValue == null) || (fieldValue != null && fieldValue.equals(fieldMatchValue));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(fieldMatch)
                    .addConstraintViolation();
        }

        return isValid;
    }
}
