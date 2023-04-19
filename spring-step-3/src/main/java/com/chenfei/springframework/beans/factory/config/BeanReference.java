package com.chenfei.springframework.beans.factory.config;

/**
 * @author chenf
 * @version V1.0.0
 * @date 2023/4/19 16:22
 **/
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
