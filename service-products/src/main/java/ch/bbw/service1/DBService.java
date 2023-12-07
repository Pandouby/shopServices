package ch.bbw.service1;

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

    public Product updateProduct(Product joke) {
        if(productRepository.findById(joke.id).isPresent()) {
            return productRepository.save(joke);
        }
        return null;
    }

    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
}
