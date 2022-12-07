package com.tabakov.talkme.domain.dto.program;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActionsDetailDTO {

    private Long id;

  //  private List<Tariff> tariffs;

    private String name;

    private ActionType type;
}
