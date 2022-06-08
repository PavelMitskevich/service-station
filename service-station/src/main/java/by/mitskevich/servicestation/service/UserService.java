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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public List<UserDTO> getUsers() {
        List<User> users = repository.findAll();
        return users.stream()
                .map(UserMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        User user = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return UserMapper.mapToDto(user);
    }

    public UserDTO getUserByUsername(String username) {
        User user = repository.findByLogin(username).orElseThrow(EntityNotFoundException::new);
        return UserMapper.mapToDto(user);
    }

    public List<UserDTO> getUsersByRole(String inputRole) {
        Role role = roleRepository.findByName(inputRole.toUpperCase()).orElseThrow(EntityNotFoundException::new);
        List<User> users = role.getUsers();
        return users.stream()
                .map(UserMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public UserDTO createUser(CreateUserDTO createUserDTO) {

        User user = UserMapper.mapToEntity(createUserDTO);
        user.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));

        if (user.getRole() == null) {
            user.setRole(roleRepository.findByName("USER").orElseThrow(EntityNotFoundException::new));
        }

        user = repository.save(user);
        return UserMapper.mapToDto(user);
    }

    public UserDTO updateUser(Long id, CreateUserDTO createUserDTO) {

        User user = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        Role role = user.getRole();

        user = UserMapper.createUserDtoToUser(createUserDTO);
        user.setId(id);
        user.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));
        user.setRole(role);

        user = repository.save(user);
        return UserMapper.mapToDto(user);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}