package by.mitskevich.servicestation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    private String vin;

    private String brand;

    private String model;

    private int year;

    private UserDTO user;

    private List<WorkOrderDTO> workOrders;
}
