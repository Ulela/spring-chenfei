package com.chenfei.springframework.beans.factory.support;

import com.chenfei.springframework.beans.BeansException;
import com.chenfei.springframework.beans.factory.BeanFactory;
import com.chenfei.springframework.beans.factory.config.BeanDefinition;

/**
 * @author chenf
 * @version V1.0.0
 * @date 2023/4/18 11:12
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object singleton = getSingleton(name);
        if (singleton != null) {
            return (T) singleton;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    /**
     * getBeanDefinition
     * @param beanName beanName
     * @return BeanDefinition
     * @throws BeansException BeansException
     */
    abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * createBean
     * @param beanName beanName
     * @param beanDefinition beanDefinition
     * @return Object
     * @throws BeansException BeansException
     */
    abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
