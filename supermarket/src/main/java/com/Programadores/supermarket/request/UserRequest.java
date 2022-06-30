package com.Programadores.supermarket.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
     String name;
     String lastName;
     String email;
     String username;
     String password;
     Long dni;
     String address;
     String postalCode;
     @JsonProperty("card")
     CardRequest card;
}
