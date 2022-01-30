package com.nvm.tiamsbackend.common;

import com.nvm.tiamsbackend.dtos.UserDto;
import com.nvm.tiamsbackend.entity.User;

public class TransformEntityToDto {
    public static UserDto transformUserEntityToDto(User user) {
        return new UserDto(user.getUserEmail(), user.getRoles(), "/app");
    }
}
