package by.mitskevich.servicestation.controller;

import by.mitskevich.servicestation.entity.Role;
import by.mitskevich.servicestation.dto.RoleDTO;
import by.mitskevich.servicestation.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    public List<RoleDTO> getRoles() {
        return roleService.getRoles();
    }

    @PostMapping
    public RoleDTO createRole(@RequestBody RoleDTO request) {
        return roleService.createRole(request);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable("id")Integer id) {
        roleService.deleteRole(id);
    }
}
