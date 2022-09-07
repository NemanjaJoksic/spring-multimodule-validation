package org.joksin.multimodule.validation.core.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Manufacturer {

    private final Integer id;
    private final String name;
    private final Country country;

}
