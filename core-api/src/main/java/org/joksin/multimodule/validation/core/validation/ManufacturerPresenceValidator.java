package org.joksin.multimodule.validation.core.validation;

import org.joksin.multimodule.validation.core.validation.ManufacturerExists;

import javax.validation.ConstraintValidator;

interface ManufacturerPresenceValidator extends ConstraintValidator<ManufacturerExists, Integer> {
}
