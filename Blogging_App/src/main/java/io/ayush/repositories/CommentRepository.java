package io.ayush.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.ayush.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	@Modifying
	@Query("delete from Comment c where c.id=:commentId")
	void deleteComment(@Param("commentId") Integer commentId);

}
