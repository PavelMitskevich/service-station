package by.mitskevich.servicestation.service;

import by.mitskevich.servicestation.entity.Role;
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
        return null;
    }

    public Role createRole(RoleDTO request) {
        Role role = Role.builder()
                .name(request.getName())
                .build();
        return repository.save(role);
    }

    public void deleteRole(Integer id) {
    }
}
