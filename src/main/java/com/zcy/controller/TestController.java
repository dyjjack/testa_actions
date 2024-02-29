//package com.zcy.controller;
//
//import com.zcy.common.Convert;
//import lombok.extern.slf4j.Slf4j;
//import org.openjdk.jmh.runner.RunnerException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.web.WebProperties;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.PostConstruct;
//
//
//@RestController
//@Slf4j
//@RequestMapping()
//public class TestController {
//
//    @Autowired
//    private WebProperties webProperties;
//
//    @PostConstruct
//    public void init() {
//        webProperties.getResources().setStaticLocations(new String[]{"file:" + Convert.FILE_PATH + "/static/"});
//    }
//
//    @GetMapping("/test")
//    public void addShoppingCartItem() throws RunnerException {
//
//        //转化
//        Convert.execute();
//    }
//
//    @Scheduled(fixedRate = 60 * 1000 * 5)
//    public void run() throws RunnerException {
//
//        //转化
//        Convert.execute();
//    }
//}
