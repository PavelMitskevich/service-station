package by.mitskevich.servicestation.controller;

import by.mitskevich.servicestation.dto.CreateUserDTO;
import by.mitskevich.servicestation.dto.UserDTO;
import by.mitskevich.servicestation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
//@RestController
@Controller
//@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER','ROLE_USER')")
    public String getUsers(Model model) {

        List<UserDTO> userDTOS = userService.getUsers();
        model.addAttribute("users", userDTOS);
        return "user";
    }

    @GetMapping("/user/{id}")
//    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_MANAGER')")
    public String getUserById(@PathVariable("id") Long id, Model model) {
//        userService.getUserById(id);
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }

    @GetMapping("/createUser")
    public String showSignUpForm(CreateUserDTO createUserDTO) {
        return "createUser";
    }

    @PostMapping("/register")
    public String createUser(Model model,
                             @ModelAttribute("createUserDTO") CreateUserDTO createUserDTO) {
        userService.createUser(createUserDTO);
        model.addAttribute("user", createUserDTO);
        return "redirect:/loginForm";
    }

    @PutMapping("/user/{id}")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public UserDTO updateUser(@PathVariable("id") Long id, @RequestBody CreateUserDTO createUserDTO) {
        return userService.updateUser(id, createUserDTO);
    }

    @DeleteMapping("/user/{id}")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
