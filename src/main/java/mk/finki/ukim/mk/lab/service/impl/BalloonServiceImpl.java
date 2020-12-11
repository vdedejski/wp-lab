package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.model.enumerations.TYPE;
import mk.finki.ukim.mk.lab.model.exceptions.ManufacturerNotFoundException;
import mk.finki.ukim.mk.lab.repository.BalloonRepository;
import mk.finki.ukim.mk.lab.repository.ManufacturerRepository;
import mk.finki.ukim.mk.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {

    private final BalloonRepository balloonRepository;
    private final ManufacturerRepository manufacturerRepository;

    public BalloonServiceImpl(BalloonRepository balloonRepository,
                              ManufacturerRepository manufacturerRepository) {
        this.balloonRepository = balloonRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Balloon> findAll() {
        return balloonRepository.findAll();
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        return balloonRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        balloonRepository.deleteById(id);
    }

    @Override
    public List<Balloon> findAllByName(String name) {
        return balloonRepository.findAllByName(name.toLowerCase());
    }

    @Override
    public List<Balloon> findAllByType(String type) {
        return balloonRepository.findAllByType(TYPE.valueOf(type));
    }

    @Override
    @Transactional
    public Optional<Balloon> save(String name, String description, Long id) {
        Manufacturer manufacturer = manufacturerRepository.findById(id).orElseThrow(() -> new ManufacturerNotFoundException(id));
        return Optional.of(this.balloonRepository.save(new Balloon(name, description, manufacturer)));
    }

    @Override
    public List<Balloon> findAllByNameOrDescriptionOrTypeOrManufacturer(String text){
        return balloonRepository.findAllByNameOrDescriptionOrManufacturer_Name(text, text, text);
    }

}
