package com.example.demospringcloud.userapi.fallback;

import com.example.demospringcloud.common.util.Result;
import com.example.demospringcloud.common.util.ResultCodeEnum;
import com.example.demospringcloud.userapi.api.UserApi;
import com.example.demospringcloud.userapi.dto.UserDto;

public class UserApiFallBack implements UserApi {
    @Override
    public Result<UserDto> login(String userName, String password) {
        return Result.failure(ResultCodeEnum.BAD_REQUEST);
    }

    @Override
    public Result<UserDto> regiest(UserDto user) {
        return null;
    }

}
