package by.mitskevich.servicestation.dto;

import by.mitskevich.servicestation.entity.Car;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    private String firstName;

    private String lastName;

    private String login;

    private String email;

    private int phoneNumber;

    private RoleDTO role;

    private List<Car> cars;
}