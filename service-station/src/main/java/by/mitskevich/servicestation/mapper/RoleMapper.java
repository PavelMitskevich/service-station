package by.mitskevich.servicestation.mapper;

import by.mitskevich.servicestation.dto.RoleDTO;
import by.mitskevich.servicestation.entity.Role;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class RoleMapper {

    public Role roleDtoToRole(RoleDTO roleDTO) {
        return Role.builder()
                .id(roleDTO.getId())
                .name(roleDTO.getName())
                .build();
    }

    public RoleDTO roleToRoleDTO(Role role) {
        return RoleDTO.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }

    public static List<RoleDTO> rolesToRolesDTO(List<Role> roles) {
        return roles.stream()
                .map(RoleMapper::roleToRoleDTO)
                .collect(Collectors.toList());
    }
}