package com.aaa.lhm.springcloud.fallback;

import com.aaa.lhm.springcloud.model.User;
import com.aaa.lhm.springcloud.service.IUserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Component:组件类
 *
 * @Component和@Service的区别
 * @Autowired和@Resource的区别
 */
@Component
public class IUserServiceFallbockFactory implements FallbackFactory <IUserService> {
    public IUserService create(Throwable throwable) {
        // create返回的是一个接口
        //并重写接口中的所有方法
        return new IUserService() {
            public List<User> selectAllUsers() {
                System.out.println("熔断");
                return null;
            }
        };
    }
}
