package by.mitskevich.servicestation.dto;

import by.mitskevich.servicestation.entity.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    private String firstName;

    private String lastName;

    private String login;

    private String password;

    private String email;

    private int phoneNumber;

    private RoleDTO roleDTO;
}
