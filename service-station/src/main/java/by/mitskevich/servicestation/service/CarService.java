package by.mitskevich.servicestation.service;

import by.mitskevich.servicestation.entity.Car;
import by.mitskevich.servicestation.dto.CarDTO;
import by.mitskevich.servicestation.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository repository;

    public List<CarDTO> getCars() {
        return null;
    }

    public Car createCar(CarDTO carDTO) {
        return new Car();
    }

    public Car updateCar(CarDTO carDTO) {
        return new Car();
    }

    public void deleteCar(Long id) {
    }

    public Car getCarById(Long id) {
        return repository.findById(id).get();
    }
}
