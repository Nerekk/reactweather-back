package org.example.reactweatherback.ApiControllers;

import io.swagger.v3.oas.annotations.Hidden;
import org.example.reactweatherback.Paths.Paths;
import org.example.reactweatherback.ApiServices.AdminService;
import org.example.reactweatherback.ApiDtos.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(path = "users")
    public ResponseEntity<List<UserResponse>> getAllUsersInfo() {
        return ResponseEntity.ok(adminService.getAllUsers());
    }
}
