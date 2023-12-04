package com.grpc.hrm.rpc;

import com.grpc.hrm.config.JwtAuthProvider;
import com.grpc.hrm.config.JwtTokenResponse;
import com.grpc.hrm.config.JwtTokenUtil;
import com.grpc.hrm.facade.UserFacade;
import generatedClasses.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class AuthServiceGrpcImpl extends AuthServiceGrpc.AuthServiceImplBase {

    private final JwtTokenUtil jwtTokenUtil;
    private final JwtAuthProvider jwtAuthProvider;
    private final UserFacade userFacade;

    public AuthServiceGrpcImpl(JwtTokenUtil jwtTokenUtil, JwtAuthProvider jwtAuthProvider, UserFacade userFacade) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.jwtAuthProvider = jwtAuthProvider;
        this.userFacade = userFacade;
    }

    @Override
    public void login(LoginRequestOuterClass.LoginRequest request, StreamObserver<LoginResponseOuterClass.LoginResponse> responseObserver) {
        JwtTokenResponse jwtTokenResponse = userFacade.login(request);
        responseObserver.onNext(LoginResponseOuterClass.LoginResponse.newBuilder()
                .setToken(jwtTokenResponse.getToken())
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void register(RegisterRequestOuterClass.RegisterRequest request, StreamObserver<RegisterResponseOuterClass.RegisterResponse> responseObserver) {
        userFacade.addUser(request.getUser());
        responseObserver.onNext(RegisterResponseOuterClass.RegisterResponse.newBuilder()
                .setStatus("User registered successfully!!")
                .build());
        responseObserver.onCompleted();
    }


}
