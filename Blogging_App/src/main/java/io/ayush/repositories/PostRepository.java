package io.ayush.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.ayush.entities.Category;
import io.ayush.entities.Post;
import io.ayush.entities.User;

public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);

}
