package users.system.validators;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class EmailValidator implements ConstraintValidator<Email, String> {

    @Override
    public void initialize(Email email) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if (!email.matches("^[a-zA-Z0-9]+[\\w.-]+[a-zA-Z0-9]+@[a-zA-Z]+[a-zA-Z.]+[a-zA-Z]+$")) {
            return false;
        }
        return true;
    }
}
