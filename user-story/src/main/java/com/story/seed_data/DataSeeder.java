package com.story.seed_data;

import com.story.entity.Post;
import com.story.entity.Review;
import com.story.repository.PostRepository;
import com.story.repository.ReviewRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @PostConstruct
    public void seedDatabase() {
        for (int i = 0; i < 50000; i++) {
            Post post = new Post("Title " + i, "Body " + i);
            postRepository.save(post);
        }

        for (int i = 0; i < 20000; i++) {
            Review review = new Review("Comment " + i, i % 5 + 1);
            reviewRepository.save(review);
        }
    }
}
