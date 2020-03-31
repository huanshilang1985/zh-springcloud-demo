package com.zh.power.conf;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
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

    /**
     * 这个方法是声明RestTemplate，在其他类中可以使用Rest方法，请求其他项目的controller
     * 另一个注解@LoadBalanced是声明使用负载均衡的形式请求
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 自定义内置Tomcat端口
     * @return
     */
    @Bean
    public TomcatServletWebServerFactory tomcat(){
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.setPort(5003);
        return tomcat;
    }


}
