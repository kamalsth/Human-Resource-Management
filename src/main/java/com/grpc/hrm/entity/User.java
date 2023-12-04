package com.grpc.hrm.entity;

import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

public class User {
    private int userId;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private Role role;


    public User(int userId, String username, String password, String name, String email, String phone, Role role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return new ArrayList<>() {
            {
                add(new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return role.name();
                    }
                });
            }
        };
    }
}
