package ch.bbw.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private DBService dbService;

    @GetMapping("api/orders")
    public ResponseEntity<List<ProductOrder>> getOrders() {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(dbService.getOrders());

    }

    @GetMapping("api/orders/{id}")
    public ResponseEntity<ProductOrder> getOrders(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(dbService.getOrder(id));
    }

    @PostMapping("api/orders/")
    public ResponseEntity<ProductOrder> postOrder(@RequestBody ProductOrder order) {
        kafkaProducer.sendMessage("New order has been created: " + order.toString());
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(dbService.createOrder(order));
    }

    @PutMapping("api/orders")
    public ResponseEntity<ProductOrder> putOrder(@RequestBody ProductOrder order) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(dbService.updateOrder(order));
    }

    @DeleteMapping("api/orders/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable int id) {
        dbService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body("Deleted Order with id:" + id);
    }
}
