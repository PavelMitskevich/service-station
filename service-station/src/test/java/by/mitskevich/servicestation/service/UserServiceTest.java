package by.mitskevich.servicestation.service;

import by.mitskevich.servicestation.dto.CreateUserDTO;
import by.mitskevich.servicestation.dto.UserDTO;
import by.mitskevich.servicestation.entity.Role;
import by.mitskevich.servicestation.entity.User;
import by.mitskevich.servicestation.mapper.RoleMapper;
import by.mitskevich.servicestation.mapper.UserMapper;
import by.mitskevich.servicestation.repository.RoleRepository;
import by.mitskevich.servicestation.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityNotFoundException;

@SpringBootTest
class UserServiceTest {

    Role role;

    UserDTO expectedUser;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @BeforeEach
    void init() {

        userService = new UserService(userRepository,roleRepository,passwordEncoder);

        role = roleRepository.findByName("USER").orElseThrow();

        expectedUser = UserDTO.builder()
                .id(8)
                .firstName("Max")
                .lastName("Brown")
                .login("M.Brown")
                .email("m.b@gmail.com")
                .phoneNumber(297889955)
                .role(RoleMapper.roleToRoleDTO(role))
                .build();
    }


    @Test
    void getUsers() {
    }

    @ParameterizedTest
    @DisplayName("Testing search user which exists in database")
    @Tag("USERS-TEST")
    @ValueSource(longs = {6})
    void testGetUserById(Long id) {
        UserDTO actualUser = userService.getUserById(id);
        Assertions.assertEquals(expectedUser, actualUser);
    }

    @Test
    @DisplayName("Testing create user to database")
    @Tag("USERS-TEST")
    void createUser() {
        CreateUserDTO createUserDTO = CreateUserDTO.builder()
                .firstName("Max")
                .lastName("Brown")
                .login("M.Brown")
                .password("brown")
                .email("m.b@gmail.com")
                .phoneNumber(297889955)
                .role(RoleMapper.roleToRoleDTO(role))
                .build();
        User user = UserMapper.userDtoToUser(createUserDTO);

        user.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));
        user.setRole(roleRepository.findByName("USER").orElseThrow(EntityNotFoundException::new));

        userRepository.save(user);
        UserDTO actualUser = UserMapper.userToUserDTO(user);
        Assertions.assertEquals(expectedUser.getFirstName(), actualUser.getFirstName());
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}