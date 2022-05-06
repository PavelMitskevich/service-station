package by.mitskevich.servicestation.controller;

import by.mitskevich.servicestation.dto.WorkerDTO;
import by.mitskevich.servicestation.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/workers")
public class WorkerController {

    private final WorkerService workerService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    public List<WorkerDTO> getWorkers() {
        return workerService.getWorkers();
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public WorkerDTO createWorker(@RequestBody WorkerDTO workerDTO) {
        return workerService.createWorker(workerDTO);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public WorkerDTO updateWorker(@PathVariable("id") Integer id, @RequestBody WorkerDTO workerDTO) {
        return workerService.updateWorker(id, workerDTO);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteWorkerById(Integer id) {
        workerService.deleteWorkerById(id);
    }
}
