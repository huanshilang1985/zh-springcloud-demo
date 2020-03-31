package com.zh.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * SpringBoot启动类
 * 默认扫描同级目录，这里就是com.zh，如果需要指定扫描目录，使用@ComponentScan注解
 *
 * @author he.zhang
 * @date 2020/3/14 22:55
 */
@EnableEurekaClient
@SpringBootApplication
@EnableHystrix
//@RibbonClients({   //name是微服务的名称，configuration是负载策略类
//        @RibbonClient(name = "power", configuration = PowerRuleConfig.class),
//        @RibbonClient(name = "order", configuration = OrderRuleConfig.class)
//})
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
        System.out.println("======= UserApplication Started =======");
    }
}
