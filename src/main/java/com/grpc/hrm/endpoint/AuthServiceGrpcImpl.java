package com.grpc.hrm.endpoint;

import com.grpc.hrm.config.JwtTokenResponse;
import com.grpc.hrm.facade.UserFacade;
import com.ks.proto.auth.AuthServiceGrpc;
import com.ks.proto.auth.LoginRequest;
import com.ks.proto.auth.LoginResponse;
import com.ks.proto.auth.RegisterRequest;
import com.ks.proto.common.StatusResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@GrpcService
public class AuthServiceGrpcImpl extends AuthServiceGrpc.AuthServiceImplBase {
    private final UserFacade userFacade;

    public AuthServiceGrpcImpl(UserFacade userFacade) {
        this.userFacade = userFacade;
    }


    @Override
    public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
        try{
            JwtTokenResponse jwtTokenResponse = userFacade.login(request);
            responseObserver.onNext(LoginResponse.newBuilder()
                    .setToken(jwtTokenResponse.getToken())
                    .build());
            responseObserver.onCompleted();
        }catch (UsernameNotFoundException | BadCredentialsException | IllegalArgumentException e){
            responseObserver.onError(e);
        }

    }

    @Override
    public void register(RegisterRequest request, StreamObserver<StatusResponse> responseObserver) {
        try{
        userFacade.register(request.getUser());
        responseObserver.onNext(StatusResponse.newBuilder()
                .setStatus("User registered successfully!!")
                .build());
        responseObserver.onCompleted();
        }catch (IllegalArgumentException | NullPointerException e){
            responseObserver.onError(e);
        }
    }


}
