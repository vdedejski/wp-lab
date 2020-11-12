package mk.finki.ukim.mk.lab.bootstrap;

import lombok.Getter;
import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Getter
public class DataHolder {
    public static List<Order> orderList = new ArrayList<>();
    public static List<Balloon> balloonList = new ArrayList<>();
    public static List<Manufacturer> manufacturerList = new ArrayList<>();
    public static Order order = new Order();

    @PostConstruct
    public void init() {
        orderList = new ArrayList<>();

        balloonList.add(new Balloon("Red", "Red balloon"));
        balloonList.add(new Balloon("Blue", "Blue balloon"));
        balloonList.add(new Balloon("Orange", "Orange balloon"));
        balloonList.add(new Balloon("Grey", "Grey balloon"));
        balloonList.add(new Balloon("Black", "Black balloon"));
        balloonList.add(new Balloon("Purple", "Purple balloon"));
        balloonList.add(new Balloon("Indigo", "Indigo balloon"));
        balloonList.add(new Balloon("Yellow", "Yellow balloon"));
        balloonList.add(new Balloon("Green", "Green balloon"));
        balloonList.add(new Balloon("White", "White balloon"));

        manufacturerList.add(new Manufacturer(Math.abs(UUID.randomUUID().getLeastSignificantBits()),
                "FirstManufacturer", "Macedonia", "ul. Ruger Boksovikj 16"));

        manufacturerList.add(new Manufacturer(Math.abs(UUID.randomUUID().getLeastSignificantBits()),
                "SecondManufacturer", "Serbia", "ul. Knez Mihajlova"));

        manufacturerList.add(new Manufacturer(Math.abs(UUID.randomUUID().getLeastSignificantBits()),
                "ThirdManufacturer", "UK", "st. Picadilly"));

        manufacturerList.add(new Manufacturer(Math.abs(UUID.randomUUID().getLeastSignificantBits()),
                "FourthManufacturer", "Netherlands", "Red District"));

        manufacturerList.add(new Manufacturer(Math.abs(UUID.randomUUID().getLeastSignificantBits()),
                "FifthManufacturer", "USA", "1600 Pennsylvania Avenue"));
    }


}
