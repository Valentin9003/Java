package softuni.gamestore.demo.validators;

import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Component
@Constraint(validatedBy = ImageUrlValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ImageUrl {

    String message() default "Invalid Thumbnail URL!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
