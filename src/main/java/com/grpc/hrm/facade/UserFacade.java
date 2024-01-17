package com.grpc.hrm.facade;

import com.grpc.hrm.config.JwtTokenResponse;
import com.grpc.hrm.config.MapperConfig;
import com.grpc.hrm.dto.LoginDto;
import com.grpc.hrm.model.User;
import com.grpc.hrm.service.UserService;
import com.grpc.hrm.utils.ValidateUserLogin;
import com.grpc.hrm.utils.ValidateUsersForRegister;
import com.ks.proto.auth.LoginRequest;
import org.springframework.stereotype.Service;

@Service
public class UserFacade {
    private final UserService userService;

    public UserFacade(UserService userService) {
        this.userService = userService;
    }

    public void register(com.ks.proto.user.User user) {
        ValidateUsersForRegister.validateUsersForRegister(user);
        User user1 = MapperConfig.INSTANCE.mapToUser(user);
        userService.register(user1);
    }

    public JwtTokenResponse login(LoginRequest loginRequest) {
        ValidateUserLogin.validateUserLogin(loginRequest);
        LoginDto loginDto = MapperConfig.INSTANCE.mapToLoginDto(loginRequest);
        return userService.login(loginDto);
    }


}
