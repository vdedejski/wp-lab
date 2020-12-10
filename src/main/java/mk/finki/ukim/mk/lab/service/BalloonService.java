package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Balloon;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BalloonService {
    List<Balloon> findAll();
    Optional<Balloon> findById(Long id);
    void deleteById(Long id);
    List<Balloon> findAllByName(String name);
    List<Balloon> findAllByType(String name);
    Optional<Balloon> save(String name, String description, Long id);
}

