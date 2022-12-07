package com.tabakov.talkme.controller;

import com.tabakov.talkme.domain.dto.product.ProductDTO;
import com.tabakov.talkme.service.product.ProductService;
import com.tabakov.talkme.util.validator.ProductValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> uploadProduct(@RequestBody ProductDTO productDTO) {

        if (ProductValidator.isValid(productDTO)) {
            productService.save(productDTO);
            return new ResponseEntity<>(productDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
