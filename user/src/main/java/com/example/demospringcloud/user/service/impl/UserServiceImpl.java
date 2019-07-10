package com.example.demospringcloud.user.service.impl;

import com.example.demospringcloud.user.service.UserService;
import com.example.demospringcloud.userapi.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDto login(String userName, String password) {
        UserDto user = new UserDto();
        user.setUserName(userName);
        user.setPassword(password);
        return user;
    }
}
