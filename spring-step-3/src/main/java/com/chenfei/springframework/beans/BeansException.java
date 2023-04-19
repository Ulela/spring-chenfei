package com.chenfei.springframework.beans;

/**
 * @author chenf
 * @version V1.0.0
 * @date 2023/4/18 10:56
 **/
public class BeansException extends RuntimeException {

    public BeansException(String message, Exception e) {
        super(message, e);
    }

    public BeansException(String message) {
        super(message);
    }
}
