package com.chenfei.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("0001", "陈飞1");
        hashMap.put("0002", "陈飞2");
        hashMap.put("0003", "陈飞3");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}
