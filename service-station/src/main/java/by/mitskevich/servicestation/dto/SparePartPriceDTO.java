package by.mitskevich.servicestation.dto;

import by.mitskevich.servicestation.entity.WorkOrder;
import by.mitskevich.servicestation.entity.WorkPrice;
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
public class SparePartPriceDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    private String brand;

    private String vendorCode;

    private BigDecimal price;

    private double discount;

    private List<WorkOrder> workOrders;

    private List<WorkPrice> workPrices;
}
