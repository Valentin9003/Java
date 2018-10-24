package softuni.gamestore.demo.validators;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EmailValidatorImpl implements ConstraintValidator<EmailValidator, String>{

    @Override
    public void initialize(EmailValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern email =
                Pattern.compile("^[a-zA-Z0-9]+[\\w.-]+[a-zA-Z0-9]+@[a-zA-Z]+[a-zA-Z.]+[a-zA-Z]+$");
        Matcher emailMatcher = email.matcher(value);
        return emailMatcher.find();
    }
}
