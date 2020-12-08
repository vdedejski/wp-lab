package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.enumerations.TYPE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BalloonRepository extends JpaRepository<Balloon, Long> {
    List<Balloon> findAllByNameOrDescription(String name, String description);
    List<Balloon> findAllByName(String name);
    List<Balloon> findAllByType(TYPE type);
}
