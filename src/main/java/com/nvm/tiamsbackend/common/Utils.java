package com.nvm.tiamsbackend.common;

import java.util.UUID;

public class Utils {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
