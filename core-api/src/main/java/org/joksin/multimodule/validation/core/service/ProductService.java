package org.joksin.multimodule.validation.core.service;

import org.joksin.multimodule.validation.core.model.Product;
import org.joksin.multimodule.validation.core.model.request.CreateProductRequest;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> findById(Integer productId);

    List<Product> findAll();

    Product create(@Valid CreateProductRequest createProductRequest);

}
