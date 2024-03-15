package com.pr.springbootcloudrun.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String msg){
        super(msg);
    }
}
