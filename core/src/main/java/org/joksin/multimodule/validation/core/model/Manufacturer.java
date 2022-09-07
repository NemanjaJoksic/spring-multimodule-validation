package org.joksin.multimodule.validation.core.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Manufacturer extends GenericEntity {

    private final String name;
    private final Country country;

}
