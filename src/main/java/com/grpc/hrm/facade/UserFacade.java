package com.grpc.hrm.facade;

import com.grpc.hrm.config.JwtTokenResponse;
import com.grpc.hrm.config.MapperConfig;
import com.grpc.hrm.dto.LoginDto;
import com.grpc.hrm.entity.User;
import com.grpc.hrm.service.UserService;
import generatedClasses.LoginRequestOuterClass;
import generatedClasses.UserOuterClass;
import org.springframework.stereotype.Service;

@Service
public class UserFacade {
    private final UserService userService;

    public UserFacade(UserService userService) {
        this.userService = userService;
    }

    public void register(UserOuterClass.User user) {
        validateUsersForRegister(user);
        User user1 = MapperConfig.INSTANCE.mapToUser(user);
        userService.register(user1);
    }

    public JwtTokenResponse login(LoginRequestOuterClass.LoginRequest loginRequest) {
        if(loginRequest.getUsername().isEmpty() || loginRequest.getPassword().isEmpty()){
            throw new IllegalArgumentException("Fields should not be empty");
        }
        LoginDto loginDto = MapperConfig.INSTANCE.mapToLoginDto(loginRequest);
        return  userService.login(loginDto);
    }


    public void validateUsersForRegister(UserOuterClass.User user){
        if(user==null){
            throw new NullPointerException("User is null");
        }
        if(user.getUsername().isEmpty() || user.getName().isEmpty() || user.getPassword().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Fields should not be empty");
        }
    }

}
