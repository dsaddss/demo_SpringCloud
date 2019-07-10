package com.example.demospringcloud.user.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demospringcloud.common.util.Result;
import com.example.demospringcloud.user.bean.Company;
import com.example.demospringcloud.user.config.ApplicationConfig;
import com.example.demospringcloud.user.config.WxConfig;
import com.example.demospringcloud.user.service.UserService;
import com.example.demospringcloud.userapi.api.User2Api;
import com.example.demospringcloud.userapi.api.UserApi;
import com.example.demospringcloud.userapi.dto.CompanyDto;
import com.example.demospringcloud.userapi.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user2")
public class User2Controller implements User2Api {
    @Autowired
    UserService userService;
    @Autowired
    ApplicationConfig config;
    @Autowired
    WxConfig wxConfig;

    @Override
    @RequestMapping("/login2")
    public Result<UserDto> login2(String userName, String password){
        UserDto<CompanyDto> user = userService.login(userName, password);
        CompanyDto company = new CompanyDto();
        company.setName("xxx");
        company.setAddress("yyy");
//        JSONObject companyStr = JSON.parseObject(JSON.toJSONString(company));
        user.setCompany(company);
        return Result.success(user);
    }

    @Override
    @RequestMapping("/test2Bean")
    public Result<UserDto> test2Bean(@RequestBody UserDto user, @RequestParam String company){
        user.setUserName("你好！欢迎注册："+user.getUserName());
        return Result.success(user);
    }

}
