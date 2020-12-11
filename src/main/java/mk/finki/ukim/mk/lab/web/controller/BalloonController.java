package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.service.ManufacturerService;
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
    private final ManufacturerService manufacturerService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("/balloons")
    public String getBalloonsPage(@RequestParam(required = false) String error, Model model, HttpServletRequest request) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Balloon> listBalloons = balloonService.findAll();
        model.addAttribute("userName", request.getSession().getAttribute("username"));
        model.addAttribute("listBalloons", listBalloons);
        return "listBalloons";
    }

    @PostMapping("/balloons")
    public String getOrder(@RequestParam(value = "balloon") String id, Model model, HttpServletRequest request) {

        Optional<Balloon> balloon = balloonService.findById(Long.valueOf(id));

        balloon.ifPresent(value -> model.addAttribute("color", value.getName()));

        balloon.ifPresent(value -> request.getSession().setAttribute("color", value.getName()));
        balloon.ifPresent(value -> request.getSession().setAttribute("bid", value.getId()));

        return "redirect:/SelectBalloonSize";
    }

    @GetMapping("/form")
    public String addProductPage(Model model) {
        model.addAttribute("balloons", balloonService.findAll());
        model.addAttribute("manufacturers", manufacturerService.findAll());
        return "add-balloon";
    }

    @PostMapping("/balloons/add")
    public String saveBalloon(@RequestParam String name,
                              @RequestParam String description,
                              @RequestParam Long manufacturer) {
        this.balloonService.save(name, description, manufacturer);
        return "redirect:/balloons";
    }

    @DeleteMapping("/balloons/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.balloonService.deleteById(id);
        return "redirect:/balloons";
    }

    @GetMapping("/balloons/edit-balloon/{id}")
    public String editBalloonPage(@PathVariable Long id, Model model) {
        if (this.balloonService.findById(id).isPresent()) {
            Optional<Balloon> balloon = this.balloonService.findById(id);
            model.addAttribute("manufacturers", this.manufacturerService.findAll());
            model.addAttribute("balloons", this.balloonService.findAll());
            model.addAttribute("balloon", balloon.get());
            return "add-balloon";
        }
        return "redirect:/products?error=BalloonNotFound";
    }

    @GetMapping("/search")
    public String getSearchBalloons(@RequestParam String name, Model model, HttpServletRequest request) {
        model.addAttribute("userName", request.getSession().getAttribute("username"));
        if (!name.isEmpty()) {
            model.addAttribute("listBalloons", balloonService.findAllByNameOrDescriptionOrTypeOrManufacturer(name));
            return "listBalloons";
        }
        model.addAttribute("listBalloons", balloonService.findAll());
        return "redirect:/balloons";
    }

    @GetMapping("/searchByType")
    public String getByType(@RequestParam String type, Model model) {
        if (!type.isEmpty()) {
            model.addAttribute("listBalloons", balloonService.findAllByType(type));
            return "listBalloons";
        }
        model.addAttribute("listBalloons", balloonService.findAll());
        return "redirect:/balloons";
    }

}
