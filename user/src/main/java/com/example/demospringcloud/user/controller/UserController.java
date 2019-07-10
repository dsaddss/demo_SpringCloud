package com.example.demospringcloud.user.controller;

import com.example.demospringcloud.common.util.Result;
import com.example.demospringcloud.user.config.ApplicationConfig;
import com.example.demospringcloud.user.config.WxConfig;
import com.example.demospringcloud.user.service.UserService;
import com.example.demospringcloud.userapi.api.UserApi;
import com.example.demospringcloud.userapi.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController implements UserApi {
    @Autowired
    UserService userService;
    @Autowired
    ApplicationConfig config;
    @Autowired
    WxConfig wxConfig;

    @Override
    @RequestMapping("/login")
    public Result<UserDto> login(String userName, String password){
        UserDto user = userService.login(userName, password);
        return Result.success(user);
    }

    @Override
    @RequestMapping("/regiest")
    public Result<UserDto> regiest(@RequestBody UserDto user) {
        user.setUserName("你好！欢迎注册："+user.getUserName());
        return Result.success(user);
    }

    @RequestMapping("/config")
    public Result<String> config(){
        return Result.success(config.getAppId());
    }

    @RequestMapping("/config2")
    public Result<String> config2(){
        return Result.success(wxConfig.getWX_JYPT_AppId());
    }

}
