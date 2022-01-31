package com.nvm.tiamsbackend.entity;

import com.nvm.tiamsbackend.common.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {
    @Id
    private String id = Utils.generateId();
    private String userEmail;
    private String userName;
    private String password;
    private boolean isActive = true;
    private String roles;
}
