package by.mitskevich.servicestation.controller;

import by.mitskevich.servicestation.dto.CreateUserDTO;
import by.mitskevich.servicestation.dto.UserDTO;
import by.mitskevich.servicestation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
//@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping()
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public String getUsers(Model model) {

        List<UserDTO> userDTOS = userService.getUsers();
        model.addAttribute("users", userDTOS);
        return "pages/users";
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_MANAGER')")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        UserDTO userDTO = userService.getUserById(id);
        model.addAttribute("user", userDTO);
        return "pages/users";
    }

    @GetMapping("/createUser")
    public String showSignUpForm(CreateUserDTO createUserDTO) {
        return "pages/createUser";
    }

    @PostMapping("/register")
    public String createUser(Model model,
                             @ModelAttribute("createUserDTO") CreateUserDTO createUserDTO) {
        userService.createUser(createUserDTO);
        model.addAttribute("user", createUserDTO);
        return "redirect:/auth/loginForm";
    }

    @GetMapping("/{id}/updateUser")
    public String showUpdateForm(CreateUserDTO createUserDTO) {
        return "pages/updateUser";
    }

    @PostMapping("/{id}")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public String updateUser(@PathVariable("id") Long id,
                             Model model, @ModelAttribute("createUserDTO") CreateUserDTO createUserDTO) {
        UserDTO userDTO = userService.updateUser(id, createUserDTO);
        model.addAttribute("user", createUserDTO);
        return "redirect:/users/" + createUserDTO.getId();
    }

    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
