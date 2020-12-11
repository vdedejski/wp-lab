package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Shipped;
import mk.finki.ukim.mk.lab.repository.ShippedRepository;
import mk.finki.ukim.mk.lab.service.ShippedService;
import org.springframework.stereotype.Service;

@Service
public class ShippedServiceImpl implements ShippedService {
    private final ShippedRepository shippedRepository;

    public ShippedServiceImpl(ShippedRepository shippedRepository) {
        this.shippedRepository = shippedRepository;
    }

    @Override
    public void save(Shipped shipped) {
        this.shippedRepository.save(shipped);
    }
}
