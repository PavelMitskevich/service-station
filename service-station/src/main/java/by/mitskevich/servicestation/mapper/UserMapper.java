package by.mitskevich.servicestation.mapper;

import by.mitskevich.servicestation.dto.UserDTO;
import by.mitskevich.servicestation.entity.User;
import lombok.experimental.UtilityClass;

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
}
