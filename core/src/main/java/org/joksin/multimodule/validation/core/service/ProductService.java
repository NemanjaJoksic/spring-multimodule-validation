package org.joksin.multimodule.validation.core.service;

import org.joksin.multimodule.validation.core.model.Manufacturer;
import org.joksin.multimodule.validation.core.model.Product;
import org.joksin.multimodule.validation.core.model.request.CreateProductRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class ProductService {

    public Optional<Product> findById(Integer productId) {
        return Optional.empty();
    }

    public List<Product> findAll() {
        return Collections.emptyList();
    }

    public Product create(@Valid CreateProductRequest createProductRequest) {
        return Product.builder()
                .id(1)
                .name(createProductRequest.getName())
                .price(createProductRequest.getPrice())
                .manufacturer(Manufacturer.builder().id(createProductRequest.getManufacturerId()).build())
                .build();
    }

}
