package com.Programadores.supermarket.controller;

import com.Programadores.supermarket.mapper.UserControllerMapper;
import com.Programadores.supermarket.model.User;
import com.Programadores.supermarket.request.AuthenticationRequest;
import com.Programadores.supermarket.request.UserRequest;
import com.Programadores.supermarket.response.AuthenticationResponse;
import com.Programadores.supermarket.response.UserResponse;
import com.Programadores.supermarket.security.JWTUtil;
import com.Programadores.supermarket.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    private final UserControllerMapper mapper;
    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtils;

    @GetMapping("/me")
    public ResponseEntity<UserResponse> getUserInformation(@AuthenticationPrincipal User user) {
        System.out.println("lllllllllllllllllllllllllllllllllll");
        UserResponse response = mapper.userToUserResponse(user);
        System.out.println(response);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {

        AuthenticationResponse response =
                prepareAuthenticationResponse(request.username(), request.password());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerNewUser( @RequestBody UserRequest userRequest) {

        User u = mapper.userRequestToUser(userRequest);
        u = userService.registerNewUser(u);

        AuthenticationResponse response =
                prepareAuthenticationResponse(userRequest.getEmail(), userRequest.getPassword());




        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @SneakyThrows
    private AuthenticationResponse prepareAuthenticationResponse(
            String username, String password) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        if (authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetails users) {

            final String token = jwtUtils.generateToken(users);

            return AuthenticationResponse.builder()
                    .token(token)
                    .expirationDate(jwtUtils.extractExpiration(token))
                    .build();
        }

        throw new AccessDeniedException("error in the authentication process");
    }
}
