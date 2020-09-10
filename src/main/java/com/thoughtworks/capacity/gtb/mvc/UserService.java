package com.thoughtworks.capacity.gtb.mvc;

import com.thoughtworks.capacity.gtb.mvc.exception.ExceptionEnum;
import com.thoughtworks.capacity.gtb.mvc.exception.GlobalException;
import com.thoughtworks.capacity.gtb.mvc.utils.CheckUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public void register(User user) {
        CheckUtil.checkName(user.getName());
        CheckUtil.checkPassword(user.getPassword());
        CheckUtil.checkEmail(user.getEmail());

        if (users.stream().anyMatch(u -> user.getName().equals(u.getName()))) {
            throw GlobalException.newException(ExceptionEnum.NAME_DUPLICATE);
        }

        user.setId(users.size() + 1);
        users.add(user);
    }

    public User login(String name, String password) {
        CheckUtil.checkName(name);
        CheckUtil.checkPassword(password);
        return users.stream().filter(user->name.equals(user.getName()) && password.equals(user.getPassword()))
                .findFirst().orElseThrow(()->GlobalException.newException(ExceptionEnum.NAME_OR_PASSWORD_INCORRECT));
    }
}
