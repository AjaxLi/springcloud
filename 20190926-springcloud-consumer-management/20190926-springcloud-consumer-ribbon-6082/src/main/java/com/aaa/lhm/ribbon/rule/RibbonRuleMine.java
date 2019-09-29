package com.aaa.lhm.ribbon.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 实现解耦
 * 如果使用的自定义ribbon算法类，当把这个类标识成配置类的时候，不能再使用@SpringBootApplication
 *  需要使用@Configuration注解
 */
@Configuration
public class RibbonRuleMine {

    @Bean
    public IRule randoms() {

        return new RandomRule();
    }
}
