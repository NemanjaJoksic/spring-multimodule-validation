package org.joksin.multimodule.validation.restapi.controller;

import lombok.AllArgsConstructor;
import org.joksin.multimodule.validation.core.model.Product;
import org.joksin.multimodule.validation.core.service.ProductService;
import org.joksin.multimodule.validation.restapi.dto.ProductDTO;
import org.joksin.multimodule.validation.restapi.dto.request.CreateProductRequestDTO;
import org.joksin.multimodule.validation.restapi.mapper.ProductMapper;
import org.joksin.multimodule.validation.restapi.mapper.request.CreateProductRequestMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/api/products")
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(ProductMapper.toDTOs(products));
    }

    @GetMapping("/api/products/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Integer id) {
        return productService.findById(id)
                .map(product -> ResponseEntity.ok(ProductMapper.toDTO(product)))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping("/api/products")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody CreateProductRequestDTO createProductRequest) {
        Product product = productService.create(CreateProductRequestMapper.fromDTO(createProductRequest));
        return new ResponseEntity<>(ProductMapper.toDTO(product), HttpStatus.CREATED);
    }

}
