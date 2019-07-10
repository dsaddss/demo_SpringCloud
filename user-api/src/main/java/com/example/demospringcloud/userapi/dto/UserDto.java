package com.example.demospringcloud.userapi.dto;

import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.runtime.JSONFunctions;

import java.io.Serializable;

public class UserDto<C> implements Serializable {
    private static final long serialVersionUID = 112341234125345645L;

    private String userName;

    private String password;

    private C company;

    public C getCompany() {
        return company;
    }

    public void setCompany(C company) {
        this.company = company;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
