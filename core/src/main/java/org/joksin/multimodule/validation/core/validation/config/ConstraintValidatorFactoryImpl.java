package org.joksin.multimodule.validation.core.validation.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorFactory;

@Slf4j
@Primary
@Component
@AllArgsConstructor
public class ConstraintValidatorFactoryImpl implements ConstraintValidatorFactory {

    private final AutowireCapableBeanFactory beanFactory;

    @Override
    public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> validatorClass) {
        T validator;
        try {
            validator = beanFactory.getBean(validatorClass);
            log.info("Validator {} already created", validatorClass.getSimpleName());
        } catch (NoSuchBeanDefinitionException ex) {
            log.info("Validator {} does not already exist. New instance will be created", validatorClass.getSimpleName());
            validator = beanFactory.createBean(validatorClass);
        }
        log.info("ValidatorClass: {}, implementation: {}", validatorClass.getSimpleName(), validator.getClass().getSimpleName());
        return validator;
    }

    @Override
    public void releaseInstance(ConstraintValidator<?, ?> constraintValidator) {

    }

}
