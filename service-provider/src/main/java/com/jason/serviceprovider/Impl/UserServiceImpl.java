package com.jason.serviceprovider.Impl;
import com.jason.api.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.dubbo.config.annotation.Service;


@Service(version = "${user.service.version}")
public class UserServiceImpl implements UserService {

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public String sayHi() {
//        return "Hello Dubbo, i am from port:" + port;
       // throw new RuntimeException("Exception to show hystrix enabled.");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "pass";
    }
}
