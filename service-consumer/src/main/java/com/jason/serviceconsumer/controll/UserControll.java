package com.jason.serviceconsumer.controll;

import com.jason.api.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControll {


    @Reference(version ="${user.service.version}")
    private UserService userService;


    @RequestMapping(value = "hi",method = RequestMethod.GET)
    public String ssyHi(){

        return userService.sayHi();
    }

}
