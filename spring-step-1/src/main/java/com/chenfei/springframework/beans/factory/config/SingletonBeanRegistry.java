package com.chenfei.springframework.beans.factory.config;

/**
 * @author chenf
 * @version V1.0.0
 * @date 2023/4/18 10:59
 **/
public interface SingletonBeanRegistry {
    /**
     * getSingleton
     * @param beanName beanName
     * @return Object
     */
    Object getSingleton(String beanName);
}
