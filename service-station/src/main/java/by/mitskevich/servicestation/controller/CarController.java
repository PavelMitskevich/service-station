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
    public List<CarDTO> getCars() {
        return carService.getCars();
    }

    @GetMapping("/cars/{id}")
    public Car getCarById(@PathVariable("id")Long id) {
        return carService.getCarById(id);
    }

    @PostMapping("/cars")
    public Car createCar(@RequestBody CarDTO carDTO) {
        return carService.createCar(carDTO);
    }

    @PutMapping("/cars")
    public Car updateCar(@RequestBody CarDTO carDTO) {
        return carService.updateCar(carDTO);
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable("id")Long id) {
        carService.deleteCar(id);
    }
}
