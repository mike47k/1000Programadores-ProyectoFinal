package com.Programadores.supermarket.mapper;
import com.Programadores.supermarket.model.User;
import com.Programadores.supermarket.request.UserRequest;
import com.Programadores.supermarket.response.UserResponse;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface UserControllerMapper {

    @IterableMapping(qualifiedByName = "userToUserResponse")
    List<UserResponse> userListToUserListResponse(List<User> users);
    User userRequestToUser(UserRequest userRequest);

    @Named("userToUserResponse")
    @Mapping(target = "roleName", source = "role.name")
    UserResponse userToUserResponse(User user);
}
