package ch.bbw.orderservice;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class ProductOrder {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long id;
    @Column(name = "order_time", columnDefinition = "TIMESTAMP")
    public LocalDateTime orderTime;
    @Column(name = "user_id", columnDefinition = "INT")
    public long user_id;
    @Column(name = "product_id", columnDefinition = "INT")
    public long product_id;
}
