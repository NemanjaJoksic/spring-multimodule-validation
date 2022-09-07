package org.joksin.multimodule.validation.restapi.mapper;

import org.joksin.multimodule.validation.core.model.Product;
import org.joksin.multimodule.validation.restapi.dto.ProductDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static List<ProductDTO> toDTOs(List<Product> products) {
        return products.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .manufacturer(ManufacturerMapper.toDTO(product.getManufacturer()))
                .build();
    }

}
