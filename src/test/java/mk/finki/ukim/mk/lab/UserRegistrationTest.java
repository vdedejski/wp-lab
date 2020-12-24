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

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UserRegistrationTest {

    @Mock
    private final ShoppingCartRepository shoppingCartRepository;

    @Mock
    private final UserRepository userRepository;

    @Mock
    private final BalloonRepository balloonRepository;

    private ShoppingCartService service;
    
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        ShoppingCart shoppingCart = new ShoppingCart();
        User user = new User();
        Balloon balloon = new Balloon();

        Mockito.when(this.shoppingCartRepository.save(Mockito.any(ShoppingCart.class))).thenReturn(shoppingCart);
        Mockito.when(this.userRepository.save(Mockito.any(User.class))).thenReturn(user);
        Mockito.when(this.balloonRepository.save(Mockito.any(Balloon.class))).thenReturn(balloon);

        this.service = Mockito.spy(new ShoppingCartServiceImpl(this.shoppingCartRepository, this.userRepository, this.balloonRepository));
    }

    @Test
    public void testFindShoppingCart(){
        ShoppingCart shoppingCart = this.service.findShoppingCart(1L);
        Mockito.verify(this.service).findShoppingCart(1L);

        Assert.assertNotNull("Shopping cart is null", shoppingCart);
    }

    @Test
    public void testFindShoppingCartNotExists(){
        ShoppingCart shoppingCart = this.service.findShoppingCart(0L);

        Assert.assertThrows("ShoppingCartNotFoundException expected",
                ShoppingCartNotFoundException.class,
                () -> this.service.findShoppingCart(0L));

        Mockito.verify(this.service).findShoppingCart(0L);
    }

    @Test
    public void testGetActiveShoppingCart(){
        ShoppingCart shoppingCart = this.service.getActiveShoppingCart("test");

        Assert.assertThrows("UserNotFoundException expected",
                UserNotFoundException.class,
                () -> this.userRepository.findByUsername("test"));
    }

    @Test
    public void testListAllOrdersInShoppingCart(){
        List<Order> shoppingCartList = this.service.listAllOrdersInShoppingCart(0L);
        Assert.assertThrows("ShoppingCartNotFoundException",
                ShoppingCartNotFoundException.class,
                () -> this.service.listAllOrdersInShoppingCart(0L));


    }

    @Test
    public void testAddProductToShoppingCart(){
        ShoppingCart shoppingCart = this.service.getActiveShoppingCart("test");
        Mockito.verify(this.service).getActiveShoppingCart("test");
    }
}
