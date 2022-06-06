package by.mitskevich.servicestation.mapper;

import by.mitskevich.servicestation.dto.CarDTO;
import by.mitskevich.servicestation.entity.Car;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class CarMapper {

    public Car carDtoToCar(CarDTO carDTO) {
        return Car.builder()
                .vin(carDTO.getVin())
                .brand(carDTO.getBrand())
                .model(carDTO.getModel())
                .year(carDTO.getYear())
//                .user(UserMapper.userDtoToUser(carDTO.getUser()))
//                .workOrders(WorkOrderMapper.workOrderDTOSToWorkOrders(carDTO.getWorkOrders()))
                .build();
    }

    public CarDTO carToCarDTO(Car car) {
        return CarDTO.builder()
                .id(car.getId())
                .vin(car.getVin())
                .brand(car.getBrand())
                .model(car.getModel())
                .year(car.getYear())
                .user(UserMapper.userToUserDTO(car.getUser()))
//                .workOrders(WorkOrderMapper.workOrdersToWorkOrdersDTO(car.getWorkOrders()))
                .build();
    }

    public List<CarDTO> carsToCarsDTO(List<Car> cars) {
        return cars.stream()
                .map(CarMapper::carToCarDTO)
                .collect(Collectors.toList());
    }

    public List<Car> carsDtoToCars(List<CarDTO> carDTOS) {
        return carDTOS.stream()
                .map(CarMapper::carDtoToCar)
                .collect(Collectors.toList());
    }
}