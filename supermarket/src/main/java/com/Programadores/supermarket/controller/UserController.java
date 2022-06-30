package com.Programadores.supermarket.controller;

import com.Programadores.supermarket.mapper.UserControllerMapper;
import com.Programadores.supermarket.model.Product;
import com.Programadores.supermarket.model.User;
import com.Programadores.supermarket.request.UserRequest;
import com.Programadores.supermarket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserControllerMapper mapper;

    @PostMapping
    public ResponseEntity<User> registerUser( @RequestBody UserRequest request) {
        User u = mapper.userRequestToUser(request);

        return ResponseEntity.ok(userService.registerNewUser(u));
    }

    @GetMapping
    public ResponseEntity<List<User>> getList() {

        return ResponseEntity.ok(userService.listUsers());
    }

}
