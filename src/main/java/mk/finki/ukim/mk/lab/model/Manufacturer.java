package mk.finki.ukim.mk.lab.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    @Column(name = "manufacturer_address")
    private String address;

    public Manufacturer() {
    }

}
