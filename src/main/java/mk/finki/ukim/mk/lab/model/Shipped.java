package mk.finki.ukim.mk.lab.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Shipped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    private User user;

    private LocalDateTime dateCreated;

    @OneToOne
    private ShoppingCart shoppingCart;

    public Shipped() {
    }
}
