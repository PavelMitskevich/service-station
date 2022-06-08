package by.mitskevich.servicestation.mapper;

import by.mitskevich.servicestation.dto.CarDTO;
import by.mitskevich.servicestation.entity.Car;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CarMapper {

    public Car mapToEntity(CarDTO carDTO) {
        return Car.builder()
                .vin(carDTO.getVin())
                .brand(carDTO.getBrand())
                .model(carDTO.getModel())
                .year(carDTO.getYear())
//                .user(UserMapper.userDtoToUser(carDTO.getUser()))
//                .workOrders(WorkOrderMapper.workOrderDTOSToWorkOrders(carDTO.getWorkOrders()))
                .build();
    }

    public CarDTO mapToDto(Car car) {
        return CarDTO.builder()
                .id(car.getId())
                .vin(car.getVin())
                .brand(car.getBrand())
                .model(car.getModel())
                .year(car.getYear())
//                .user(UserMapper.userToUserDTO(car.getUser()))
//                .workOrders(WorkOrderMapper.workOrdersToWorkOrdersDTO(car.getWorkOrders()))
                .build();
    }
}
