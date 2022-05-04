package by.mitskevich.servicestation.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO extends UserDTO {

    private String password;
}