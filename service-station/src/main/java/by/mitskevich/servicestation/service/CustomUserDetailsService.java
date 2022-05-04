package by.mitskevich.servicestation.service;

import by.mitskevich.servicestation.entity.User;
import by.mitskevich.servicestation.exception.CustomException;
import by.mitskevich.servicestation.mapper.UserMapper;
import by.mitskevich.servicestation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = repository.findByLogin(username)
                .orElseThrow(() -> new CustomException("User with login: " + username + " was not found"));
        return UserMapper.mapUserToCustomUser(user);
    }
}