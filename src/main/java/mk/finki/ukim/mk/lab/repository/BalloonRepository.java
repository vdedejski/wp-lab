package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.xml.crypto.Data;
import java.util.*;
import java.util.stream.Collectors;

import static mk.finki.ukim.mk.lab.bootstrap.DataHolder.balloonList;

@Repository
public class BalloonRepository {

    public List<Balloon> findAllBalloons() {
        return balloonList;
    }


    @PostConstruct
    public void init(){

    }
    public List<Balloon> findAllByNameOrDescription(String text) {
        if (text != null && !text.isEmpty()) {
            return balloonList.stream()
                    .filter(x -> x.getName().equals(text) || x.getDescription().equals(text))
                    .collect(Collectors.toList());
        }
        return null;
    }

    public Optional<Balloon> findById(Long id) {
        return balloonList
                .stream()
                .filter(x -> x.getId().equals(id))
                .findFirst();
    }

    public Optional<Balloon> save(String name, String description, Long balloonId, Manufacturer manufacturer) {

        Balloon balloon = new Balloon(name, description, balloonId, manufacturer);
        balloonList.removeIf(x -> x.getId().equals(balloonId));
        balloonList.add(balloon);
        return Optional.of(balloon);
    }

    public void deleteById(Long id) {
        balloonList.removeIf(x -> x.getId().equals(id));
    }

    public List<Balloon> findAllByName(String name) {
        return balloonList
                .stream()
                .filter(x -> x.getName().toLowerCase().contains(name))
                .collect(Collectors.toList());
    }

    public List<Balloon> filterByType(String type){
        List<Balloon> balloonType = new ArrayList<>();
        balloonList.forEach(x -> {
                    if (x.getType() != null){
                        if (x.getType().name().toLowerCase().equals(type)){
                            balloonType.add(x);
                        }
                    }
                });
        return balloonType;
    }

}
