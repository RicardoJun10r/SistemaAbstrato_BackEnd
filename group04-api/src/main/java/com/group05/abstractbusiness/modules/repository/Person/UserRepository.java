package com.group05.abstractbusiness.modules.repository.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group05.abstractbusiness.modules.model.Person.User;

public interface UserRepository  extends JpaRepository<User, UUID>{
    List<User> findByNameContainingIgnoreCase(String name);
    Optional<User> findByLogin(String login);
}
