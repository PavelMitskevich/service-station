package by.mitskevich.servicestation.service;

import by.mitskevich.servicestation.dto.StatusDTO;
import by.mitskevich.servicestation.entity.Status;
import by.mitskevich.servicestation.mapper.StatusMapper;
import by.mitskevich.servicestation.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatusService {

    private final StatusRepository repository;


    public List<StatusDTO> getStatuses() {
        List<Status> statuses = repository.findAll();
        return statuses.stream()
                .map(StatusMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
