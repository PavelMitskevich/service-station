package by.mitskevich.servicestation.controller;

import by.mitskevich.servicestation.dto.*;
import by.mitskevich.servicestation.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping()
public class WorkOrderController {

    private final WorkOrderService workOrderService;

    private final StatusService statusService;

    private final WorkerService workerService;

    private final CarService carService;

    private final UserService userService;

//    @GetMapping()
////    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
//    public String getOrders() {
//        List<WorkOrderDTO> workOrderDTOS = workOrderService.getWorkOrders();
//
//        return "pages/workOrders";
//    }

    @GetMapping("/users/{userId}/cars/{carId}/workOrders")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public String getOrdersByUserId(@PathVariable("userId") Long userId,
                                    @PathVariable("carId") Long id, Model model) {
        List<WorkOrderDTO> workOrderDTOS = workOrderService.getWorkOrdersByCarId(id);

        model.addAttribute("workOrders", workOrderDTOS);
        return "pages/workOrders";
    }

    @GetMapping("/users/{userId}/cars/{carId}/workOrders/{workOrderId}")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public String updateWorkOrder(@PathVariable("userId") Long userId,
                                  @PathVariable("carId") Long carId,
                                  @PathVariable("workOrderId") Long id, Model model) {
        List<StatusDTO> statusDTOS = statusService.getStatuses();
        model.addAttribute("statuses", statusDTOS);

        List<WorkerDTO> workerDTOS = workerService.getWorkers();
        model.addAttribute("workers", workerDTOS);

        CarDTO carDTO = carService.getCarById(carId);
        model.addAttribute("car", carDTO);

        UserDTO userDTO = userService.getUserById(userId);
        model.addAttribute("user", userDTO);

        WorkOrderDTO workOrderDTO = workOrderService.getWorkOrderById(id);
        model.addAttribute("workOrder", workOrderDTO);
        return "pages/infoOrders";
    }

    @PostMapping("/users/{userId}/cars/{carId}/workOrders/{workOrderId}")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    public String updateStatusAndWorkerAndTime(@PathVariable("userId") Long userId,
                                               @PathVariable("carId") Long carId,
                                               @PathVariable("workOrderId") Long id, Model model, WorkOrderDTO workOrderDTO) {

        List<StatusDTO> statusDTOS = statusService.getStatuses();
        model.addAttribute("statuses", statusDTOS);

        WorkOrderDTO workOrderFromDB = workOrderService.getWorkOrderById(id);
        workOrderFromDB.setWorker(workOrderDTO.getWorker());
        workOrderFromDB.setStatus(workOrderDTO.getStatus());
        workOrderFromDB.setStartTime(workOrderDTO.getStartTime());
        workOrderFromDB.setEndTime(workOrderDTO.getEndTime());
        workOrderService.saveWorkOrder(workOrderDTO);
        model.addAttribute("workOrder", workOrderDTO);
        return "pages/infoOrders";
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
