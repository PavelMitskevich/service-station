package by.mitskevich.servicestation.service;

import by.mitskevich.servicestation.dto.WorkOrderDTO;
import by.mitskevich.servicestation.entity.Status;
import by.mitskevich.servicestation.mapper.WorkOrderMapper;
import by.mitskevich.servicestation.repository.StatusRepository;
import by.mitskevich.servicestation.repository.WorkOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkOrderService {

    private final WorkOrderRepository repository;

    private final StatusRepository statusRepository;

    public List<WorkOrderDTO> getWorkOrders() {
        return null;
    }

    public List<WorkOrderDTO> getWorkOrdersByStatus(String inputStatus) {
        Status status = statusRepository.findByName(inputStatus.toUpperCase()).orElseThrow(EntityNotFoundException::new);
        return WorkOrderMapper.workOrdersToWorkOrdersDTO(status.getWorkOrders());
    }

    public WorkOrderDTO getWorkOrderById(Long id) {
        return WorkOrderMapper.workOrderToWorkOrderDTO(repository.findById(id).orElseThrow(EntityNotFoundException::new));
    }
}
