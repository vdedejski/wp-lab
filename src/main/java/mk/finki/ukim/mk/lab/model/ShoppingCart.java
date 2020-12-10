package mk.finki.ukim.mk.lab.model;

import lombok.Data;
import mk.finki.ukim.mk.lab.model.enumerations.ShoppingCartStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private LocalDateTime dateCreated;

    @Enumerated(EnumType.STRING)
    private ShoppingCartStatus status;

    // TODO 6 TABLES ---> refactor or ask!! Sholud this be @OneToMany,
    //  @OneToOne (this makes sense to me if order is refactored), or @ManyToMany
    // Is one order - one shopping cart or several orders one shopping carts ??
    @ManyToMany
    private List<Order> orders;

    public ShoppingCart() {
    }

    public ShoppingCart(User user) {
        this.dateCreated = LocalDateTime.now();
        this.user = user;
        this.orders = new ArrayList<>();
        this.status = ShoppingCartStatus.CREATED;
    }
}
