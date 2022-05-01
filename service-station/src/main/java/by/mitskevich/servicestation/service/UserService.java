package by.mitskevich.servicestation.service;

import by.mitskevich.servicestation.dto.UserDTO;
import by.mitskevich.servicestation.entity.User;
import by.mitskevich.servicestation.mapper.UserMapper;
import by.mitskevich.servicestation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    private UserMapper mapper;

    public List<UserDTO> getUsers() {
        return UserMapper.usersToUsersDTO(repository.findAll());
    }

    public UserDTO getUserById(Long id) {
        return UserMapper.userToUserDTO(repository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @RolesAllowed(value = "ADMIN")
    public UserDTO createUser(UserDTO userDTO) {
        User user = User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .login(userDTO.getLogin())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .phoneNumber(userDTO.getPhoneNumber())
                .role(userDTO.getRole())
                .build();
        return UserMapper.userToUserDTO(repository.save(user));
    }

    public UserDTO updateUser(UserDTO userDTO) {
        return UserMapper.userToUserDTO(repository.save(UserMapper.userDtoToUser(userDTO)));
    }

    public void deleteUser(Long id) {
    }
}
