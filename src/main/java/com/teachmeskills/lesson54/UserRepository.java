package com.teachmeskills.lesson54;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByLogin(String login);
}
