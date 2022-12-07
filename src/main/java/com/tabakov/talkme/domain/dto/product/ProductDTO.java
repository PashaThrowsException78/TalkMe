package com.tabakov.talkme.domain.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String name;

    private List<String> pictures;

    private Long price;

    @Nullable
    private String model;

    @Nullable
    private String url;
}
