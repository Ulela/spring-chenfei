package com.chenfei.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.chenfei.springframework.beans.BeansException;
import com.chenfei.springframework.beans.factory.PropertyValue;
import com.chenfei.springframework.beans.factory.PropertyValues;
import com.chenfei.springframework.beans.factory.config.BeanDefinition;
import com.chenfei.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @author chenf
 * @version V1.0.0
 * @date 2023/4/18 11:26
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private final InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();
    private InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        // 属性填充，如果属性未初始化，会递归进行初始化
        applyPropertyValues(beanName, bean, beanDefinition);

        // 添加到单例bean 容器
        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor<?> constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * 对属性进行赋值
     * @param beanName beanName
     * @param bean bean
     * @param beanDefinition beanDefinition
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition
            beanDefinition) {
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
            String name = propertyValue.getName();
            Object value = propertyValue.getValue();

            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getBeanName());
            }
            // 使用hutool 工具包进行属性赋值
            BeanUtil.setFieldValue(bean, name, value);
        }

    }

}
