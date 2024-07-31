package com.story.controller;

import com.story.entity.Post;
import com.story.entity.Review;
import com.story.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<Page<Post>> listUserPosts(
            @PathVariable Long userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Post> userPosts = postService.getUserPosts(userId, PageRequest.of(page, size));
        return new ResponseEntity<>(userPosts, HttpStatus.OK);
    }

    @GetMapping("/top")
    public ResponseEntity<Page<Post>> listTopPosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Post> topPosts = postService.getTopPosts(PageRequest.of(page, size));
        return new ResponseEntity<>(topPosts, HttpStatus.OK);
    }

    @PostMapping("/{postId}/reviews")
    public ResponseEntity<Review> addReviewToPost(
            @PathVariable Long postId,
            @RequestBody Review review) {
        Review createdReview = postService.addReviewToPost(postId, review);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }
}
