package johannanguyen.redflagbackend.controller;

import johannanguyen.redflagbackend.entity.Product;
import johannanguyen.redflagbackend.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // CREATE
    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    // GET ALL
    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    // SEARCH
    @GetMapping("/search")
    public List<Product> search(@RequestParam String q) {
        return productService.search(q);
    }
}
