package ch.bbw.orderservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long id;
    public Date order_time;
    public long user_id;
    public long product_id;

    public Order() {

    }
}
