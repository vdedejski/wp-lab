package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.enumerations.TYPE;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BalloonRepository extends JpaRepository<Balloon, Long> {
    List<Balloon> findAllByName(String name);
    List<Balloon> findAllByNameOrDescriptionOrManufacturer_Name(String text, String text1, String text2);
    List<Balloon> findAllByType(TYPE type);
}
