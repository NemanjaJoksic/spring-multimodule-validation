package org.joksin.multimodule.validation.core.validation;

import lombok.AllArgsConstructor;
import org.joksin.multimodule.validation.core.repository.ManufacturerRepository;
import org.joksin.multimodule.validation.core.validation.util.ConstraintValidatorUtil;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@AllArgsConstructor
public class ManufacturerPresenceValidatorImpl implements ManufacturerPresenceValidator {

    private final ManufacturerRepository manufacturerRepository;

    @Override
    public boolean isValid(Integer manufacturerId, ConstraintValidatorContext context) {
        if (manufacturerId != null && !manufacturerRepository.existsById(manufacturerId)) {
            ConstraintValidatorUtil.setCustomMessage(context, String.format("Manufacturer with id %s does not exist", manufacturerId));
            return false;
        }
        return true;
    }

}
