package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<Integer, User> userMap = new HashMap<>();

    public UserService() {
        this.userMap.put(1, new User("Tom", "12345", "tom@qq.com"));
        this.userMap.put(2, new User("Tim", "12345", "tim@qq.com"));
    }

    public void register(User user) {
        Integer id = userMap.size() + 1;
        userMap.put(id, user);
    }
}
