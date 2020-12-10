package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.repository.ManufacturerRepository;
import mk.finki.ukim.mk.lab.repository.OrderRepository;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ManufacturerRepository manufacturerRepository;
//    private final CategoryRepository categoryRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ManufacturerRepository manufacturerRepository) {
        this.orderRepository = orderRepository;
        this.manufacturerRepository = manufacturerRepository;
//        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return this.orderRepository.findById(id);
    }
//
//    @Override
//    public Optional<Order> findByBalloonColor(String balloonColor) {
//        return this.orderRepository.findByBalloonColor(balloonColor);
//    }
//
//    @Override
//    @Transactional
//    public Optional<Product> save(String name, Double price, Integer quantity, Long categoryId, Long manufacturerId) {
//        Category category = this.categoryRepository.findById(categoryId)
//                .orElseThrow(() -> new CategoryNotFoundException(categoryId));
//        Manufacturer manufacturer = this.manufacturerRepository.findById(manufacturerId)
//                .orElseThrow(() -> new ManufacturerNotFoundException(manufacturerId));
//
//        this.productRepository.deleteByName(name);
//        return Optional.of(this.productRepository.save(new Product(name, price, quantity, category, manufacturer)));
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        this.productRepository.deleteById(id);
//    }
}