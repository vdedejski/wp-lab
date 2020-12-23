package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.ShoppingCart;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    private final BalloonService balloonService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  BalloonService balloonService) {
        this.shoppingCartService = shoppingCartService;
        this.balloonService = balloonService;
    }

    @GetMapping
    public String getShoppingCartPage(@RequestParam(required = false) String error,
                                      HttpServletRequest req,
                                      Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        String username = req.getRemoteUser();
        ShoppingCart shoppingCart = this.shoppingCartService.getActiveShoppingCart(username);
        model.addAttribute("orders", this.shoppingCartService.listAllOrdersInShoppingCart(shoppingCart.getId()));
        model.addAttribute("bodyContent", "shopping-cart");
        return "master-template";
    }

    @PostMapping("/add-product/{id}")
    public String addProductToShoppingCart(@RequestParam(value = "balloon") Long balloonId,
                                           @RequestParam(value = "size") String size,
                                           HttpServletRequest req, @PathVariable String id,
                                           Model model) {
        req.getSession().setAttribute("color", this.balloonService.findById(balloonId).get().getName());
        try {
            String username = req.getRemoteUser();
            ShoppingCart shoppingCart = this.shoppingCartService.addProductToShoppingCart(username, balloonId, size);
            req.getSession().setAttribute("cart", shoppingCart.getId());
//            model.addAttribute("bodyContent", "shopping-cart");
            return "redirect:/shopping-cart";
        } catch (RuntimeException exception) {
            return "redirect:/shopping-cart?error=" + exception.getMessage();
        }
    }

}
