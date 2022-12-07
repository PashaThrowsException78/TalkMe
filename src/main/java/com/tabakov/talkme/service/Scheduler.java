package com.tabakov.talkme.service;

import com.tabakov.talkme.controller.ProductController;
import com.tabakov.talkme.domain.dto.product.ProductDTO;
import com.tabakov.talkme.service.program.ProgramServiceImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Scheduler {

    private final ProgramServiceImpl programService;
    private final ProductController productController;

    public Scheduler(ProgramServiceImpl programService, ProductController productController) {
        this.programService = programService;
        this.productController = productController;
    }

    @Scheduled(fixedDelay = 5000)
    private void requestPrograms() {
        programService.requestPrograms();
    }

    @Scheduled(fixedDelay = 15000)
    private void sendRandomProduct() {
        ProductDTO randomProduct = new ProductDTO(
                Double.toString(Math.random()),
                List.of(Double.toString(Math.random()), Double.toString(Math.random())),
                999999L,
                Double.toString(Math.random()),
                Double.toString(Math.random())
                );
        productController.uploadProduct(randomProduct);
    }

}
