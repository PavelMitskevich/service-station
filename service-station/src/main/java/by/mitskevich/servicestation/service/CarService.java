package by.mitskevich.servicestation.service;

import by.mitskevich.servicestation.entity.Car;
import by.mitskevich.servicestation.dto.CarDTO;
import by.mitskevich.servicestation.entity.User;
import by.mitskevich.servicestation.mapper.CarMapper;
import by.mitskevich.servicestation.mapper.UserMapper;
import by.mitskevich.servicestation.repository.CarRepository;
import by.mitskevich.servicestation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository repository;

    private final UserRepository userRepository;

    public List<CarDTO> getCars() {
        return CarMapper.carsToCarsDTO(repository.findAll());
    }

    public CarDTO getCarById(Long id) {
        return CarMapper.carToCarDTO(repository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public CarDTO createCar(CarDTO carDTO) {
        Car car = CarMapper.carDtoToCar(carDTO);
        User user = userRepository.findByFirstNameAndLastName(carDTO.getUser().getFirstName(), carDTO.getUser().getLastName())
                .orElseThrow(EntityNotFoundException::new);
        car.setUser(user);
        return CarMapper.carToCarDTO(repository.save(car));
    }

    public CarDTO updateCar(Long id, CarDTO carDTO) {

        Car car = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        User user = car.getUser();
        carDTO.setUser(UserMapper.userToUserDTO(user));
        car = CarMapper.carDtoToCar(carDTO);
        car.setId(id);
        car.setUser(user);

        return CarMapper.carToCarDTO(repository.save(car));
    }

    public void deleteCar(Long id) {
        repository.deleteById(id);
    }
}