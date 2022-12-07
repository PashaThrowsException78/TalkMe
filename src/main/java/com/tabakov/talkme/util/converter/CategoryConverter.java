package com.tabakov.talkme.util.converter;

import com.tabakov.talkme.domain.dto.program.CategoryDTO;
import com.tabakov.talkme.domain.entity.Category;

public class CategoryConverter {

    public static Category toEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setLanguage(categoryDTO.getLanguage());
        category.setName(categoryDTO.getName());

        return category;
    }
}
