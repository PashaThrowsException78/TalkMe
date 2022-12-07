package com.tabakov.talkme.repo;

import com.tabakov.talkme.domain.entity.Program;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends CrudRepository<Program, Long> {
}
