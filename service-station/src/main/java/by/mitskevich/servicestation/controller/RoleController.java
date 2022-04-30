package by.mitskevich.servicestation.controller;

import by.mitskevich.servicestation.entity.Role;
import by.mitskevich.servicestation.dto.RoleDTO;
import by.mitskevich.servicestation.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/roles")
    public List<RoleDTO> getRoles() {
        return roleService.getRoles();
    }

    @PostMapping("/roles")
    public Role createRole(@RequestBody RoleDTO request) {
        return roleService.createRole(request);
    }

    @DeleteMapping("/role/{id}")
    public void deleteRole(@PathVariable("id")Integer id) {
        roleService.deleteRole(id);
    }
}
