package com.grpc.hrm.service.serviceimpl;

import com.grpc.hrm.config.CustomUserDetails;
import com.grpc.hrm.config.JwtTokenResponse;
import com.grpc.hrm.config.JwtTokenUtil;
import com.grpc.hrm.config.PasswordEncoder;
import com.grpc.hrm.dto.LoginDto;
import com.grpc.hrm.entity.Role;
import com.grpc.hrm.entity.User;
import com.grpc.hrm.repository.UserRepository;
import com.grpc.hrm.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService , UserDetailsService {
    private final UserRepository userRepository;
    private final JwtTokenUtil jwtTokenUtil;

    public UserServiceImpl(UserRepository userRepository, JwtTokenUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public void register(User user) {
        user.setRole(Role.MEMBER);
        user.setPassword(hashPassword(user.getPassword()));
        userRepository.addUser(user);
    }

    @Override
    public JwtTokenResponse login(LoginDto user) {
        UserDetails userDetails = loadUserByUsername(user.getUsername());
        if (userDetails.getPassword().equals(user.getPassword())) {
            System.out.println("Login success");
        } else {
            System.out.println("Login failed");
        }
        String token=jwtTokenUtil.generateToken(userDetails);
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.getUserByUsername(username);
        return new CustomUserDetails(user.getUsername(),user.getPassword(),user.getRoles());
    }
}
