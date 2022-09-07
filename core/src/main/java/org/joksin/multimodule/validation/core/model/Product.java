package org.joksin.multimodule.validation.core.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Product extends GenericEntity {

    private final String name;
    private final Double price;
    private final Manufacturer manufacturer;

}
