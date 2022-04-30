package by.mitskevich.servicestation.mapper;

import by.mitskevich.servicestation.dto.WorkPriceDTO;
import by.mitskevich.servicestation.entity.WorkPrice;
import lombok.experimental.UtilityClass;

@UtilityClass
public class WorkPriceMapper {

    public WorkPrice workPriceDtoToWorkPrice(WorkPriceDTO workPriceDTO) {
        return WorkPrice.builder()
                .name(workPriceDTO.getName())
                .price(workPriceDTO.getPrice())
                .discount(workPriceDTO.getDiscount())
                .workOrders(workPriceDTO.getWorkOrders())
                .sparePartPrices(workPriceDTO.getSparePartPrices())
                .build();
    }

    public WorkPriceDTO workPriceToWorkPriceDTO(WorkPrice workPrice) {
        return WorkPriceDTO.builder()
                .name(workPrice.getName())
                .price(workPrice.getPrice())
                .discount(workPrice.getDiscount())
                .workOrders(workPrice.getWorkOrders())
                .sparePartPrices(workPrice.getSparePartPrices())
                .build();
    }
}
