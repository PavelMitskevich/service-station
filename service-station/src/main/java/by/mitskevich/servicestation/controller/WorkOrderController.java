package by.mitskevich.servicestation.controller;

import by.mitskevich.servicestation.dto.WorkOrderDTO;
import by.mitskevich.servicestation.service.WorkOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/work-orders")
public class WorkOrderController {

    private final WorkOrderService workOrderService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public List<WorkOrderDTO> getOrders() {
        return workOrderService.getWorkOrders();
    }

    @GetMapping("/status/{inputStatus}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public List<WorkOrderDTO> getOrders(@PathVariable("inputStatus") String inputStatus) {
        return workOrderService.getWorkOrdersByStatus(inputStatus);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public WorkOrderDTO getOrderById(@PathVariable("id") Long id) {
        return workOrderService.getWorkOrderById(id);
    }
}
