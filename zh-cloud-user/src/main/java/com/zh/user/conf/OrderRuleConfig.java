package com.zh.user.conf;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * 访问Order服务，使用随机算法
 *
 * @author he.zhang
 * @date 2020/3/15 22:36
 */
public class OrderRuleConfig {

    @Bean
    public IRule iRule() {
        return new RandomRule();
    }
}
