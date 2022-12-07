package com.tabakov.talkme.repo;

import com.tabakov.talkme.domain.entity.AdminCreds;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminCredsRepository extends CrudRepository<AdminCreds, Long> {

    boolean existsAdminCredsByLoginAndPassword(String login, String password);
}
