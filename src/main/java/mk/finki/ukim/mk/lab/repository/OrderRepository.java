package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.xml.crypto.Data;
import java.util.UUID;

@Repository
public class OrderRepository {

    @PostConstruct
    public void init() {
        DataHolder.order.setOrderId(Math.abs(UUID.randomUUID().getLeastSignificantBits()));
    }

    public Order getOrder() {
        return DataHolder.order;
    }
}
