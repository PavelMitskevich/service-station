package by.mitskevich.servicestation.controller;

import by.mitskevich.servicestation.dto.CarDTO;
import by.mitskevich.servicestation.dto.WorkOrderDTO;
import by.mitskevich.servicestation.service.CarService;
import by.mitskevich.servicestation.service.WorkOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.addAll;

@RequiredArgsConstructor
@Controller
//@RestController
@RequestMapping()
public class WorkOrderController {

    private final WorkOrderService workOrderService;

    private final CarService carService;

//    @GetMapping()
////    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
//    public String getOrders() {
//        List<WorkOrderDTO> workOrderDTOS = workOrderService.getWorkOrders();
//
//        return "pages/workOrders";
//    }

    @GetMapping("/users/{userId}/cars/{carId}/workOrders")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public String getOrdersByUserId(@PathVariable("carId") Long id, Model model) {
        List<WorkOrderDTO> workOrderDTOS = workOrderService.getWorkOrdersByCarId(id);

        model.addAttribute("workOrders", workOrderDTOS);
        return "pages/workOrders";
    }

    @GetMapping("/status/{inputStatus}")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public List<WorkOrderDTO> getOrders(@PathVariable("inputStatus") String inputStatus) {
        return workOrderService.getWorkOrdersByStatus(inputStatus);
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public WorkOrderDTO getOrderById(@PathVariable("id") Long id) {
        return workOrderService.getWorkOrderById(id);
    }
}
