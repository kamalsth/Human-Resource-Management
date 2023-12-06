package com.grpc.hrm.exception;

import io.grpc.Status;
import io.grpc.StatusException;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.security.SignatureException;

@GrpcAdvice
public class GlobalExceptionHandling {

    @GrpcExceptionHandler(NullPointerException.class)
    public Status handleException(NullPointerException exception) {
        return Status.INTERNAL.withDescription("Null value occurred").withCause(exception);
    }

    @GrpcExceptionHandler(UsernameNotFoundException.class)
    public StatusException handleUserNameNotFoundException(UsernameNotFoundException exception) {
        return Status.NOT_FOUND.withDescription(exception.getMessage()).withCause(exception).asException();
    }

    @GrpcExceptionHandler(BadCredentialsException.class)
    public Status handleBadCredentialsException(BadCredentialsException exception) {
        return Status.UNKNOWN.withDescription(exception.getMessage()).withCause(exception);
    }

    @GrpcExceptionHandler(SignatureException.class)
    public Status handleException(SignatureException exception) {
        return Status.INTERNAL.withDescription("Invalid token").withCause(exception);
    }
}
