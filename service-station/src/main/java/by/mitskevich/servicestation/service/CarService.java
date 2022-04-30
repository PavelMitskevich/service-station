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

    public List<Car> getCars() {
        return null;
    }

    public Car createCar(CarDTO request) {
        return new Car();
    }

    public Car updateCar(CarDTO request) {
        return new Car();
    }

    public void deleteCar(Long id) {
    }
}
