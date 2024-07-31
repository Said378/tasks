package com.story.repository;

import com.story.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByUserId(Long userId, Pageable pageable);

    @Query("SELECT p FROM Post p LEFT JOIN p.reviews r GROUP BY p.id ORDER BY AVG(r.rating) DESC")
    Page<Post> findTopPosts(Pageable pageable);
}