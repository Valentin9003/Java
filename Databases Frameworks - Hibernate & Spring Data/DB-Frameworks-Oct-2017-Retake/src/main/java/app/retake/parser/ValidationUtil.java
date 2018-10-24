package app.retake.parser;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import java.util.Set;

@Component
public final class ValidationUtil {

    public static <T> boolean isValid(T t) {
        /** Set<> with errors */
        Set<ConstraintViolation<T>> errorsSet = Validation
                        .buildDefaultValidatorFactory()
                        .getValidator()
                        .validate(t);

        /** Return True id don't have errors and false if have */
        return errorsSet.size() == 0;
    }
}
