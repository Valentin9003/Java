package users.system.validators;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class AgeValidator implements ConstraintValidator<Age, Integer> {

    @Override
    public void initialize(Age age) {

    }

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext constraintValidatorContext) {
        if (age < 1 || age > 120) {
            return false;
        }
        return true;
    }
}
