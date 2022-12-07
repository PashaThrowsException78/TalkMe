package com.tabakov.talkme.util.converter;

import com.tabakov.talkme.domain.dto.program.ActionsDetailDTO;
import com.tabakov.talkme.domain.entity.ActionsDetail;

public class ActionsDetailConverter {

    public static ActionsDetail toEntity(ActionsDetailDTO actionsDetailDTO) {
        ActionsDetail actionsDetail = new ActionsDetail();
        actionsDetail.setName(actionsDetailDTO.getName());
        actionsDetail.setType(actionsDetailDTO.getType());

        return actionsDetail;
    }
}
