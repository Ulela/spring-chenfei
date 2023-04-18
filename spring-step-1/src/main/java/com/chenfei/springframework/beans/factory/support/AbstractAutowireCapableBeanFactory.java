package com.chenfei.springframework.beans.factory.support;

import com.chenfei.springframework.beans.BeansException;
import com.chenfei.springframework.beans.factory.config.BeanDefinition;

/**
 * @author chenf
 * @version V1.0.0
 * @date 2023/4/18 11:26
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }
}
