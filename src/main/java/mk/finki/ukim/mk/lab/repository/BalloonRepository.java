package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class BalloonRepository {

    public List<Balloon> findAllBalloons() {
        return DataHolder.balloonList;
    }

    public List<Balloon> findAllByNameOrDescription(String text) {
        if (text != null && !text.isEmpty()) {
            return DataHolder.balloonList.stream()
                    .filter(x -> x.getName().equals(text) || x.getDescription().equals(text))
                    .collect(Collectors.toList());
        }
        return null;
    }

    public Optional<Balloon> findById(Long id) {
        return DataHolder.balloonList
                .stream()
                .filter(x -> x.getId().equals(id))
                .findFirst();
    }

    public Optional<Balloon> save(String name, String description, Long balloonId, Manufacturer manufacturer) {

        Balloon balloon = new Balloon(name, description, balloonId, manufacturer);
        DataHolder.balloonList.removeIf(x -> x.getId().equals(balloonId));
        DataHolder.balloonList.add(balloon);
        return Optional.of(balloon);
    }

    public void deleteById(Long id) {
        DataHolder.balloonList.removeIf(x -> x.getId().equals(id));
    }

    public List<Balloon> findAllByName(String name) {
        return DataHolder.balloonList
                .stream()
                .filter(x -> x.getName().contains(name))
                .collect(Collectors.toList());
    }
}
