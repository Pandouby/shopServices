package ch.bbw.productService;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long id;
    @Column(name="name", columnDefinition = "string")
    public String name;
    @Column(name = "description", columnDefinition = "string")
    public String description;
    @Column(name = "price", columnDefinition = "float")
    public double price;
}
