package by.mitskevich.servicestation.mapper;

import by.mitskevich.servicestation.dto.WorkerDTO;
import by.mitskevich.servicestation.entity.Worker;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class WorkerMapper {

    public Worker workerDtoToWorker(WorkerDTO workerDTO) {
        return Worker.builder()
                .position(workerDTO.getPosition())
                .firstName(workerDTO.getFirstName())
                .lastName(workerDTO.getLastName())
                .build();
    }

    public WorkerDTO workerToWorkerDTO(Worker worker) {
        return WorkerDTO.builder()
                .id(worker.getId())
                .position(worker.getPosition())
                .firstName(worker.getFirstName())
                .lastName(worker.getLastName())
                .build();
    }

    public List<WorkerDTO> workersToWorkersDTO(List<Worker> workers) {
        return workers.stream()
                .map(WorkerMapper::workerToWorkerDTO)
                .collect(Collectors.toList());
    }
}
