package softuni.gamestore.demo.validators;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ImageUrlValidator implements ConstraintValidator<ImageUrl, String> {

    @Override
    public void initialize(ImageUrl constraintAnnotation) {

    }

    @Override
    public boolean isValid(String url, ConstraintValidatorContext constraintValidatorContext) {
        return (url.startsWith("http://") || url.startsWith("https://") || url == null);
    }
}
