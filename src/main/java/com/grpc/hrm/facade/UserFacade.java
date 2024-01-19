package com.grpc.hrm.facade;

import com.grpc.hrm.mapper.MapperConfig;
import com.grpc.hrm.model.LoginModel;
import com.grpc.hrm.model.User;
import com.grpc.hrm.service.UserService;
import com.grpc.hrm.utils.ValidateUserLogin;
import com.grpc.hrm.utils.ValidateUsersForRegister;
import com.ks.proto.auth.LoginRequest;
import com.ks.proto.auth.LoginResponse;
import com.ks.proto.common.StatusResponse;
import org.springframework.stereotype.Service;

@Service
public class UserFacade {
    private final UserService userService;

    public UserFacade(UserService userService) {
        this.userService = userService;
    }

    public StatusResponse register(com.ks.proto.user.User user) {
        ValidateUsersForRegister.validateUsersForRegister(user);
        User user1 = MapperConfig.INSTANCE.mapToUser(user);
        userService.register(user1);
        return StatusResponse.newBuilder()
                .setStatus("User registered successfully!!")
                .build();
    }

    public LoginResponse login(LoginRequest loginRequest) {
        ValidateUserLogin.validateUserLogin(loginRequest);
        LoginModel loginModel = MapperConfig.INSTANCE.mapToLoginDto(loginRequest);
        return  LoginResponse.newBuilder()
                .setToken(userService.login(loginModel).getToken())
                .build();
    }


}
