package ch.bbw.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBService {

    private OrderRepository orderRepository;

    @Autowired
    public DBService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<ProductOrder> getOrders() {
        return (List<ProductOrder>)orderRepository.findAll();
    }

    public ProductOrder getOrder(long id) {
        return orderRepository.findById(id).get();
    }

    public ProductOrder createOrder(ProductOrder order) {
        return orderRepository.save(order);
    }

    public ProductOrder updateOrder(ProductOrder order) {
        if(orderRepository.findById(order.id).isPresent()) {
            return orderRepository.save(order);
        }
        return null;
    }

    public void deleteProduct(long id) {
        orderRepository.deleteById(id);
    }

}
