package com.nvm.tiamsbackend.common;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.nvm.tiamsbackend.dtos.UserDto;
import com.nvm.tiamsbackend.entity.User;
import org.json.simple.JSONObject;

public class TransformEntityToDto {
    public static UserDto transformUserEntityToDto(User user) {
        return new UserDto(user.getUserEmail(), user.getRoles(), "/app");
    }

    public static String transformUserEntityToJson(User user) {
        JSONObject obj=new JSONObject();
        obj.put("name", user.getUserName());
        obj.put("email", user.getUserEmail());
        obj.put("role", user.getRoles());
        obj.put("redirectTo", "/app");
        return obj.toJSONString();
    }
}
