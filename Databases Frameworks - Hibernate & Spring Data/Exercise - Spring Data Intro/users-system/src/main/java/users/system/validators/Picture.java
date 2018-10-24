package users.system.validators;

import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Component
@Constraint(validatedBy = PictureValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Picture {

    String message() default "Picture is too big!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
