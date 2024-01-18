package com.grpc.hrm.utils;

import java.util.UUID;

public class GenerateUUID {
    public static String generateID() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().replaceAll("-", "");
        return id.substring(0, 32);

    }
}
