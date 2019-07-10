package com.example.demospringcloud.userapi.api;

import com.example.demospringcloud.common.util.Result;
import com.example.demospringcloud.userapi.fallback.UserApiFallBack;
import com.example.demospringcloud.userapi.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "weshop-user", path = "user", fallback = UserApiFallBack.class)
public interface UserApi {

    @GetMapping("/login")
    Result<UserDto> login(@RequestParam String userName, @RequestParam String password);

    @GetMapping("/regiest")
    Result<UserDto> regiest(UserDto user);

}
