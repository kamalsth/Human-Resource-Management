package com.grpc.hrm.config;

import com.grpc.hrm.rpc.AuthServiceGrpcImpl;
import com.grpc.hrm.rpc.StaffRpcImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class ServerConfig {
    @Bean
    public Server grpcServer(StaffRpcImpl staffService, AuthServiceGrpcImpl authServiceGrpc) throws IOException {
        Server server = ServerBuilder.forPort(9091)
                .addService(staffService)
                .addService(authServiceGrpc)
                .build();
        server.start();
        System.out.println("Server started at " + server.getPort());
        return server;
    }
}
