package com.tabakov.talkme.service.product;

import com.tabakov.talkme.domain.dto.product.ProductDTO;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    void save(ProductDTO productDTO);

    boolean saveImage(String img, Long productId);
}
