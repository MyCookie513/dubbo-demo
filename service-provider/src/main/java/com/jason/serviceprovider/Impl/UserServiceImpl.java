package com.jason.serviceprovider.Impl;

import com.jason.api.UserService;
import org.apache.dubbo.config.annotation.Service;


@Service(version = "${user.service.version}")
public class UserServiceImpl implements UserService {

    @Override
    public String sayHi() {
        return "Hello world ! one";
    }

}
