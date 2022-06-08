package by.mitskevich.servicestation.service;

import by.mitskevich.servicestation.entity.Role;
import by.mitskevich.servicestation.mapper.RoleMapper;
import by.mitskevich.servicestation.repository.RoleRepository;
import by.mitskevich.servicestation.dto.RoleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository repository;

    public List<RoleDTO> getRoles() {
        List<Role> roles = repository.findAll();
        return roles.stream()
                .map(RoleMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public RoleDTO createRole(RoleDTO request) {
        Role role = RoleMapper.mapToEntity(request);
        role = repository.save(role);
        return RoleMapper.mapToDto(role);
    }

    public void deleteRole(Integer id) {
        Role role = repository.getById(id);
        repository.delete(role);
    }

    public RoleDTO getRoleById(Integer id) {
        Role role = repository.getById(id);
        return RoleMapper.mapToDto(role);
    }
}
