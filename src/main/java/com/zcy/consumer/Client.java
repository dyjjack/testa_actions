package com.zcy.consumer;


import cn.hutool.extra.spring.SpringUtil;
import com.zcy.common.UserService;
import com.zcy.domain.Page;
import com.zcy.domain.User;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

//@Component
//@org.springframework.context.annotation.Scope(value = "prototype")
@State(Scope.Benchmark)
public class Client extends AbstractClient {
    public static final int CONCURRENCY = 32;

    //    @DubboReference(url = "http://127.0.0.1:8081?serialization=kryo", protocol = "dubbo")

    private UserService userService;

    public Client() {
//        ReferenceConfig<UserService> reference = new ReferenceConfig<>();
//        reference.setInterface(UserService.class);
//        reference.setUrl("http://127.0.0.1:8081?serialization=hession2");
//        reference.setProtocol("dubbo");
//
//        DubboBootstrap.getInstance()
//                .application("first-dubbo-consumer")
//                .reference(reference);

//        System.out.println("----------------------------------------------------------------");
//        this.userService = SpringUtil.getBean(Temp.class).userService;
//        this.userService = SpringUtil.getBean(Temp.class).userService;
    }

    @Setup
    public void setup() {
        switch (serialization) {
            case "hession2":
                this.userService = SpringUtil.getBean(Temp.class).userService;
                break;
            case "fastjson2":
                this.userService = SpringUtil.getBean(Temp.class).userService2;
                break;
            case "kryo":
                this.userService = SpringUtil.getBean(Temp.class).userService3;
                break;
        }
        System.out.println(this.serialization);
    }

    @Override
    protected UserService getUserService() {
        return userService;
    }

    @Param({""})
    private String serialization;

    @Param({""})
    private String time;

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Override
    public Page<User> listUser() throws Exception {
        Page<User> userPage = super.listUser();
        return userPage;
    }

}
