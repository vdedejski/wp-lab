package mk.finki.ukim.mk.lab.model;

import lombok.Data;
import mk.finki.ukim.mk.lab.model.enumerations.TYPE;

import javax.persistence.*;

@Data
@Entity
public class Balloon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    private Manufacturer manufacturer;

    @Enumerated(EnumType.STRING)
    private TYPE type = null;

    public Balloon(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Balloon(String name, String description, TYPE type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public Balloon(String name, String description, Long id, Manufacturer manufacturer) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.manufacturer = manufacturer;
    }

    public Balloon(String name, String description, Manufacturer manufacturer) {
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
    }

    public Balloon() {
    }
}
