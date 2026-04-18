package johannanguyen.redflagbackend.service;

import johannanguyen.redflagbackend.entity.Review;
import johannanguyen.redflagbackend.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    // CREATE
    public Review create(Long productId, Review review) {
        review.setProductId(productId);
        review.setCreatedAt(LocalDate.now());
        return reviewRepository.save(review);
    }

    // GET BY PRODUCT
    public List<Review> getByProduct(Long productId) {
        return reviewRepository.findByProductId(productId);
    }

    // SEARCH COMMENT
    public List<Review> search(String keyword) {
        return reviewRepository.findByCommentContainingIgnoreCase(keyword);
    }
}
