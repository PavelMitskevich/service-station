package by.mitskevich.servicestation.mapper;

import by.mitskevich.servicestation.entity.User;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.userdetails.UserDetails;

@UtilityClass
public class UserDetailsMapper {
    public UserDetails mapToCustomUser(User user) {
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .roles(user.getRole().getName())
                .build();
    }
}
