package com.tabakov.talkme.controller;

import com.tabakov.talkme.domain.dto.product.ProductDTO;
import com.tabakov.talkme.service.auth.AuthService;
import com.tabakov.talkme.service.product.ProductService;
import com.tabakov.talkme.util.validator.ProductValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/product")
public class ProductController {

    private final ProductService productService;
    private final AuthService authService;

    public ProductController(ProductService productService, AuthService authService) {
        this.productService = productService;
        this.authService = authService;
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

    @PatchMapping("image/new/")
    public ResponseEntity<?> uploadImage(String image, Long productId,
                                         @RequestParam String login, @RequestParam String password) {

        if (authService.authenticate(login, password)) {
            boolean success = productService.saveImage(image, productId);
            return new ResponseEntity<>(" { success: " + success + " }", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
