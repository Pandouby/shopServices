package ch.bbw.productService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBService {
    private ProductRepository productRepository;

    @Autowired
    public DBService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return (List<Product>)productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProduct(long id) {
        return productRepository.findById(id).get();
    }

    public Product updateProduct(Product product) {
        if(productRepository.findById(product.id).isPresent()) {
            return productRepository.save(product);
        }
        return null;
    }

    public void deleteProduct(long id) {
        if(productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
        }
    }
}
