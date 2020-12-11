package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Shipped;
import mk.finki.ukim.mk.lab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippedRepository extends JpaRepository<Shipped, Long> {
    Shipped findByUser(User user);
}
