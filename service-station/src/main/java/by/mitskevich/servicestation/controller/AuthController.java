package by.mitskevich.servicestation.controller;

import by.mitskevich.servicestation.exception.CustomException;
import by.mitskevich.servicestation.payload.AuthRequest;
import by.mitskevich.servicestation.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final CustomUserDetailsService userDetailsService;

    @PostMapping
    public UserDetails login(@RequestBody AuthRequest authRequest) throws CustomException {
        return userDetailsService.loadUserByUsername(authRequest.getUsername());
    }
}
