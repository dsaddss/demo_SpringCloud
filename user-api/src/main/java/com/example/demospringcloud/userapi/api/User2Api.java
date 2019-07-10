package com.example.demospringcloud.userapi.api;

import com.example.demospringcloud.common.util.Result;
import com.example.demospringcloud.userapi.dto.CompanyDto;
import com.example.demospringcloud.userapi.dto.UserDto;
import com.example.demospringcloud.userapi.fallback.UserApiFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "weshop-user", path = "user2", fallback = UserApiFallBack.class)
public interface User2Api {

    @GetMapping("/login2")
    Result<UserDto> login2(@RequestParam String userName, @RequestParam String password);

    @RequestMapping("/test2Bean")
    public Result<UserDto> test2Bean(@RequestBody UserDto user, @RequestParam String company);

}
