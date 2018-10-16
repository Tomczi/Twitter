package pl.coderslab.twitter.validation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DoubleUsernameValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface DoubleUsername {

    String message() default "{doubleUser.error.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
