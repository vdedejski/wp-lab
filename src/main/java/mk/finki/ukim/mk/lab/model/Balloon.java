package mk.finki.ukim.mk.lab.model;

import lombok.Data;
import mk.finki.ukim.mk.lab.model.enumerations.TYPE;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;


@Data
@Entity
public class Balloon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

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
    }

    public Balloon(String name, String description, Manufacturer manufacturer) {
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
    }

    public Balloon(String name, String description, Long id, Manufacturer manufacturer) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.manufacturer = manufacturer;
    }
    
}
