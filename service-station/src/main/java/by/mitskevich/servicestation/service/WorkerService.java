package by.mitskevich.servicestation.service;

import by.mitskevich.servicestation.dto.WorkerDTO;
import by.mitskevich.servicestation.entity.Worker;
import by.mitskevich.servicestation.mapper.WorkerMapper;
import by.mitskevich.servicestation.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository repository;


    public List<WorkerDTO> getWorkers() {
        List<Worker> workers = repository.findAll();
        return workers.stream()
                .map(WorkerMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public WorkerDTO createWorker(WorkerDTO workerDTO) {
        Worker worker = WorkerMapper.mapToEntity(workerDTO);
        worker = repository.save(worker);
        return WorkerMapper.mapToDto(worker);
    }

    public WorkerDTO updateWorker(Integer id, WorkerDTO workerDTO) {
        Worker worker = WorkerMapper.mapToEntity(workerDTO);
        worker.setId(id);
        worker = repository.save(worker);
        return WorkerMapper.mapToDto(worker);
    }

    public void deleteWorkerById(Integer id) {
        repository.deleteById(id);
    }
}
