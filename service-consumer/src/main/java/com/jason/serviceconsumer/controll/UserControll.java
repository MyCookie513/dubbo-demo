package com.jason.serviceconsumer.controll;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.netflix.hystrix.HystrixCommands;
import com.jason.api.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControll {


    @Reference(version ="${user.service.version}")
    private UserService userService;

    private long time;


    @HystrixCommand(fallbackMethod = "hiError")
    @RequestMapping(value = "hi")
    public String sayHi() {
        time=System.currentTimeMillis();
        return userService.sayHi();
    }

    public String hiError() {
        System.out.println(System.currentTimeMillis()-time);
        return "Hystrix fallback";
    }
}
