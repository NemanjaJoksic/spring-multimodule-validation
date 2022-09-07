package org.joksin.multimodule.validation.restapi.dto.request;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
public class CreateProductRequestDTO {

    @NotNull
    private final String name;
    private final Double price;
    private final Integer manufacturerId;

}
