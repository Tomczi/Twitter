package pl.coderslab.twitter.validation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = DoubleUserValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface DoubleUser {

    String message() default "{doubleUser.error.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

