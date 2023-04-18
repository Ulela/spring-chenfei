package com.chenfei.springframework.beans.factory.support;

import com.chenfei.springframework.beans.factory.config.BeanDefinition;

/**
 * @author chenf
 * @version V1.0.0
 * @date 2023/4/18 11:32
 **/
public interface BeanDefinitionRegistry {
    /**
     * registryBeanDefinition
     * @param beanName  beanName
     * @param beanDefinition  beanDefinition
     */
    void registryBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
