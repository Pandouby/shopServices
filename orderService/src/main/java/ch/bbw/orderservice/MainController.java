package ch.bbw.orderservice;

import org.aspectj.weaver.ast.Or;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @GetMapping("api/orders")
    public ResponseEntity<List<Order>> getOrders() {
        return null;
    }

    @GetMapping("api/orders/{id}")
    public ResponseEntity<Order> getOrders(@PathVariable int id) {
        return null;
    }

    @PostMapping("api/orders/")
    public ResponseEntity<Order> postOrder() {
        return null;
    }

    @PutMapping("api/orders")
    public ResponseEntity<Order> putOrder() {
        return null;
    }

    @DeleteMapping("api/orders/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable int id) {
        return null;
    }
}
