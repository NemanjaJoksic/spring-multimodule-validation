package org.joksin.multimodule.validation.restapi.mapper;

import org.joksin.multimodule.validation.core.model.Product;
import org.joksin.multimodule.validation.restapi.dto.ProductDTO;

public class ProductMapper {

    public static ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

}
