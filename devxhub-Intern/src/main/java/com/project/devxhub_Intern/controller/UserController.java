package com.project.devxhub_Intern.controller;

import com.project.devxhub_Intern.dto.UserDto;
import com.project.devxhub_Intern.error.Message;
import com.project.devxhub_Intern.model.User;
import com.project.devxhub_Intern.service.UserService;
import jakarta.validation.Valid;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String userEndpoint() {
        return "This is a user endpoint";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminEndpoint() {
        return "This is an admin endpoint";
    }

    @PostMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDto userDto) {
        try {
            User createdUser = userService.createUser(userDto);
            return ResponseEntity.ok(new Message("Success","User added successfully."));
        }catch (Exception ex){
            return new ResponseEntity<>(new Message("ERROR",ex.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }
}
