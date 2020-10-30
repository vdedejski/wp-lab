package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Balloon;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BalloonRepository {

    List<Balloon> ballonList = new ArrayList<>();
    DataHolder dataHolder;

    @PostConstruct
    public void init() {
        ballonList.add(new Balloon("Red", "Red balloon"));
        ballonList.add(new Balloon("Blue", "Blue balloon"));
        ballonList.add(new Balloon("Orange", "Orange balloon"));
        ballonList.add(new Balloon("Grey", "Grey balloon"));
        ballonList.add(new Balloon("Black", "Black balloon"));
        ballonList.add(new Balloon("Purple", "Purple balloon"));
        ballonList.add(new Balloon("Indigo", "Indigo balloon"));
        ballonList.add(new Balloon("Yellow", "Yellow balloon"));
        ballonList.add(new Balloon("Green", "Green balloon"));
        ballonList.add(new Balloon("White", "White balloon"));
    }

    public List<Balloon> findAllBalloons(){
        return ballonList;
    }

    public List<Balloon> findAllByNameOrDescription(String text) {
        if (text != null && !text.isEmpty()){
            return ballonList.stream()
                    .filter(x -> x.getName().equals(text) || x.getDescription().equals(text))
                    .collect(Collectors.toList());
        }

        // Ask if you can throw exception at this stage!!
        //throw new IllegalTextArgument("Text argument was null or empty");
        return null;
    }

    public DataHolder getDataHolder() {
        return dataHolder;
    }
}
