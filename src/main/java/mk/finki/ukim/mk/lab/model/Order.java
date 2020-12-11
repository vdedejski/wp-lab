package mk.finki.ukim.mk.lab.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Optional;

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

    public Order(String balloonColor, String balloonSize, User user) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.user = user;
    }

    public Order() {

    }
}
