package com.pradeeppadmakumar.fullstack.eventfeedbackservice.repository;

import com.pradeeppadmakumar.fullstack.eventfeedbackservice.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Long> {

    Optional<ApplicationUser> findByUsername(String username);
}
