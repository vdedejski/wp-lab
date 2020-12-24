package mk.finki.ukim.mk.lab;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.model.ShoppingCart;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.model.exceptions.ShoppingCartNotFoundException;
import mk.finki.ukim.mk.lab.model.exceptions.UserNotFoundException;
import mk.finki.ukim.mk.lab.repository.BalloonRepository;
import mk.finki.ukim.mk.lab.repository.ShoppingCartRepository;
import mk.finki.ukim.mk.lab.repository.UserRepository;
import mk.finki.ukim.mk.lab.service.ShoppingCartService;
import mk.finki.ukim.mk.lab.service.impl.ShoppingCartServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartServiceTest {

    @Mock
    private ShoppingCartRepository shoppingCartRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BalloonRepository balloonRepository;

    private ShoppingCartService service;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        ShoppingCart shoppingCart = new ShoppingCart();
        User user = new User();
        Balloon balloon = new Balloon();

        this.service = Mockito.spy(new ShoppingCartServiceImpl(this.shoppingCartRepository, this.userRepository, this.balloonRepository));
    }

    @Test
    public void testFindShoppingCart() {
        Assert.assertThrows("ShoppingCartNotFoundException",
                ShoppingCartNotFoundException.class,
                () -> this.service.findShoppingCart(1L));
    }

    @Test
    public void testFindShoppingCartNotExists() {
        Assert.assertThrows("ShoppingCartNotFoundException expected",
                ShoppingCartNotFoundException.class,
                () -> this.service.findShoppingCart(0L));

        Mockito.verify(this.service).findShoppingCart(0L);
    }

    @Test
    public void testGetActiveShoppingCart() {
        Assert.assertEquals(Optional.empty(), this.userRepository.findByUsername("test"));
    }

    @Test
    public void testListAllOrdersInShoppingCart() {
        Assert.assertThrows("ShoppingCartNotFoundException",
                ShoppingCartNotFoundException.class,
                () -> this.service.listAllOrdersInShoppingCart(1L));

    }
}
