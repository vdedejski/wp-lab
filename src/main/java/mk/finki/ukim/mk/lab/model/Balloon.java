package mk.finki.ukim.mk.lab.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Balloon {

    private String name;
    private String description;
    private Long id;
    private Manufacturer manufacturer;

    public Balloon(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = Math.abs(UUID.randomUUID().getLeastSignificantBits());
    }

    public Balloon(String name, String description, Manufacturer manufacturer) {
        this.name = name;
        this.description = description;
        this.id = Math.abs(UUID.randomUUID().getLeastSignificantBits());
        this.manufacturer = manufacturer;
    }

    public Balloon(String name, String description, Long id, Manufacturer manufacturer) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.manufacturer = manufacturer;
    }
}
