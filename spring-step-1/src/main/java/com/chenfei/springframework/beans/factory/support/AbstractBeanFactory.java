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
    public Object getBean(String beanName) throws BeansException {
        Object singleton = getSingleton(beanName);
        if (singleton != null) {
            return singleton;
        }
        return createBean(beanName, getBeanDefinition(beanName));
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
    abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
