package org.joksin.multimodule.validation.core.validation;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint (validatedBy = ManufacturerPresenceValidator.class)
public @interface ManufacturerExists {

    String message() default "Manufacturer does not exist";
    Class[] groups() default {};
    Class[] payload() default {};

}
