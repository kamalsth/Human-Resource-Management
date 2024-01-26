package com.grpc.hrm.service.serviceimpl;

import com.grpc.hrm.config.PasswordEncoder;
import com.grpc.hrm.jwt.JwtAuthProvider;
import com.grpc.hrm.jwt.JwtTokenResponse;
import com.grpc.hrm.jwt.JwtTokenUtil;
import com.grpc.hrm.model.*;
import com.grpc.hrm.repository.UserRepository;
import com.grpc.hrm.service.UserService;
import com.grpc.hrm.utils.GenerateUUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtAuthProvider jwtAuthProvider;
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository, JwtTokenUtil jwtTokenUtil, JwtAuthProvider jwtAuthProvider) {
        this.userRepository = userRepository;
        this.jwtTokenUtil = jwtTokenUtil;
        this.jwtAuthProvider = jwtAuthProvider;
    }

    @Override
    public String register(User user) {
        User existingUser = userRepository.getUserByUsername(user.getUsername());
        if (existingUser != null) {
            throw new RuntimeException("User already exists for username : " + user.getUsername());
        }

        User existingUserByEmail = userRepository.getUserByEmail(user.getEmail());
        if (existingUserByEmail != null) {
            throw new RuntimeException("User already exists for email : " + user.getEmail());
        }

        user.setUserId(GenerateUUID.generateID());
        user.setRole(Role.MEMBER);
        user.setPassword(hashPassword(user.getPassword()));
        userRepository.register(user);
        return "User registered successfully!!";
    }

    //Login
    @Override
    public JwtTokenResponse login(LoginModel user) {
        UserDetails userDetails = jwtAuthProvider.loadUserByUsername(user.getUsername());
        if (userDetails == null) {
            throw new UsernameNotFoundException("User not found with username: " + user.getUsername());
        }
        if (!new PasswordEncoder().matches(user.getPassword(), userDetails.getPassword())) {
            throw new BadCredentialsException("Password not correct of username: " + user.getUsername());
        }
        logger.info("User logged in successfully!!");
        Authentication authentication = jwtAuthProvider.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        String token = jwtTokenUtil.generateToken(authentication);
        return new JwtTokenResponse(token);
    }

    @Override
    public User getUserById(String userId) {
        User user = userRepository.getUserById(userId);
        if (user == null) {
            throw new RuntimeException("User not found for user id : " + userId);
        }
        return userRepository.getUserById(userId);
    }


    @Override
    public void updateUser(String userId, User user) {
        User user1 = userRepository.getUserById(userId);
        if (user1 == null) {
            throw new RuntimeException("User not found for user id : " + userId);
        }
        userRepository.updateUser(userId, user);
    }

    @Override
    public void deleteUser(String userId) {
        User user = userRepository.getUserById(userId);
        if (user == null) {
            throw new RuntimeException("User not found for user id : " + userId);
        }
        userRepository.deleteUser(userId);
    }

    @Override
    public UserDetail aboutMe() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserDetail userDetails = userRepository.getUserByUserDetail(username);
        if (userDetails == null) {
            throw new UsernameNotFoundException("User not found for username : " + username);
        }
        return userDetails;
    }

    @Override
    public String changePassword(ChangePassword request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found for username : " + username);
        }
        if (!new PasswordEncoder().matches(request.getOldPassword(), user.getPassword())) {
            throw new BadCredentialsException("Old password not correct of username: " + username);
        } else if (request.getOldPassword().equals(request.getNewPassword())) {
            throw new BadCredentialsException("New password must be different from old password");
        }
        user.setPassword(hashPassword(request.getNewPassword()));
        userRepository.updateUser(user.getUserId(), user);
        return "Password changed successfully!!";
    }

    public String hashPassword(String password) {
        return new PasswordEncoder().encodePassword(password);
    }


}
