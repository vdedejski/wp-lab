package mk.finki.ukim.mk.lab.service;


import mk.finki.ukim.mk.lab.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> findAll();
    Optional<Order> findById(Long id);
//    Optional<Order> findByBalloonColor(String name);
//    Optional<Order> save(String name, Double price, Integer quantity, Long category, Long manufacturer);
//    void deleteById(Long id);

}
