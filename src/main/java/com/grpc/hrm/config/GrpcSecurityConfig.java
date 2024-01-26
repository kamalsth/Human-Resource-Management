package com.grpc.hrm.config;

import com.grpc.hrm.jwt.JwtAuthProvider;
import com.grpc.hrm.jwt.JwtTokenUtil;
import com.grpc.hrm.model.Role;
import com.ks.proto.auth.AuthServiceGrpc;
import com.ks.proto.leave.LeaveServiceGrpc;
import com.ks.proto.notice.NoticeServiceGrpc;
import com.ks.proto.staff.FileUploadServiceGrpc;
import com.ks.proto.staff.StaffServiceGrpc;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.SignatureException;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Configuration
public class GrpcSecurityConfig {


    private final JwtAuthProvider jwtAuthProvider;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;

    public GrpcSecurityConfig(JwtAuthProvider jwtAuthProvider, JwtTokenUtil jwtTokenUtil, UserDetailsService userDetailsService) {
        this.jwtAuthProvider = jwtAuthProvider;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    AuthenticationManager authenticationManager() {
        return new ProviderManager(jwtAuthProvider);
    }


    @Bean
    GrpcAuthenticationReader grpcAuthenticationReader() {
        return new BearerAuthenticationReader(token ->
        {
            String username =null;
            if (token != null) {
                try {
                    username = jwtTokenUtil.extractUsername(token);
                } catch (SignatureException e) {
                    throw new SignatureException("Invalid JWT token");
                }
            }

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if (!jwtTokenUtil.isTokenExpired(token) && jwtTokenUtil.validateToken(token, userDetails)) {
                    Claims claims = jwtTokenUtil.extractAllClaims(token);
                    List<SimpleGrantedAuthority> authorities = Arrays.stream(claims.get("auth").toString().split(","))
                            .map(SimpleGrantedAuthority::new)
                            .toList();
                    CustomUserDetails user = new CustomUserDetails(claims.getSubject(), userDetails.getPassword(), authorities);
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, user.getPassword(), authorities);
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    return authenticationToken;
                } else {
                    throw new SignatureException("Invalid JWT token");
                }
            }
            return null;
        });

    }


    @Bean
    GrpcSecurityMetadataSource grpcSecurityMetadataSource() {
        ManualGrpcSecurityMetadataSource source = new ManualGrpcSecurityMetadataSource();
        source.setDefault(AccessPredicate.authenticated());

        source.set(AuthServiceGrpc.getServiceDescriptor(), AccessPredicate.permitAll());

        source.set(StaffServiceGrpc.getServiceDescriptor(), AccessPredicate.hasAnyRole(Role.SUPER_ADMIN.name(), Role.ADMIN.name()));

        source.set(FileUploadServiceGrpc.getServiceDescriptor(), AccessPredicate.hasAnyRole(Role.SUPER_ADMIN.name(), Role.ADMIN.name()));

        source.set(LeaveServiceGrpc.getRequestLeaveMethod(), AccessPredicate.hasRole(Role.MEMBER.name()));
        source.set(LeaveServiceGrpc.getUpdateLeaveMethod(), AccessPredicate.hasRole(Role.MEMBER.name()));

        source.set(LeaveServiceGrpc.getGetLeaveListMethod(), AccessPredicate.hasRole(Role.ADMIN.name()));
        source.set(LeaveServiceGrpc.getGetLeaveMethod(), AccessPredicate.hasRole(Role.ADMIN.name()));
        source.set(LeaveServiceGrpc.getConfirmLeaveMethod(), AccessPredicate.hasRole(Role.ADMIN.name()));

        source.set(NoticeServiceGrpc.getAddNoticeMethod(),AccessPredicate.hasRole(Role.ADMIN.name()));
        source.set(NoticeServiceGrpc.getUpdateNoticeMethod(),AccessPredicate.hasRole(Role.ADMIN.name()));
        source.set(NoticeServiceGrpc.getDeleteNoticeMethod(),AccessPredicate.hasRole(Role.ADMIN.name()));
        return source;
    }

    @Bean
    AccessDecisionManager accessDecisionManager() {
        List<AccessDecisionVoter<?>> accessDecisionVoters = new ArrayList<>();
        accessDecisionVoters.add(new AccessPredicateVoter());
        return new UnanimousBased(accessDecisionVoters);

    }

}
