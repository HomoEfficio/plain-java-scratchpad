package homo.efficio.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author homo.efficio@gmail.com
 * created on 2018-04-04
 */
public class SearchPeriodValidator implements ConstraintValidator<MostSearchPeriod, ValidPeriod> {

    @Override
    public void initialize(MostSearchPeriod constraintAnnotation) {

    }

    @Override
    public boolean isValid(ValidPeriod validPeriod, ConstraintValidatorContext context) {
        return validPeriod.isValidPeriod();
    }

}
