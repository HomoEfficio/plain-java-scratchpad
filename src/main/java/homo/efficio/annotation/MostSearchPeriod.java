package homo.efficio.annotation;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author homo.efficio@gmail.com
 * created on 2018-04-04
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {SearchPeriodValidator.class})
public @interface MostSearchPeriod {

    String message() default "기간이 유효하지 않습니다.";

    int max() default 90;

    int min() default 1;
}
