package com.Programadores.supermarket.controller;

import com.Programadores.supermarket.mapper.UserControllerMapper;
import com.Programadores.supermarket.model.Product;
import com.Programadores.supermarket.model.User;
import com.Programadores.supermarket.request.UserRequest;
import com.Programadores.supermarket.response.UserResponse;
import com.Programadores.supermarket.response.UserResponseList;
import com.Programadores.supermarket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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


    @GetMapping
    public ResponseEntity<UserResponseList> getList() {
        List<User> list = userService.listUsers();
        UserResponseList response;
        {
            response = new UserResponseList();
            List<UserResponse> content = mapper.userListToUserListResponse(list);
            response.setContent(content);
        }
        return ResponseEntity.ok(response);
    }

}
