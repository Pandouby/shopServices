package ch.bbw.orderservice;

import org.aspectj.weaver.ast.Or;
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
    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(dbService.getOrders());

    }

    @GetMapping("api/orders/{id}")
    public ResponseEntity<Order> getOrders(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(dbService.getOrder(id));
    }

    @PostMapping("api/orders/")
    public ResponseEntity<Order> postOrder(@RequestBody Order order) {
        kafkaProducer.sendMessage("New order has been created: " + order.toString());
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(dbService.createOrder(order));
    }

    @PutMapping("api/orders")
    public ResponseEntity<Order> putOrder(@RequestBody Order order) {
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
