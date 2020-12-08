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

    @OneToMany
    private List<Order> orders;

    public ShoppingCart() {
    }
}
