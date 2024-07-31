package com.story.service;

import com.story.entity.Post;
import com.story.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {

     Post addPost(Post post) ;

     Page<Post> getUserPosts(Long userId, Pageable pageable) ;


     Page<Post> getTopPosts(Pageable pageable) ;

     Review addReviewToPost(Long postId, Review review) ;
}
