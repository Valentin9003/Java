package json.processing.validation;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PhoneValidator implements ConstraintValidator<Phone, String> {

   public void initialize(Phone constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      return obj.matches("[0-9]{8,10}");
   }
}
