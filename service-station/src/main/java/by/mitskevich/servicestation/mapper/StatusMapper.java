package by.mitskevich.servicestation.mapper;

import by.mitskevich.servicestation.dto.StatusDTO;
import by.mitskevich.servicestation.entity.Status;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StatusMapper {

    public Status mapToEntity(StatusDTO statusDTO) {
        return Status.builder()
                .name(statusDTO.getName())
                .build();
    }

    public StatusDTO mapToDto(Status status) {
        return StatusDTO.builder()
                .id(status.getId())
                .name(status.getName())
                .build();
    }
}
