package by.mitskevich.servicestation.service;

import by.mitskevich.servicestation.dto.UserDTO;
import by.mitskevich.servicestation.entity.Role;
import by.mitskevich.servicestation.entity.User;
import by.mitskevich.servicestation.mapper.RoleMapper;
import by.mitskevich.servicestation.mapper.UserMapper;
import by.mitskevich.servicestation.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    Role role;

    UserDTO expectedUser;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;


    @BeforeEach
    void init() {

        userService = new UserService(userRepository,null);

        role = Role.builder()
                .id(3)
                .name("USER")
                .build();

        expectedUser = UserDTO.builder()
                .id(8)
                .firstName("Max")
                .lastName("Brown")
                .login("M.Brown")
                .password("brown")
                .email("m.b@gmail.com")
                .phoneNumber(297889955)
                .roleDTO(RoleMapper.roleToRoleDTO(role))
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
        UserDTO userDTO = UserDTO.builder()
                .firstName("Max")
                .lastName("Brown")
                .login("M.Brown")
                .password("brown")
                .email("m.b@gmail.com")
                .phoneNumber(297889955)
                .roleDTO(RoleMapper.roleToRoleDTO(role))
                .build();

        User user = User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .login(userDTO.getLogin())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .phoneNumber(userDTO.getPhoneNumber())
                .role(RoleMapper.roleDtoToRole(userDTO.getRoleDTO()))
                .build();
        userRepository.save(user);
        UserDTO actualUser = UserMapper.userToUserDTO(user);
        Assertions.assertEquals(expectedUser, actualUser);
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}