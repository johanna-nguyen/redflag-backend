package johannanguyen.redflagbackend.service;

import johannanguyen.redflagbackend.entity.Product;
import johannanguyen.redflagbackend.entity.ProductCategory;
import johannanguyen.redflagbackend.entity.Review;
import johannanguyen.redflagbackend.repository.ProductRepository;
import johannanguyen.redflagbackend.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;

    public ProductService(ProductRepository productRepository,
                          ReviewRepository reviewRepository) {
        this.productRepository = productRepository;
        this.reviewRepository = reviewRepository;
    }

    // CREATE
    public Product create(Product product) {
        return productRepository.save(product);
    }

    // GET ALL
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    // GET BY ID
    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    // SEARCH (4 kiểu)
    public List<Product> search(String query) {

        List<Product> byName = productRepository.findByNameContainingIgnoreCase(query);

        List<Product> byBrand = productRepository.findByBrandContainingIgnoreCase(query);

        List<Product> byCategory = new ArrayList<>();
        try {
            ProductCategory category = ProductCategory.valueOf(query.toUpperCase());
            byCategory = productRepository.findByCategory(category);
        } catch (Exception ignored) {}

        // search từ review comment → lấy productId
        List<Long> productIdsFromReview =
                reviewRepository.findByCommentContainingIgnoreCase(query)
                        .stream()
                        .map(Review::getProductId)
                        .distinct()
                        .toList();

        List<Product> byReview = productRepository.findAllById(productIdsFromReview);

        // merge kết quả
        Set<Product> result = new LinkedHashSet<>();
        result.addAll(byName);
        result.addAll(byBrand);
        result.addAll(byCategory);
        result.addAll(byReview);

        return new ArrayList<>(result);
    }
}
