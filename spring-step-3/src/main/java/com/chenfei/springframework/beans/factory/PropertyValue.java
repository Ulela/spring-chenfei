package com.chenfei.springframework.beans.factory;

/**
 * @author chenf
 * @version V1.0.0
 * @date 2023/4/19 16:18
 **/
public class PropertyValue {

    private final String name;
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
