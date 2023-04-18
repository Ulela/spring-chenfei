package com.chenfei.springframework.test.bean;

/**
 * @author chenf
 * @version V1.0.0
 * @date 2023/4/18 11:38
 **/
public class UserService {
    private String name;
    public UserService(String name) {
        this.name = name;
    }
    public void queryUserInfo() {
        System.out.println("查询用户信息：" + name);
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }
}
