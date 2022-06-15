package by.mitskevich.servicestation.service;

import by.mitskevich.servicestation.dto.WorkOrderDTO;
import by.mitskevich.servicestation.entity.Status;
import by.mitskevich.servicestation.entity.WorkOrder;
import by.mitskevich.servicestation.mapper.WorkOrderMapper;
import by.mitskevich.servicestation.repository.StatusRepository;
import by.mitskevich.servicestation.repository.WorkOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkOrderService {

    private final WorkOrderRepository repository;

    private final StatusRepository statusRepository;

    public List<WorkOrderDTO> getWorkOrders() {
        return null;
    }


    public List<WorkOrderDTO> getWorkOrdersByCarId(Long id) {
        List<WorkOrder> workOrders = repository.findWorkOrdersByCarId(id);
        return workOrders.stream()
                .map(WorkOrderMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public List<WorkOrderDTO> getWorkOrdersByStatus(String inputStatus) {
        Status status = statusRepository.findByName(inputStatus.toUpperCase()).orElseThrow(EntityNotFoundException::new);
        List<WorkOrder> workOrders = status.getWorkOrders();
        return workOrders.stream()
                .map(WorkOrderMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public WorkOrderDTO getWorkOrderById(Long id) {
        WorkOrder workOrder = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return WorkOrderMapper.mapToDto(workOrder);
    }

    public void saveWorkOrder(WorkOrderDTO workOrderDTO) {
        repository.save(WorkOrderMapper.mapToEntity(workOrderDTO));
    }
}
