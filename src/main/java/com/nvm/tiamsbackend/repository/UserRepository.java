package com.nvm.tiamsbackend.repository;

import com.nvm.tiamsbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUserEmail(String username);
}
