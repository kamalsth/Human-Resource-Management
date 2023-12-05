package com.grpc.hrm.config;

import com.grpc.hrm.entity.Role;
import generatedClasses.StaffServiceGrpc;
import io.jsonwebtoken.Claims;
import net.devh.boot.grpc.server.security.authentication.BearerAuthenticationReader;
import net.devh.boot.grpc.server.security.authentication.GrpcAuthenticationReader;
import net.devh.boot.grpc.server.security.check.AccessPredicate;
import net.devh.boot.grpc.server.security.check.AccessPredicateVoter;
import net.devh.boot.grpc.server.security.check.GrpcSecurityMetadataSource;
import net.devh.boot.grpc.server.security.check.ManualGrpcSecurityMetadataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Configuration
public class SecurityConifg {


    private final JwtAuthProvider jwtAuthProvider;
    private final JwtTokenUtil jwtTokenUtil;

    public SecurityConifg(JwtAuthProvider jwtAuthProvider, JwtTokenUtil jwtTokenUtil) {
        this.jwtAuthProvider = jwtAuthProvider;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Bean
    AuthenticationManager authenticationManager() {
        return new ProviderManager(jwtAuthProvider);
    }


    @Bean
    GrpcAuthenticationReader grpcAuthenticationReader() {
        return new BearerAuthenticationReader(token ->
        {
            Claims claims = jwtTokenUtil.extractAllClaims(token);
            List<SimpleGrantedAuthority> authorities = Arrays.stream(claims.get("auth").toString().split(","))
                    .map(SimpleGrantedAuthority::new)
                    .toList();


            CustomUserDetails user = new CustomUserDetails(claims.getSubject(), "", authorities);
            return new UsernamePasswordAuthenticationToken(user, token, authorities);
        });

    }


    @Bean
    GrpcSecurityMetadataSource grpcSecurityMetadataSource() {
        ManualGrpcSecurityMetadataSource source = new ManualGrpcSecurityMetadataSource();
        source.setDefault(AccessPredicate.permitAll());
        source.set(StaffServiceGrpc.getAddStaffMethod(), AccessPredicate.hasRole(Role.ADMIN.name()));
        source.set(StaffServiceGrpc.getGetAllStaffInfoMethod(), AccessPredicate.hasRole(Role.MEMBER.name()));
        source.set(StaffServiceGrpc.getGetStaffInfoMethod(), AccessPredicate.hasRole(Role.ADMIN.name()));
        return source;
    }

    @Bean
    AccessDecisionManager accessDecisionManager() {
        List<AccessDecisionVoter<?>> accessDecisionVoters = new ArrayList<>();
        accessDecisionVoters.add(new AccessPredicateVoter());
        return new UnanimousBased(accessDecisionVoters);

    }

}
