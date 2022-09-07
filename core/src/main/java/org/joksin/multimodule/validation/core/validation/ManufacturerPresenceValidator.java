package org.joksin.multimodule.validation.core.validation;

import lombok.AllArgsConstructor;
import org.joksin.multimodule.validation.core.repository.ManufacturerRepository;
import org.joksin.multimodule.validation.core.validation.util.ConstraintValidatorUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
public class ManufacturerPresenceValidator implements ConstraintValidator<ManufacturerExists, Integer> {

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
