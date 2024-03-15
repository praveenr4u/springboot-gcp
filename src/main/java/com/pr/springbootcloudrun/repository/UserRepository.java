package com.pr.springbootcloudrun.repository;



import com.pr.springbootcloudrun.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Long> {
    boolean existsByUsername(String userName);

    Optional<UserDto> findByUsername(String userName);

    void deleteByUsername(String userName);
}
