package by.mitskevich.servicestation.dto;

import by.mitskevich.servicestation.entity.SparePartPrice;
import by.mitskevich.servicestation.entity.WorkOrder;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkPriceDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

    private String name;

    private BigDecimal price;

    private double discount;

    private List<WorkOrder> workOrders;

    private List<SparePartPrice> sparePartPrices;
}
