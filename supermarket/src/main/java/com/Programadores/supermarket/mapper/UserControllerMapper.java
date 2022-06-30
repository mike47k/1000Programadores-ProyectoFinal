package com.Programadores.supermarket.mapper;
import com.Programadores.supermarket.model.User;
import com.Programadores.supermarket.request.UserRequest;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public interface UserControllerMapper extends  CommonMapper{

    User userRequestToUser(UserRequest userRequest);
}
