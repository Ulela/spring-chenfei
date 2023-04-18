package com.chenfei.springframework.test.bean;

import com.chenfei.springframework.beans.factory.config.BeanDefinition;
import com.chenfei.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author chenf
 * @version V1.0.0
 * @date 2023/4/18 11:40
 **/
public class ApiTest {
    @Test
    public void test_BeanFactory(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. 注入 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registryBeanDefinition("userService", beanDefinition);
        // 3.获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService", "陈飞");
                userService.queryUserInfo();
    }
}
