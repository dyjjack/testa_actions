package com.zcy;

import com.zcy.common.Convert;
import org.apache.dubbo.common.profiler.ProfilerSwitch;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.openjdk.jmh.runner.RunnerException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableDubbo
public class Application implements WebMvcConfigurer, ApplicationRunner {

    public static void main(String[] args) {
//        ProfilerSwitch.setWarnPercent(0);
        ProfilerSwitch.enableDetailProfiler();

        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);




        run.close();
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        //转化
        Convert.execute();
    }
}
