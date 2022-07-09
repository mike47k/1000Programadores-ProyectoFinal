package com.Programadores.supermarket.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserResponse {

     long id;
     String name;
     String lastName;
     String email;
     String username;
     Long dni;
     String address;
     String postalCode;
    String roleName;
}
