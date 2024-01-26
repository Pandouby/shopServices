package ch.bbw.productService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class MainController {

    @Autowired
    private DBService dbService;

    @GetMapping("/product/products")
    public ResponseEntity<List<Product>> getJokes() {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(dbService.getProducts());
    }

    @GetMapping("/product/products/{id}")
    public ResponseEntity<Product> getJokes(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(dbService.getProduct(id));
    }

    @PostMapping("/product/products")
    public ResponseEntity<Product> createJoke(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(dbService.createProduct(product));
    }

    @PutMapping("/product/products")
    public ResponseEntity<Product> updateJoke(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(dbService.updateProduct(product));
    }

    @DeleteMapping("/product/products/{id}")
    public ResponseEntity<String> updateJoke(@PathVariable int id) {
        dbService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON).body("Deleted Product with id:" + id);
    }
}