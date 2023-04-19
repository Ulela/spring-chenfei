package com.chenfei.springframework.test.bean;

import com.chenfei.springframework.beans.factory.PropertyValue;
import com.chenfei.springframework.beans.factory.PropertyValues;
import com.chenfei.springframework.beans.factory.config.BeanDefinition;
import com.chenfei.springframework.beans.factory.config.BeanReference;
import com.chenfei.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenf
 * @version V1.0.0
 * @date 2023/4/18 11:40
 **/
public class ApiTest {
    @Test
    public void test_BeanFactory(){
        // 获取bean工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 注册userDao
        beanFactory.registryBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 设置属性列表
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "0002"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);

        // 注册userService
        beanFactory.registryBeanDefinition("userService", beanDefinition);

        // UserService 获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
