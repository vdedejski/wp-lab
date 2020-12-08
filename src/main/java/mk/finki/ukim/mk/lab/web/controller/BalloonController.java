package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.service.ManufacturerService;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
public class BalloonController {

    private final BalloonService balloonService;
    private final OrderService orderService;
    private final ManufacturerService manufacturerService;

    public BalloonController(BalloonService balloonService, OrderService orderService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.orderService = orderService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("/balloons")
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model, HttpServletRequest request) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Balloon> listBalloons = balloonService.listAll();
        model.addAttribute("userName", request.getHeader("user"));
        model.addAttribute("listBalloons", listBalloons);
        return "listBalloons";
    }

    @PostMapping("/balloons")
    public String getOrder(@RequestParam(value = "balloon") String id, Model model, HttpServletRequest request) {

        Optional<Balloon> balloon = balloonService.findById(Long.valueOf(id));

        balloon.ifPresent(value -> model.addAttribute("color", value.getName()));

        balloon.ifPresent(value -> request.getSession().setAttribute("color", value.getName()));
        balloon.ifPresent(value -> request.getSession().setAttribute("bid", value.getId()));

        balloon.ifPresent(value -> orderService.getCurrentOrderStatus().setBalloonColor(value.getName()));
        balloon.ifPresent(value -> orderService.getCurrentOrderStatus().setBalloonId(value.getId()));

        return "redirect:/SelectBalloonSize";
    }

    @GetMapping("/form")
    public String addProductPage(Model model) {
        model.addAttribute("balloons", balloonService.listAll());
        model.addAttribute("manufacturers", manufacturerService.findAll());
        return "add-balloon";
    }

    @PostMapping("/balloons/add")
    public String saveBalloon(@RequestParam String name,
                              @RequestParam Long balloonId,
                              @RequestParam String description,
                              @RequestParam Long manufacturer){
        this.balloonService.save(name, description, balloonId, manufacturer);
        return "redirect:/balloons";
    }

    @DeleteMapping("/balloons/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.balloonService.deleteById(id);
        return "redirect:/balloons";
    }

    @GetMapping("/balloons/edit-balloon/{id}")
    public String editBalloonPage(@PathVariable Long id, Model model){
        if(this.balloonService.findById(id).isPresent()){
            Balloon balloon = this.balloonService.findById(id).get();
            model.addAttribute("manufacturers", this.manufacturerService.findAll());
            model.addAttribute("balloons", this.balloonService.listAll());
            return "add-balloon";
        }
        return "redirect:/products?error=BalloonNotFound";
    }

    @GetMapping("/search")
    public String getSearchBalloons(@RequestParam String name, Model model) {
        if(!name.isEmpty()){
            model.addAttribute("listBalloons", balloonService.filterByName(name));
            return "listBalloons";
        }
        model.addAttribute("listBalloons", balloonService.listAll());
        return "redirect:/balloons";
    }

    @GetMapping("/searchByType")
    public String getByType(@RequestParam String type, Model model) {
        if(!type.isEmpty()){
            model.addAttribute("listBalloons", balloonService.filterByType(type));
            return "listBalloons";
        }
        model.addAttribute("listBalloons", balloonService.listAll());
        return "redirect:/balloons";
    }

}
