package org.joksin.multimodule.validation.core.validation.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ConstraintValidatorUtil {

    public static void setCustomMessage(ConstraintValidatorContext context, String message) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
    }

}
