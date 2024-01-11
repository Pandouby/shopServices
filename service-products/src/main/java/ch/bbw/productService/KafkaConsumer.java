package ch.bbw.productService;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics="newOrder", groupId="shopService")
    public void listen(String message) {
        System.out.println("Received message in group shopService: " + message.toString());
    }
}