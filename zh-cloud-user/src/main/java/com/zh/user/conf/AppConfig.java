package com.zh.user.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author he.zhang
 * @date 2020/3/14 22:49
 */
@ComponentScan("com.zh")
@Configuration
public class AppConfig {

    @Value("${aa}")
    private String aa;

    /**
     * 声明RestTemplate
     * 注解@LoadBalanced是ribbon里带的功能，用于实现客户端的负载均衡，默认策略是轮训。
     * （eureka的依赖里，已经包含ribbon的依赖了，所以不需要单独引用）
     * @return RestTemplate
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        System.out.println("读取到配置文件："+aa);
        return new RestTemplate();
    }

}
