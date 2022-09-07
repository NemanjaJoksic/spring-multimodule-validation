package org.joksin.multimodule.validation.core.model.request;

import lombok.Builder;
import lombok.Getter;
import org.joksin.multimodule.validation.core.validation.ManufacturerExists;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Builder
public class CreateProductRequest {

    @NotNull
    @NotBlank
    private final String name;

    @NotNull
    @Positive
    private final Double price;

    @NotNull
    @ManufacturerExists
    private final Integer manufacturerId;

}
