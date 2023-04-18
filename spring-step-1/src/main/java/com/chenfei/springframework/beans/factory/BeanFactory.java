package com.chenfei.springframework.beans.factory;

import com.chenfei.springframework.beans.BeansException;

/**
 * @author chenf
 * @version V1.0.0
 * @date 2023/4/18 10:58
 **/
public interface BeanFactory {
    /**
     * 根据beanName 获取bean
     * @param beanName beanName
     * @return 实体
     * @throws BeansException BeansException
     */
    Object getBean(String beanName) throws BeansException;
}
