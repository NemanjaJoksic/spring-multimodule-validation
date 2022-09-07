package org.joksin.multimodule.validation.core.service;

import lombok.AllArgsConstructor;
import org.joksin.multimodule.validation.core.model.Product;
import org.joksin.multimodule.validation.core.model.request.CreateProductRequest;
import org.joksin.multimodule.validation.core.repository.ManufacturerRepository;
import org.joksin.multimodule.validation.core.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Validated
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ManufacturerRepository manufacturerRepository;

    public Optional<Product> findById(Integer productId) {
        Product product = productRepository.findById(productId);
        return Optional.ofNullable(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product create(@Valid CreateProductRequest createProductRequest) {
        Product product = Product.builder()
                .name(createProductRequest.getName())
                .price(createProductRequest.getPrice())
                .manufacturer(manufacturerRepository.findById(createProductRequest.getManufacturerId()))
                .build();

        return productRepository.add(product);
    }

}
