package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Repository
public class OrderRepository {

    Order order;

    @PostConstruct
    public void init() {
        order = new Order();
        order.setOrderId(UUID.randomUUID().getLeastSignificantBits());
    }

    public Order getOrder() {
        return order;
    }
}
