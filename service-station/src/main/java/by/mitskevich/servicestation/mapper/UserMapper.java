package by.mitskevich.servicestation.mapper;

import by.mitskevich.servicestation.dto.UserDTO;
import by.mitskevich.servicestation.entity.User;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class UserMapper {

    public User userDtoToUser(UserDTO userDTO) {
        return User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .login(userDTO.getLogin())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .phoneNumber(userDTO.getPhoneNumber())
                .role(userDTO.getRole())
                .build();
    }

    public UserDTO userToUserDTO(User user) {
        return UserDTO.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .login(user.getLogin())
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole())
                .build();
    }

    public List<User> usersDtoToUsers(List<UserDTO> userDTOS) {
        return userDTOS
                .stream()
                .map(userDTO -> User.builder()
                        .id(userDTO.getId())
                        .firstName(userDTO.getFirstName())
                        .lastName(userDTO.getLastName())
                        .login(userDTO.getLogin())
                        .password(userDTO.getPassword())
                        .email(userDTO.getEmail())
                        .phoneNumber(userDTO.getPhoneNumber())
                        .role(userDTO.getRole())
                        .build()).toList();
    }

    public List<UserDTO> usersToUsersDTO(List<User> users) {
        return  users
                .stream()
                .map(user -> UserDTO.builder()
                        .id(user.getId())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .login(user.getLogin())
                        .password(user.getPassword())
                        .email(user.getEmail())
                        .phoneNumber(user.getPhoneNumber())
                        .role(user.getRole())
                        .build()).toList();
    }
}
