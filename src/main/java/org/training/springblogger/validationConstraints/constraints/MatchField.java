package org.training.springblogger.validationConstraints.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.training.springblogger.validationConstraints.validatorClasses.FieldMatchValidator;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldMatchValidator.class)
public @interface MatchField {

    String message() default "Fields must match";

    String field();

    String fieldMatcher();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented

    @interface List {
        MatchField[] value();
    }
}
