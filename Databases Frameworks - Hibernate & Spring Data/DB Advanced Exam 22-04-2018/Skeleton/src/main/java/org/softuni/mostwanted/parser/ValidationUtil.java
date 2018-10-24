package org.softuni.mostwanted.parser;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.Set;

@Component
public final class ValidationUtil {

    public static <T> boolean isValid(T t) {
        Set<ConstraintViolation<T>> errorsSet = Validation
                .buildDefaultValidatorFactory()
                .getValidator()
                .validate(t);

        return errorsSet.size() == 0;
    }
}
