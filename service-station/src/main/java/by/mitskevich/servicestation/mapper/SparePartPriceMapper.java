package by.mitskevich.servicestation.mapper;

import by.mitskevich.servicestation.dto.SparePartPriceDTO;
import by.mitskevich.servicestation.entity.SparePartPrice;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SparePartPriceMapper {

    public SparePartPrice sparePartPriceDtoToSparePartPrice(SparePartPriceDTO sparePartPriceDTO) {
        return SparePartPrice.builder()
                .brand(sparePartPriceDTO.getBrand())
                .vendorCode(sparePartPriceDTO.getVendorCode())
                .price(sparePartPriceDTO.getPrice())
                .discount(sparePartPriceDTO.getDiscount())
                .workOrders(sparePartPriceDTO.getWorkOrders())
                .workPrices(sparePartPriceDTO.getWorkPrices())
                .build();
    }

    public SparePartPriceDTO sparePartPriceToSparePartPriceDTO(SparePartPrice sparePartPrice) {
        return SparePartPriceDTO.builder()
                .brand(sparePartPrice.getBrand())
                .vendorCode(sparePartPrice.getVendorCode())
                .price(sparePartPrice.getPrice())
                .discount(sparePartPrice.getDiscount())
                .workOrders(sparePartPrice.getWorkOrders())
                .workPrices(sparePartPrice.getWorkPrices())
                .build();
    }
}
