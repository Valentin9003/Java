package users.system.validators;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PictureValidator implements ConstraintValidator<Picture, byte[]>{

    @Override
    public void initialize(Picture picture) {

    }

    @Override
    public boolean isValid(byte[] picture, ConstraintValidatorContext constraintValidatorContext) {
        if (picture.length > (1024 * 1024)) {
            return false;
        }
        return true;
    }
}
