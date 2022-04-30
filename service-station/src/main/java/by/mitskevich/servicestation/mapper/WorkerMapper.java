package by.mitskevich.servicestation.mapper;

import by.mitskevich.servicestation.dto.WorkerDTO;
import by.mitskevich.servicestation.entity.Worker;
import lombok.experimental.UtilityClass;

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
                .position(worker.getPosition())
                .firstName(worker.getFirstName())
                .lastName(worker.getLastName())
                .build();
    }
}
