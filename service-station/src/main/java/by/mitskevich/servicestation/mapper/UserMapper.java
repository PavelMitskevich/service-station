package by.mitskevich.servicestation.mapper;

import by.mitskevich.servicestation.dto.UserDTO;
import by.mitskevich.servicestation.entity.User;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@UtilityClass
public class UserMapper {

    public User userDtoToUser(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .login(userDTO.getLogin())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .phoneNumber(userDTO.getPhoneNumber())
                .role(RoleMapper.roleDtoToRole(userDTO.getRoleDTO()))
                .build();
    }

    public UserDTO userToUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .login(user.getLogin())
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .roleDTO(RoleMapper.roleToRoleDTO(user.getRole()))
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
                        .role(RoleMapper.roleDtoToRole(userDTO.getRoleDTO()))
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
                        .roleDTO(RoleMapper.roleToRoleDTO(user.getRole()))
                        .build()).toList();
    }

    public UserDetails mapUserToCustomUser(User user) {
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .roles(user.getRole().getName())
                .build();
    }
}
