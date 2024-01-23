package com.grpc.hrm.facade;

import com.grpc.hrm.mapper.MapperConfig;
import com.grpc.hrm.model.LoginModel;
import com.grpc.hrm.model.User;
import com.grpc.hrm.model.UserDetail;
import com.grpc.hrm.service.UserService;
import com.grpc.hrm.utils.ValidateUser;
import com.grpc.hrm.utils.ValidateUserLogin;
import com.grpc.hrm.utils.ValidateUsersForRegister;
import com.ks.proto.auth.LoginRequest;
import com.ks.proto.auth.LoginResponse;
import com.ks.proto.common.StatusResponse;
import com.ks.proto.user.ChangePasswordRequest;
import com.ks.proto.user.UserResponse;
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
        return LoginResponse.newBuilder()
                .setToken(userService.login(loginModel).getToken())
                .build();
    }


    public UserResponse aboutMe() {
        UserDetail userDetail = userService.aboutMe();
        return MapperConfig.INSTANCE.mapToUserResponse(userDetail);
    }

    public StatusResponse changePassword(ChangePasswordRequest request) {
        ValidateUser.validationToChangePassword(request);
        userService.changePassword(MapperConfig.INSTANCE.maptoChangePassword(request));
        return StatusResponse.newBuilder()
                .setStatus("Password changed successfully!!")
                .build();
    }
}
