package com.tabakov.talkme.domain.dto.program;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProgramDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("actions_detail")
    private Set<ActionsDetailDTO> actionsDetailDTOS;

    @JsonProperty("categories")
    private Set<CategoryDTO> categories;

    @JsonProperty("gotolink")
    private String gotolink;

    @JsonProperty("products_xml_link")
    private String productsXmlLink;
}
