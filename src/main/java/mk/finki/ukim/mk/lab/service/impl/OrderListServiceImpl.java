package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.repository.OrderListRepository;
import mk.finki.ukim.mk.lab.service.OrderListService;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderListServiceImpl implements OrderListService {

    private final OrderListRepository orderListRepository;

    public OrderListServiceImpl(OrderListRepository orderListRepository){
        this.orderListRepository = orderListRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderListRepository.findAll();
    }
}
