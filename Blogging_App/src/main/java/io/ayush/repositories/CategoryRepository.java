package io.ayush.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.ayush.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
