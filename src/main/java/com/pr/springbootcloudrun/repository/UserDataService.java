package com.pr.springbootcloudrun.repository;



import com.pr.springbootcloudrun.entity.UserEntity;

import java.util.List;

public interface UserDataService {
    UserEntity getUserByUsername(String username);
    UserEntity add(UserEntity user);

    UserEntity update(UserEntity user);

    UserEntity delete(String username);
    List<UserEntity> getAll();
}
