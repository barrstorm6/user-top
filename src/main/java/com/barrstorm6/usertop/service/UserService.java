package com.barrstorm6.usertop.service;

import com.barrstorm6.usertop.model.User;
import com.barrstorm6.usertop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        if (userRepository.existsByUserIdAndLevelId(user.getUserId(), user.getLevelId())) {
            User userInRepo = userRepository.getByUserIdAndAndLevelId(user.getUserId(), user.getLevelId());
            if (user.getResult() > userInRepo.getResult()) {
                userRepository.save(user);
            }
        } else {
            userRepository.save(user);
        }
    }

    public List<User> getAllByUserId(Integer userId) {
        List<User> users = userRepository.getAllByUserId(userId);
        Comparator<User> comparator = Comparator.comparingInt(User::getResult).thenComparingInt(User::getLevelId);
        return users.stream()
                .sorted(comparator.reversed())
                .limit(20)
                .collect(Collectors.toList());
    }

    public List<User> getAllByLevelId(Integer levelId) {
        List<User> users = userRepository.getAllByLevelId(levelId);
        Comparator<User> comparator = Comparator.comparingInt(User::getResult).thenComparingInt(User::getUserId);
        return users.stream()
                .sorted(comparator.reversed())
                .limit(20)
                .collect(Collectors.toList());
    }
}
