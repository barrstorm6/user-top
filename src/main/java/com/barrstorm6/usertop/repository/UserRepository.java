package com.barrstorm6.usertop.repository;

import com.barrstorm6.usertop.model.User;
import com.barrstorm6.usertop.model.UserPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, UserPK> {

    boolean existsByUserIdAndLevelId(Integer userId, Integer levelId);
    User getByUserIdAndAndLevelId(Integer userId, Integer levelId);
    List<User> getAllByUserId(Integer userId);
    List<User> getAllByLevelId(Integer levelId);
}
