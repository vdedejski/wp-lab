package mk.finki.ukim.mk.lab.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class ShoppingCart {

    @Id
    private Long id;

    @ManyToOne
    private User user;

    private LocalDateTime dateCreated;

    // TODO 6 TABLES ---> refactor or ask!! Sholud this be @OneToMany,
    //  @OneToOne (this makes sense to me if order is refactored), or @ManyToMany
    // Is one order - one shopping cart or several orders one shopping carts ??
    @OneToMany
    private List<Order> orders;

    public ShoppingCart() {
    }
}
