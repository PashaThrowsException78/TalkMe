package com.tabakov.talkme.util.converter;

import com.tabakov.talkme.domain.dto.product.ProductDTO;
import com.tabakov.talkme.domain.entity.Product;

public class ProductConverter {

    public static Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setModel(productDTO.getModel());
        product.setPictures(productDTO.getPictures());
        product.setUrl(productDTO.getUrl());
        product.setPrice(productDTO.getPrice());

        return product;
    }
}
