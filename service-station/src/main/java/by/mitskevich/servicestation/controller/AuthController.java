package by.mitskevich.servicestation.controller;

import by.mitskevich.servicestation.dto.UserDTO;
import by.mitskevich.servicestation.exception.CustomException;
import by.mitskevich.servicestation.payload.AuthRequest;
import by.mitskevich.servicestation.service.CustomUserDetailsService;
import by.mitskevich.servicestation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final CustomUserDetailsService userDetailsService;

    private final UserService userService;

    @GetMapping("/loginForm")
    public String showSignUpForm(AuthRequest authRequest) {
        return "pages/loginForm";
    }

    @PostMapping()
    public String login(Model model,
                        @ModelAttribute("authRequest") AuthRequest authRequest) throws CustomException {
        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        UserDTO userDTO = userService.getUserByUsername(userDetails.getUsername());
        return "redirect:/users/" + userDTO.getId();
    }
}
