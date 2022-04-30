package by.mitskevich.servicestation.dto;

import by.mitskevich.servicestation.entity.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkOrderDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    private Car car;

    private LocalDate startTime;

    private LocalDate endTime;

    private Status status;

    private Worker worker;

    private List<WorkPrice> workPrices;

    private List<SparePartPrice> sparePartPrices;
}
