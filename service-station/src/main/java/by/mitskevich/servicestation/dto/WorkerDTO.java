package by.mitskevich.servicestation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

    private String position;

    private String firstName;

    private String lastName;
}
