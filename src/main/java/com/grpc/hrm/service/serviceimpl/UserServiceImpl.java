package com.grpc.hrm.service.serviceimpl;

import com.grpc.hrm.config.JwtAuthProvider;
import com.grpc.hrm.config.JwtTokenResponse;
import com.grpc.hrm.config.JwtTokenUtil;
import com.grpc.hrm.config.PasswordEncoder;
import com.grpc.hrm.dto.LoginDto;
import com.grpc.hrm.entity.Role;
import com.grpc.hrm.entity.User;
import com.grpc.hrm.repository.UserRepository;
import com.grpc.hrm.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtAuthProvider jwtAuthProvider;

    public UserServiceImpl(UserRepository userRepository, JwtTokenUtil jwtTokenUtil, JwtAuthProvider jwtAuthProvider) {
        this.userRepository = userRepository;
        this.jwtTokenUtil = jwtTokenUtil;
        this.jwtAuthProvider = jwtAuthProvider;
    }

    @Override
    public void register(User user) {
        user.setRole(Role.MEMBER);
        user.setPassword(hashPassword(user.getPassword()));
        userRepository.register(user);
    }

    //Login
    @Override
    public JwtTokenResponse login(LoginDto user) {
        UserDetails userDetails = jwtAuthProvider.loadUserByUsername(user.getUsername());
        if (userDetails == null) {
            throw new UsernameNotFoundException("User not found with username: " + user.getUsername());
        }
        if (!new PasswordEncoder().matches(user.getPassword(), userDetails.getPassword())) {
            throw new UsernameNotFoundException("Password not correct of username: " + user.getUsername());
        }
        System.out.println("User logged in successfully!!");
        Authentication authentication = jwtAuthProvider.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        String token = jwtTokenUtil.generateToken(authentication);
        return new JwtTokenResponse(token);
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.getUserById(userId);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public void updateUser(int userId, User user) {
        userRepository.updateUser(userId, user);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteUser(userId);
    }

    public String hashPassword(String password) {
        return new PasswordEncoder().encodePassword(password);
    }


}
