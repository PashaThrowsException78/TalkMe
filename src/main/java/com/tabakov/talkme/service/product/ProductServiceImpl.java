package com.tabakov.talkme.service.product;

import com.tabakov.talkme.domain.dto.product.ProductDTO;
import com.tabakov.talkme.repo.ProductRepository;
import com.tabakov.talkme.util.converter.ProductConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public void save(ProductDTO productDTO) {
        productRepository.save(ProductConverter.toEntity(productDTO));
    }
}
