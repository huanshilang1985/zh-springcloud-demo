package com.zh.user.conf;

import com.netflix.loadbalancer.IRule;
import com.zh.user.rule.ZhRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义算法的注解类。
 * 这里的作用只想让访问Power项目时生效，这个配置不建议放到根目录下，这样会导致请求其他项目也会用这个配置
 *
 * @author he.zhang
 * @date 2020/3/15 22:35
 */
@Configuration
public class PowerRuleConfig {

    @Bean
    public IRule iRule(){
        return new ZhRule();
    }

}
