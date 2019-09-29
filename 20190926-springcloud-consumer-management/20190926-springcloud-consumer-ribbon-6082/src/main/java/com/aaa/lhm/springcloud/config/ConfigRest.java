package com.aaa.lhm.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @LoadBalanced:开启负载均衡
 */
@SpringBootApplication
public class ConfigRest {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }


    /**
     * 这是一个负载均衡的实现，但是耦合度比较高
     *     负载均衡的实现不能绑定RestTemplate这个类，因为一旦出现绑定的状态，耦合度就会非常高，
     *     所以根据职责单一化原则，需要把整个负载均衡的算法的这个方法单独封装出来，
     *     和RestTemplate做解耦
     *
     *     官网文档中说明:
     *      负载均衡的算法类，不能和主启动类在同一个包下和主启动类的子包下
     *      问题就出在于@SpringBootApplication这个注解上，
     *      因为在@SpringBootApplication注解中有一个注解
     *
     *      @ComponentScan:官方给出警告 负载均衡算法类不能和ComponentScan注解在同一个包下
     *      因为最终再使用ribbon的时候，ribbon也有一个注解@ComponentScan(扫描组件用的)
     *      和spring的进行冲突
     *
     *      当ribbon的@ComponentScan注解和Spring的@ComponentScan的版本号一致或者
     *      比spring的@ComponentScan注解的版本号高的时候不会报错！
     *      eg：
     *      Spring框架使用到了log4j的jar包
     *      整个项目中也使用到了log4j的jar包
     *      --->当项目启动报错jar包冲突
     *      --->解决方案:(ClassNotFound)
     *      直接排除spring框架中所带log4j的jar包，让spring框架使用自己项目所导入的log4j的jar包
     *      还可以直接把log4j更新成最新版
     * @return
     */
   /* @Bean
    public IRule randoms() {
        return new RandomRule();
    }*/

}
