package by.mitskevich.servicestation.repository;

import by.mitskevich.servicestation.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    void deleteById(Long id);

    Optional<Object> findByUserId(Long id);

    List<Car> findCarsByUserId(Long id);
}
