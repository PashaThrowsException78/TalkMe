package com.tabakov.talkme.service.program;

import com.tabakov.talkme.client.ProgramFeignClient;
import com.tabakov.talkme.domain.dto.program.ProgramDTO;
import com.tabakov.talkme.domain.entity.Program;
import com.tabakov.talkme.repo.ProgramRepository;
import com.tabakov.talkme.util.converter.ProgramConverter;
import com.tabakov.talkme.util.validator.ProgramValidator;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProgramServiceImpl implements ProgramService {

    public ProgramServiceImpl(ProgramFeignClient programFeignClient, ProgramRepository programRepository) {
        this.programFeignClient = programFeignClient;
        this.programRepository = programRepository;
    }


    private final ProgramFeignClient programFeignClient;

    private final ProgramRepository programRepository;


    @Transactional(noRollbackFor = {DataIntegrityViolationException.class, ConstraintViolationException.class})
    public void requestPrograms() {
        List<ProgramDTO> programDTOs = programFeignClient.getPrograms(2090016).getResults();
        log.info(String.valueOf(programDTOs));
        List<Program> programs = new ArrayList<>();
        for (ProgramDTO programDTO : programDTOs) {
            if (ProgramValidator.isValid(programDTO)) {
                programs.add(ProgramConverter.toEntity(programDTO));
            }
        }

        if (programs.isEmpty())
            return;

        programRepository.saveAll(programs);
    }


}
