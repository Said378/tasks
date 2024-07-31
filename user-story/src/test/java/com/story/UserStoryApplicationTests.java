package com.story;

import com.story.entity.Post;
import com.story.entity.Review;
import com.story.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserStoryApplicationTests {


    private final PostService postService;

    UserStoryApplicationTests(PostService postService) {
        this.postService = postService;
    }

    @Test
    public void testAddPost() {
        Post post = new Post("Title", "Body");
        Post createdPost = postService.addPost(post);
        assertNotNull(createdPost);
        assertEquals(post.getTitle(), createdPost.getTitle());
    }

    @Test
    public void testGetUserPosts() {
        Long userId = 1L;
        Page<Post> userPosts = postService.getUserPosts(userId, PageRequest.of(0, 10));
        assertNotNull(userPosts);
    }

    @Test
    public void testGetTopPosts() {
        Page<Post> topPosts = postService.getTopPosts(PageRequest.of(0, 10));
        assertNotNull(topPosts);
    }

    @Test
    public void testAddReviewToPost() {
        Long postId = 1L;
        Review review = new Review("Great post!", 5);
        Review createdReview = postService.addReviewToPost(postId, review);
        assertNotNull(createdReview);
        assertEquals(review.getRating(), createdReview.getRating());
    }

}
