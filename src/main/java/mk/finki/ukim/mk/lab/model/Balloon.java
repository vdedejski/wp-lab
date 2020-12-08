package mk.finki.ukim.mk.lab.model;

import lombok.Data;
import mk.finki.ukim.mk.lab.model.enumerations.TYPE;

import java.util.UUID;


@Data
public class Balloon {

    private String name;
    private String description;
    private Long id;
    private Manufacturer manufacturer;
    private TYPE type = null;

    public Balloon(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = Math.abs(UUID.randomUUID().getLeastSignificantBits());
    }

    public Balloon(String name, String description, TYPE type) {
        this.name = name;
        this.description = description;
        this.type = type;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }
}
