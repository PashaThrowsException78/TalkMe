package com.tabakov.talkme.util.converter;

import com.tabakov.talkme.domain.dto.program.ActionsDetailDTO;
import com.tabakov.talkme.domain.dto.program.CategoryDTO;
import com.tabakov.talkme.domain.dto.program.ProgramDTO;
import com.tabakov.talkme.domain.entity.ActionsDetail;
import com.tabakov.talkme.domain.entity.Category;
import com.tabakov.talkme.domain.entity.Program;

import java.util.HashSet;
import java.util.Set;

public class ProgramConverter {

    public static Program toEntity(ProgramDTO programDTO) {
        Program program = new Program();
        program.setName(programDTO.getName());
        program.setGotolink(programDTO.getGotolink());
        if (programDTO.getProductsXmlLink() != null)
            program.setProductsXmlLink(programDTO.getProductsXmlLink());

        Set<Category> categories = new HashSet<>();
        Set<ActionsDetail> actionsDetails = new HashSet<>();

        for (CategoryDTO categoryDTO : programDTO.getCategories()) {
            // if (CategoryValidator.isValid(categoryDTO))
            categories.add(CategoryConverter.toEntity(categoryDTO));
        }

        for (ActionsDetailDTO actionsDetailDTO : programDTO.getActionsDetailDTOS()) {
            // if (ActionsDetailValidator.isValid(actionsDetailDTO))
            var actionsDetail = ActionsDetailConverter.toEntity(actionsDetailDTO);
            actionsDetail.setProgram(program);
            actionsDetails.add(actionsDetail);
        }

        program.setCategories(categories);
        program.setActionsDetail(actionsDetails);

        return program;
    }
}
