package by.mitskevich.servicestation.mapper;

import by.mitskevich.servicestation.dto.WorkOrderDTO;
import by.mitskevich.servicestation.entity.WorkOrder;
import lombok.experimental.UtilityClass;

@UtilityClass
public class WorkOrderMapper {
    public WorkOrder workOrderDtoToWorkOrder(WorkOrderDTO workOrderDTO) {
        return WorkOrder.builder()
                .car(workOrderDTO.getCar())
                .startTime(workOrderDTO.getStartTime())
                .endTime(workOrderDTO.getEndTime())
                .status(workOrderDTO.getStatus())
                .worker(workOrderDTO.getWorker())
                .workPrices(workOrderDTO.getWorkPrices())
                .sparePartPrices(workOrderDTO.getSparePartPrices())
                .build();
    }

    public WorkOrderDTO workOrderToWorkOrderDTO(WorkOrder workOrder) {
        return WorkOrderDTO.builder()
                .car(workOrder.getCar())
                .startTime(workOrder.getStartTime())
                .endTime(workOrder.getEndTime())
                .status(workOrder.getStatus())
                .worker(workOrder.getWorker())
                .workPrices(workOrder.getWorkPrices())
                .sparePartPrices(workOrder.getSparePartPrices())
                .build();
    }
}
