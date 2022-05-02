package by.mitskevich.servicestation.service;

import by.mitskevich.servicestation.dto.RoleDTO;
import by.mitskevich.servicestation.dto.UserDTO;
import by.mitskevich.servicestation.entity.User;
import by.mitskevich.servicestation.mapper.RoleMapper;
import by.mitskevich.servicestation.mapper.UserMapper;
import by.mitskevich.servicestation.repository.RoleRepository;
import by.mitskevich.servicestation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    private final RoleRepository roleRepository;

    public List<UserDTO> getUsers() {
        return UserMapper.usersToUsersDTO(repository.findAll());
    }

    public UserDTO getUserById(Long id) {
        return UserMapper.userToUserDTO(repository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .login(userDTO.getLogin())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .phoneNumber(userDTO.getPhoneNumber())
                .role(roleRepository.findById(3).
                        orElseThrow(EntityNotFoundException::new))
                .build();
        return UserMapper.userToUserDTO(repository.save(user));
    }

    public UserDTO updateUser(UserDTO userDTO) {
        return UserMapper.userToUserDTO(repository.save(UserMapper.userDtoToUser(userDTO)));
    }

    public void deleteUser(Long id) {
        User user = UserMapper.userDtoToUser(getUserById(id));
        repository.delete(user);
    }
}
