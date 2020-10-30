package mk.finki.ukim.mk.lab.bootstrap;

import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Order> orderList;

    @PostConstruct
    public void init() {
        orderList = new ArrayList<>();
    }

}