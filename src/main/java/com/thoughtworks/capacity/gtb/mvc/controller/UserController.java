package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import com.thoughtworks.capacity.gtb.mvc.utils.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;


@RestController
@Validated
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid User user) {
        userService.register(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(Result.success(null));
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@Size(max = 10, min = 3, message = "name is invalid") String name, String password) {
        return ResponseEntity.ok(Result.success(userService.login(name, password)));
    }

}
