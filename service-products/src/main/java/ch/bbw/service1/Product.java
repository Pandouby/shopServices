package ch.bbw.service1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long id;
    public String name;
    public double price;

    public Product() {

    }
}
