package mk.finki.ukim.mk.lab.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shop_orders")
public class Order {
    // TODO Why does this not allow name Order, with name change the problem said in the email was fixed

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String balloonColor;
    private String balloonSize;

    @ManyToOne
    private User user;

    public Order() {
    }
}
