package com.qpassessment.grocery.booking.controller;

import com.qpassessment.grocery.booking.model.User;
import com.qpassessment.grocery.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            User createdUser = userService.createUser(user);
            return ResponseEntity.ok(createdUser);
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();

            // Return an error response
            return ResponseEntity.status(500)
                    .body("Error creating the user. Please try again.");
        }
    }
}
