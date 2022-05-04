package by.mitskevich.servicestation.controller;

import by.mitskevich.servicestation.dto.CreateUserDTO;
import by.mitskevich.servicestation.dto.UserDTO;
import by.mitskevich.servicestation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/role/{role}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public List<UserDTO> getUsersByRole(@PathVariable("role")String role) {
        return userService.getUsersByRole(role);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_MANAGER')")
    public UserDTO getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/register")
    public UserDTO createUser(@RequestBody CreateUserDTO createUserDTO) {
        return userService.createUser(createUserDTO);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public UserDTO updateUser(@PathVariable("id") Long id, @RequestBody CreateUserDTO createUserDTO) {
        return userService.updateUser(id, createUserDTO);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
