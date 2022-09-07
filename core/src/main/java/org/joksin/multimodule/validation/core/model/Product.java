package org.joksin.multimodule.validation.core.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Product {

    private final Integer id;
    private final String name;
    private final Double price;
    private final Manufacturer manufacturer;

}
