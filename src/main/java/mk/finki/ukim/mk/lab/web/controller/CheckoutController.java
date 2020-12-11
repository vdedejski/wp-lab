package mk.finki.ukim.mk.lab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    @PostMapping
    public void checkoutConfirmed(HttpServletRequest request){
        System.out.println(request.getSession().getAttribute("user").toString());
    }
}
