package com.zcy.consumer;

import com.zcy.common.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

@Component
public class Temp {
    @DubboReference(url = "127.0.0.1:8081?serialization=hession2", protocol = "dubbo")
    public UserService userService;

    @DubboReference(url = "127.0.0.1:8081?serialization=fastjson2", protocol = "dubbo")
    public UserService userService2;

    @DubboReference(url = "127.0.0.1:8081?serialization=kryo", protocol = "dubbo")
    public UserService userService3;
}
