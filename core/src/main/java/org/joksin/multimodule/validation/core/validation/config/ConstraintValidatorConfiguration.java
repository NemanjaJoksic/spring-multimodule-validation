package org.joksin.multimodule.validation.core.validation.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Configuration
public class ConstraintValidatorConfiguration {

    @Bean
    public Validator validator(ConstraintValidatorFactoryImpl constraintValidatorFactory) {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class).configure()
                .constraintValidatorFactory(constraintValidatorFactory)
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }

}
