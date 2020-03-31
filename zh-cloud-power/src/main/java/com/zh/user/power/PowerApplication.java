package com.zh.user.power;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * SpringBoot启动类
 * 默认扫描同级目录，这里就是com.zh，如果需要指定扫描目录，使用@ComponentScan注解
 *
 * @author he.zhang
 * @date 2020/3/14 22:57
 */
@EnableEurekaClient
@SpringBootApplication
public class PowerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PowerApplication.class);
        System.out.println("=========== PowerApplication Started ============");
    }

}
