package ch.bbw.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBService {

    private OrderRepository orderRepository;

    @Autowired
    public DBService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders() {
        return (List<Order>)orderRepository.findAll();
    }

    public Order getOrder(long id) {
        return orderRepository.findById(id).get();
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Order order) {
        if(orderRepository.findById(order.id).isPresent()) {
            return orderRepository.save(order);
        }
        return null;
    }

    public void deleteProduct(long id) {
        orderRepository.deleteById(id);
    }
}
