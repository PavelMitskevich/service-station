package by.mitskevich.servicestation.service;

import by.mitskevich.servicestation.dto.CreateUserDTO;
import by.mitskevich.servicestation.dto.UserDTO;
import by.mitskevich.servicestation.entity.Role;
import by.mitskevich.servicestation.entity.User;
import by.mitskevich.servicestation.mapper.UserMapper;
import by.mitskevich.servicestation.repository.RoleRepository;
import by.mitskevich.servicestation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public List<UserDTO> getUsers() {
        return UserMapper.usersToUsersDTO(repository.findAll());
    }

    public UserDTO getUserById(Long id) {
        return UserMapper.userToUserDTO(repository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public UserDTO createUser(CreateUserDTO createUserDTO) {

        User user = UserMapper.userDtoToUser(createUserDTO);
        user.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));

        if (user.getRole() == null) {
            user.setRole(roleRepository.findByName("USER").orElseThrow(EntityNotFoundException::new));
        }

        return UserMapper.userToUserDTO(repository.save(user));
    }

    public UserDTO updateUser(Long id, CreateUserDTO createUserDTO) {

        User user = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        Role role = user.getRole();

        user = UserMapper.createUserDtoToUser(createUserDTO);
        user.setId(id);
        user.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));
        user.setRole(role);

        return UserMapper.userToUserDTO(repository.save(user));
    }

    public void deleteUser(Long id) {
        User user = UserMapper.userDtoToUser(getUserById(id));
        repository.delete(user);
    }
}
