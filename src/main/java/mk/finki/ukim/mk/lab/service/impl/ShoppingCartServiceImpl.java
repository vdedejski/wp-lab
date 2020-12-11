package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.model.ShoppingCart;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.model.enumerations.ShoppingCartStatus;
import mk.finki.ukim.mk.lab.model.exceptions.ShoppingCartNotFoundException;
import mk.finki.ukim.mk.lab.model.exceptions.UserNotFoundException;
import mk.finki.ukim.mk.lab.repository.BalloonRepository;
import mk.finki.ukim.mk.lab.repository.ShoppingCartRepository;
import mk.finki.ukim.mk.lab.repository.UserRepository;
import mk.finki.ukim.mk.lab.service.OrderService;
import mk.finki.ukim.mk.lab.service.ShoppingCartService;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final OrderService orderService;
    private final BalloonRepository balloonRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                   UserRepository userRepository,
                                   OrderService orderService,
                                   BalloonRepository balloonRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.orderService = orderService;
        this.balloonRepository = balloonRepository;
    }

    @Override
    public List<Order> listAllOrdersInShoppingCart(Long cartId) {
        if (this.shoppingCartRepository.findById(cartId).isEmpty())
            throw new ShoppingCartNotFoundException(cartId);
        return this.shoppingCartRepository.findById(cartId).get().getOrders();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
        User user = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        return this.shoppingCartRepository
                .findByUserAndStatus(user, ShoppingCartStatus.CREATED)
                .orElseGet(() -> {
                    ShoppingCart cart = new ShoppingCart(user);
                    return this.shoppingCartRepository.save(cart);
                });
    }

    // TODO REFACTOR!!
    @Override
    @Transactional
    public ShoppingCart addProductToShoppingCart(String username, Long balloonId, String ballonSize, Long userId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);

        Order order = new Order(this.balloonRepository.findById(balloonId).get().getName(),
                ballonSize, this.userRepository.findById(userId).get());

//        shoppingCart.getOrders()
//                .forEach(x -> {
//                    if (x.getBalloonColor().equals(this.balloonRepository.findById(balloonId).get().getName())
//                            && x.getBalloonSize().equals(ballonSize))
//                        throw new OrderAlreadyInShoppingCartException();
//                });

        shoppingCart.getOrders().add(order);
        return this.shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart findShoppingCart(Long id) {
        if (this.shoppingCartRepository.findById(id).isPresent()){
            return this.shoppingCartRepository.findById(id).get();
        }else {
            throw new ShoppingCartNotFoundException(id);
        }
    }
}
