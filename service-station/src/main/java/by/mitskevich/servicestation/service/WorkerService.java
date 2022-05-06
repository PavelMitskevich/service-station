package by.mitskevich.servicestation.service;

import by.mitskevich.servicestation.dto.WorkerDTO;
import by.mitskevich.servicestation.entity.Worker;
import by.mitskevich.servicestation.mapper.WorkerMapper;
import by.mitskevich.servicestation.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository repository;


    public List<WorkerDTO> getWorkers() {
        return WorkerMapper.workersToWorkersDTO(repository.findAll());
    }

    public WorkerDTO createWorker(WorkerDTO workerDTO) {
        return WorkerMapper.workerToWorkerDTO(repository.save(WorkerMapper.workerDtoToWorker(workerDTO)));
    }

    public WorkerDTO updateWorker(Integer id, WorkerDTO workerDTO) {
        int workerId = repository.findById(id).orElseThrow(EntityNotFoundException::new).getId();
        Worker worker = WorkerMapper.workerDtoToWorker(workerDTO);
        worker.setId(workerId);
        return WorkerMapper.workerToWorkerDTO(repository.save(worker));
    }

    public void deleteWorkerById(Integer id) {
        repository.deleteById(id);
    }
}