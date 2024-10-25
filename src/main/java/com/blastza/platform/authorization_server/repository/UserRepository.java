package com.blastza.platform.authorization_server.repository;

import com.blastza.platform.authorization_server.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> findByVerificationToken(String token);
}
