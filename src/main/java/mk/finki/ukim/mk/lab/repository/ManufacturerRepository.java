package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ManufacturerRepository {

    public List<Manufacturer> findAll(){
        return DataHolder.manufacturerList;
    }
    public Optional<Manufacturer> findById(Long id){
        return DataHolder.manufacturerList.stream().filter(x -> x.getId().equals(id)).findFirst();
    }
}
