package by.mitskevich.servicestation.mapper;

import by.mitskevich.servicestation.dto.RoleDTO;
import by.mitskevich.servicestation.entity.Role;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RoleMapper {

    public Role mapToEntity(RoleDTO roleDTO) {
        return Role.builder()
                .id(roleDTO.getId())
                .name(roleDTO.getName())
                .build();
    }

    public RoleDTO mapToDto(Role role) {
        return RoleDTO.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }
}
