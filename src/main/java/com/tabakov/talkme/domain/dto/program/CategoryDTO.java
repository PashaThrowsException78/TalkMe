package com.tabakov.talkme.domain.dto.program;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private Long id;

    private String name;

    private String language;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDTO that = (CategoryDTO) o;
        return name.equals(that.name) && language.equals(that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, language);
    }
}
