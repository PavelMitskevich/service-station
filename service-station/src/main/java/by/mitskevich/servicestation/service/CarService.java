package by.mitskevich.servicestation.service;

import by.mitskevich.servicestation.entity.Car;
import by.mitskevich.servicestation.dto.CarDTO;
import by.mitskevich.servicestation.entity.User;
import by.mitskevich.servicestation.mapper.CarMapper;
import by.mitskevich.servicestation.repository.CarRepository;
import by.mitskevich.servicestation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository repository;

    private final UserRepository userRepository;

    public List<CarDTO> getCars() {
        List<Car> cars = repository.findAll();
        return cars.stream()
                .map(CarMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public CarDTO getCarById(Long id) {
        Car car = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return CarMapper.mapToDto(car);
    }

    public List<CarDTO> getCarByUserId(Long id) {
        List<Car> cars = repository.findCarsByUserId(id);
        return cars.stream()
                .map(CarMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public CarDTO createCar(CarDTO carDTO) {
        Car car = CarMapper.mapToEntity(carDTO);
        User user = userRepository.findByLogin(carDTO.getUser().getLogin())
                .orElseThrow(EntityNotFoundException::new);
        car.setUser(user);
        car = repository.save(car);
        return CarMapper.mapToDto(car);
    }

    public CarDTO updateCar(Long id, CarDTO carDTO) {

        Car car = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        User user = car.getUser();
        car = CarMapper.mapToEntity(carDTO);
        car.setId(id);
        car.setUser(user);

        return CarMapper.mapToDto(repository.save(car));
    }

    public void deleteCar(Long id) {
        repository.deleteById(id);
    }
}
