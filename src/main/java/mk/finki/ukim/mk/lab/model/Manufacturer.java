package mk.finki.ukim.mk.lab.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Manufacturer {
    private Long id;
    private String name;
    private String country;
    private String address;

    public Manufacturer(Long id, String name, String country, String address) {
        this.id = UUID.randomUUID().getLeastSignificantBits();
        this.name = name;
        this.country = country;
        this.address = address;
    }

    public Manufacturer() {
    }

}
