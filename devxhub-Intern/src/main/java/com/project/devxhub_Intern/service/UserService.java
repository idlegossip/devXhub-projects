package com.project.devxhub_Intern.service;

import com.project.devxhub_Intern.dto.UserDto;
import com.project.devxhub_Intern.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User createUser(UserDto userDto);
    List<User> getAllUsers();
}
