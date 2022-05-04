package by.mitskevich.servicestation.service;

import by.mitskevich.servicestation.entity.Role;
import by.mitskevich.servicestation.mapper.RoleMapper;
import by.mitskevich.servicestation.repository.RoleRepository;
import by.mitskevich.servicestation.dto.RoleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository repository;

    public List<RoleDTO> getRoles() {
        return RoleMapper.rolesToRolesDTO(repository.findAll());
    }

    public RoleDTO createRole(RoleDTO request) {
        return RoleMapper.roleToRoleDTO(repository.save(RoleMapper.roleDtoToRole(request)));
    }

    public void deleteRole(Integer id) {
        Role role = repository.getById(id);
        repository.delete(role);
    }

    public RoleDTO getRoleById(Integer id) {
        return RoleMapper.roleToRoleDTO(repository.getById(id));
    }
}