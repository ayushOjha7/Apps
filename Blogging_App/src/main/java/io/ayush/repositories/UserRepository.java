package io.ayush.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.ayush.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
