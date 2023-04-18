package com.chenfei.springframework.beans.factory.support;

import com.chenfei.springframework.beans.BeansException;
import com.chenfei.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author chenf
 * @version V1.0.0
 * @date 2023/4/18 11:26
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();
    private InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    @Override
    Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {

        Constructor<?> cotr = null;
        Constructor<?>[] declaredConstructors = beanDefinition.getBeanClass().getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            if (constructor.getParameterTypes().length == args.length) {
                cotr = constructor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, cotr, args);
    }


}
