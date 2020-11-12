package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Balloon;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);
    Optional<Balloon> findById(Long id);
    Optional<Balloon> save(String name, String description, Long balloonId, Long id);
    void deleteById(Long id);
    List<Balloon> filterByName(String name);

}

