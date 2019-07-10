package com.example.demospringcloud.user.service;

import com.example.demospringcloud.userapi.dto.UserDto;

public interface UserService {

    UserDto login(String userName, String password);

}
