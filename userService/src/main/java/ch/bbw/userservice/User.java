package ch.bbw.userservice;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "firstname", columnDefinition = "string")
    private String firstname;
    @Column(name = "lastname", columnDefinition = "string")
    private String lastname;
    @Column(name = "birthdate", columnDefinition = "date")
    private Date birthdate;
}
