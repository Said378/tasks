package com.story.service;

import com.story.entity.Post;
import com.story.entity.Review;
import com.story.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{


    private PostRepository postRepository;

    private ReviewService reviewService;

    @Override
    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Page<Post> getUserPosts(Long userId, Pageable pageable) {
        return postRepository.findByUserId(userId, pageable);
    }

    @Override
    public Page<Post> getTopPosts(Pageable pageable) {
        return postRepository.findTopPosts(pageable);
    }

    @Override
    public Review addReviewToPost(Long postId, Review review) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        review.setPost(post);
        return reviewService.addReview(review);
    }
}
