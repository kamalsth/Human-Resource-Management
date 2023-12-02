package com.grpc.hrm.rpc;

import com.grpc.hrm.config.JwtAuthProvider;
import com.grpc.hrm.config.JwtTokenUtil;
import generatedClasses.*;
import io.grpc.stub.StreamObserver;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.stream.Collectors;

public class AuthServiceGrpcImpl extends AuthServiceGrpc.AuthServiceImplBase {

    private final JwtTokenUtil jwtTokenUtil;
    private final JwtAuthProvider jwtAuthProvider;

    public AuthServiceGrpcImpl(JwtTokenUtil jwtTokenUtil, JwtAuthProvider jwtAuthProvider) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.jwtAuthProvider = jwtAuthProvider;
    }

    @Override
    public void login(LoginRequestOuterClass.LoginRequest request, StreamObserver<LoginResponseOuterClass.LoginResponse> responseObserver) {
        System.out.println("login= "+request.getUsername());
        Authentication authentication = jwtAuthProvider.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        String authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
        responseObserver.onNext(LoginResponseOuterClass.LoginResponse.newBuilder()
                .setToken(jwtTokenUtil.generateToken(authentication.getName()))
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void register(RegisterRequestOuterClass.RegisterRequest request, StreamObserver<RegisterResponseOuterClass.RegisterResponse> responseObserver) {
        super.register(request, responseObserver);
    }
}
