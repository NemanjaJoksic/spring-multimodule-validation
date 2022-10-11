package org.joksin.multimodule.validation.core.service;

import lombok.extern.slf4j.Slf4j;
import org.joksin.multimodule.validation.core.model.request.CreateProductRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

@Slf4j
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void testProductNameMustNotBeNullOrBlank() {
        ConstraintViolationException exception = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            CreateProductRequest createProductRequest = CreateProductRequest.builder()
                    .name(null)
                    .build();
            productService.create(createProductRequest);
        });

        log.info("exception: {}", exception.getMessage());
        Assertions.assertTrue(exception.getMessage().contains("create.createProductRequest.name: must not be null"));

        exception = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            CreateProductRequest createProductRequest = CreateProductRequest.builder()
                    .name("")
                    .build();
            productService.create(createProductRequest);
        });

        log.info("exception: {}", exception.getMessage());
        Assertions.assertTrue(exception.getMessage().contains("create.createProductRequest.name: must not be blank"));
    }


    @Test
    public void testProductPriceMustNotBeNullZeroOrNegative() {
        ConstraintViolationException exception = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            CreateProductRequest createProductRequest = CreateProductRequest.builder()
                    .name("TEST PRODUCT")
                    .price(null)
                    .build();
            productService.create(createProductRequest);
        });

        log.info("exception: {}", exception.getMessage());
        Assertions.assertTrue(exception.getMessage().contains("create.createProductRequest.price: must not be null"));

        exception = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            CreateProductRequest createProductRequest = CreateProductRequest.builder()
                    .name("TEST PRODUCT")
                    .price(0.0)
                    .build();
            productService.create(createProductRequest);
        });

        log.info("exception: {}", exception.getMessage());
        Assertions.assertTrue(exception.getMessage().contains("create.createProductRequest.price: must be greater than 0"));

        exception = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            CreateProductRequest createProductRequest = CreateProductRequest.builder()
                    .name("TEST PRODUCT")
                    .price(-100.0)
                    .build();
            productService.create(createProductRequest);
        });

        log.info("exception: {}", exception.getMessage());
        Assertions.assertTrue(exception.getMessage().contains("create.createProductRequest.price: must be greater than 0"));
    }

    @Test
    public void testProductManufacturerMustExist() {
        ConstraintViolationException exception = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            CreateProductRequest createProductRequest = CreateProductRequest.builder()
                    .name("TEST PRODUCT")
                    .price(100.0)
                    .manufacturerId(null)
                    .build();
            productService.create(createProductRequest);
        });

        log.info("exception: {}", exception.getMessage());
        Assertions.assertTrue(exception.getMessage().contains("create.createProductRequest.manufacturerId: must not be null"));

        exception = Assertions.assertThrows(ConstraintViolationException.class, () -> {
            CreateProductRequest createProductRequest = CreateProductRequest.builder()
                    .name("TEST PRODUCT")
                    .price(100.0)
                    .manufacturerId(200)
                    .build();
            productService.create(createProductRequest);
        });

        log.info("exception: {}", exception.getMessage());
        Assertions.assertTrue(exception.getMessage().contains("create.createProductRequest.manufacturerId: Manufacturer with id 200 does not exist"));
    }

}
