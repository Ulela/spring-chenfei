package com.chenfei.springframework.beans.factory.config;

/**
 * @author chenf
 * @version V1.0.0
 * @date 2023/4/18 11:02
 **/
public class BeanDefinition {
    private Class<?> beanClass;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }
}
