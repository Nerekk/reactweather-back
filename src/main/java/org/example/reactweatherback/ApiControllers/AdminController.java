package org.example.reactweatherback.ApiControllers;

import io.swagger.v3.oas.annotations.Hidden;
import org.example.reactweatherback.Paths.Paths;
import org.example.reactweatherback.ApiServices.AdminService;
import org.example.reactweatherback.ApiDtos.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.ADMIN)
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin:create')")
    @Hidden
    public String post() {
        return "POST:: admin controller";
    }
    @PutMapping
    @PreAuthorize("hasAuthority('admin:update')")
    @Hidden
    public String put() {
        return "PUT:: admin controller";
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('admin:delete')")
    @Hidden
    public String delete() {
        return "DELETE:: admin controller";
    }

    @GetMapping(path = "users/all")
    public ResponseEntity<List<UserResponse>> getAllUsersInfo() {
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    @DeleteMapping(path = "users/delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Integer id) {
        adminService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "users/role/{id}")
    public ResponseEntity<?> swapRoleById(@PathVariable("id") Integer id) {
        adminService.swapRoleById(id);
        return ResponseEntity.ok().build();
    }
}
