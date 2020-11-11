package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderListRepository {
    public List<Order> findAll(){
        return DataHolder.orderList;
    }
}
