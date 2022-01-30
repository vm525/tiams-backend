package com.nvm.tiamsbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String userEmail;
    private String userRole;
    private String urlToRedirect;
}
