package com.example.demospringcloud.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demospringcloud.common.util.Result;
import com.example.demospringcloud.order.service.OrderService;
import com.example.demospringcloud.userapi.api.User2Api;
import com.example.demospringcloud.userapi.api.UserApi;
import com.example.demospringcloud.userapi.dto.CompanyDto;
import com.example.demospringcloud.userapi.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    UserApi userApi;
    @Resource
    User2Api user2Api;

    @Override
    public Object testGetUser() throws Exception {
        Result<UserDto> result = userApi.login("123","asdf");
        result = user2Api.login2("11","22");
        UserDto userDto = result.getData();
//        CompanyDto companyDto = (CompanyDto) userDto.getCompany();
//        CompanyDto companyDto = JSONObject.parseObject(userDto.getCompany(), CompanyDto.class);
        CompanyDto companyDto = map2bean((Map<String, Object>) userDto.getCompany(), CompanyDto.class);
        return result;
    }

    @Override
    public Object testRegiest(String userName, String password) {
        UserDto userDto = new UserDto();
        userDto.setUserName(userName);
        userDto.setPassword(password);
        Result<UserDto> result = userApi.regiest(userDto);
        return result;
    }


    //把Map转化为JavaBean
    public static <T> T map2bean(Map<String,Object> map, Class<T> clz) throws Exception{
        //创建一个需要转换为的类型的对象
        T obj = clz.newInstance();
        //从Map中获取和属性名称一样的值，把值设置给对象(setter方法)

        //得到属性的描述器
        BeanInfo b = Introspector.getBeanInfo(clz,Object.class);
        PropertyDescriptor[] pds = b.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            //得到属性的setter方法
            Method setter = pd.getWriteMethod();
            //得到key名字和属性名字相同的value设置给属性
            setter.invoke(obj, map.get(pd.getName()));
        }
        return obj;
    }
}
