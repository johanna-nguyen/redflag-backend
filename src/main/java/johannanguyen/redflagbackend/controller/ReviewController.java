package johannanguyen.redflagbackend.controller;

import johannanguyen.redflagbackend.entity.Review;
import johannanguyen.redflagbackend.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/{productId}/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // CREATE
    @PostMapping
    public Review create(@PathVariable Long productId,
                         @RequestBody Review review) {
        return reviewService.create(productId, review);
    }

    // GET
    @GetMapping
    public List<Review> getByProduct(@PathVariable Long productId) {
        return reviewService.getByProduct(productId);
    }

    // SEARCH COMMENT
    @GetMapping("/search")
    public List<Review> search(@RequestParam String q) {
        return reviewService.search(q);
    }
}
