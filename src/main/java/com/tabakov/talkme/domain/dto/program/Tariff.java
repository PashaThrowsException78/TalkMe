package com.tabakov.talkme.domain.dto.program;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tariff {

    private Long actionId;

    private Long id;

    private String name;

    private List<Rate> rates;
}
