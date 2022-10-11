package org.joksin.multimodule.validation.core.validation;

import lombok.AllArgsConstructor;
import org.joksin.multimodule.validation.core.repository.ManufacturerRepository;
import org.joksin.multimodule.validation.core.validation.util.ConstraintValidatorUtil;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidatorContext;

@Component
@AllArgsConstructor
class ManufacturerPresenceValidatorImpl implements ManufacturerPresenceValidator {

    private final ManufacturerRepository manufacturerRepository;

    @Override
    public boolean isValid(Integer manufacturerId, ConstraintValidatorContext context) {
        boolean isValid = true;

        context.disableDefaultConstraintViolation();

        if (manufacturerId != null && !manufacturerRepository.existsById(manufacturerId)) {
            ConstraintValidatorUtil.addConstraintViolation(context, String.format("Manufacturer with id %s does not exist", manufacturerId));
            isValid = false;
        }

        return isValid;
    }

}
