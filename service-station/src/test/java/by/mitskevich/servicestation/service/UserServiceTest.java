package by.mitskevich.servicestation.service;

import by.mitskevich.servicestation.dto.UserDTO;
import by.mitskevich.servicestation.entity.Role;
import by.mitskevich.servicestation.entity.User;
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

        userService = new UserService(userRepository);

        role = Role.builder()
                .name("USER")
                .build();

        expectedUser = UserDTO.builder()
                .id(6)
                .firstName("Max")
                .lastName("Brown")
                .login("M.Brown")
                .password("brown")
                .email("m.b@gmail.com")
                .phoneNumber(297889955)
                .role(role)
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
    void createUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}