package com.chenfei.springframework.beans.factory.support;

import com.chenfei.springframework.beans.BeansException;
import com.chenfei.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author chenf
 * @version 1.0
 * @date 2023-04-18
 */
public interface InstantiationStrategy {
    /**
     * 实例化对象
     * @param beanDefinition beanDefinition
     * @param beanName beanName
     * @param ctor Constructor
     * @param args Object[]
     * @return Object
     * @throws BeansException BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor
            ctor, Object[] args) throws BeansException;
}
