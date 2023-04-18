package com.chenfei.springframework.beans.factory.support;

import com.chenfei.springframework.beans.BeansException;
import com.chenfei.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author chenf
 * @version 1.0
 * @date 2023-04-18
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Class<?> beanClass = beanDefinition.getBeanClass();
        try {
            if (ctor != null) {
                return beanClass.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                return beanClass.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
