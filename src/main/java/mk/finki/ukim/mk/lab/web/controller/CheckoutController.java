package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Shipped;
import mk.finki.ukim.mk.lab.model.ShoppingCart;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.model.enumerations.ShoppingCartStatus;
import mk.finki.ukim.mk.lab.service.AuthService;
import mk.finki.ukim.mk.lab.service.ShippedService;
import mk.finki.ukim.mk.lab.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    private final AuthService authService;
    private final ShoppingCartService shoppingCartService;
    private final ShippedService shippedService;

    public CheckoutController(AuthService authService,
                              ShoppingCartService shoppingCartService,
                              ShippedService shippedService) {
        this.authService = authService;
        this.shoppingCartService = shoppingCartService;
        this.shippedService = shippedService;
    }

    @PostMapping
    public String checkoutConfirmed(HttpServletRequest request, Model model){
        User user = this.authService.getUser(request.getSession().getAttribute("username").toString());
        ShoppingCart shoppingCart = this.shoppingCartService.findShoppingCart(Long.valueOf(request.getSession().getAttribute("cart").toString()));

        model.addAttribute("name", user.getUsername());
        model.addAttribute("address", user.getAddress());
        model.addAttribute("orders", shoppingCart.getOrders());
        model.addAttribute("date", shoppingCart.getDateCreated());

        this.shoppingCartService.findShoppingCart(Long.valueOf(request.getSession().getAttribute("cart").toString())).setStatus(ShoppingCartStatus.FINISHED);
        this.shippedService.save(new Shipped(user, shoppingCart, false));

        return "checkout";
    }
}
