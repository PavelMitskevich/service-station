package by.mitskevich.servicestation.controller;

import by.mitskevich.servicestation.entity.Car;
import by.mitskevich.servicestation.dto.CarDTO;
import by.mitskevich.servicestation.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class CarController {
    private final CarService carService;

    @GetMapping("/cars")
    public List<Car> getCars() {
        return carService.getCars();
    }

    @PostMapping("/cars")
    public Car createCar(@RequestBody CarDTO request) {
        return carService.createCar(request);
    }

    @PutMapping("/car")
    public Car updateCar(@RequestBody CarDTO request) {
        return carService.updateCar(request);
    }

    @DeleteMapping("/car/{id}")
    public void deleteCar(@PathVariable("id")Long id) {
        carService.deleteCar(id);
    }
}
