package org.joksin.multimodule.validation.restapi.mapper.request;

import org.joksin.multimodule.validation.core.model.request.CreateProductRequest;
import org.joksin.multimodule.validation.restapi.dto.request.CreateProductRequestDTO;

public class CreateProductRequestMapper {

    public static CreateProductRequest fromDTO(CreateProductRequestDTO createProductRequestDto) {
        return CreateProductRequest.builder()
                .name(createProductRequestDto.getName())
                .price(createProductRequestDto.getPrice())
                .manufacturerId(createProductRequestDto.getManufacturerId())
                .build();
    }

}
