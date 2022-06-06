package by.mitskevich.servicestation.mapper;

import by.mitskevich.servicestation.dto.CarDTO;
import by.mitskevich.servicestation.dto.CreateUserDTO;
import by.mitskevich.servicestation.dto.UserDTO;
import by.mitskevich.servicestation.entity.Car;
import by.mitskevich.servicestation.entity.User;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class UserMapper {

    public User createUserDtoToUser(CreateUserDTO createUserDTO) {
        return User.builder()
                .firstName(createUserDTO.getFirstName())
                .lastName(createUserDTO.getLastName())
                .login(createUserDTO.getLogin())
                .password(createUserDTO.getPassword())
                .email(createUserDTO.getEmail())
                .phoneNumber(createUserDTO.getPhoneNumber())
//                .cars(CarMapper.carsDtoToCars(createUserDTO.getCars().stream()
//                                .map(carDTO -> CarDTO.builder()
//                                        .brand(carDTO.getBrand())
//                                        .model(carDTO.getModel())
//                                        .vin(carDTO.getVin())
//                                        .year(carDTO.getYear())
//                                        .workOrders(carDTO.getWorkOrders()).build())
//                        .toList()))
                .build();
    }

    public User userDtoToUser(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .login(userDTO.getLogin())
                .email(userDTO.getEmail())
                .phoneNumber(userDTO.getPhoneNumber())
                .build();
    }

    public UserDTO userToUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .login(user.getLogin())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .role(RoleMapper.roleToRoleDTO(user.getRole()))
//                .cars(CarMapper.carsToCarsDTO(user.getCars().stream()
//                        .map(car -> Car.builder().brand(car.getBrand())
//                                .model(car.getModel())
//                                .vin(car.getVin())
//                                .year(car.getYear())
//                                .workOrders(car.getWorkOrders()).build())
//                        .toList()))
                .build();
    }

    public List<User> usersDtoToUsers(List<UserDTO> userDTOS) {
        return userDTOS
                .stream()
                .map(UserMapper::userDtoToUser)
                .collect(Collectors.toList());
    }

    public List<UserDTO> usersToUsersDTO(List<User> users) {
        return users
                .stream()
                .map(UserMapper::userToUserDTO)
                .collect(Collectors.toList());
    }

    public UserDetails mapUserToCustomUser(User user) {
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .roles(user.getRole().getName())
                .build();
    }
}