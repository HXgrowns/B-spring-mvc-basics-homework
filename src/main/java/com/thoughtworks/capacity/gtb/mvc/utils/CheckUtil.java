package com.thoughtworks.capacity.gtb.mvc.utils;

import com.thoughtworks.capacity.gtb.mvc.exception.ExceptionEnum;
import com.thoughtworks.capacity.gtb.mvc.exception.GlobalException;

public class CheckUtil {
    public static void checkName(String name) {
        if (name == null || "".equals(name)) {
            throw GlobalException.newException(ExceptionEnum.NAME_CAN_NOT_EMPTY);
        }

        if (!name.matches("[A-Za-z0-9_]{3,10}")) {
            throw GlobalException.newException(ExceptionEnum.NAME_INVALID);
        }
    }

    public static void checkPassword(String password) {
        if (password == null || "".equals(password)) {
            throw GlobalException.newException(ExceptionEnum.PASSWORD_CAN_NOT_EMPTY);
        }

        if (!password.matches(".{5,12}")) {
            throw GlobalException.newException(ExceptionEnum.PASSWORD_INVALID);
        }
    }

    public static void checkEmail(String email) {
        if (email != null && !email.matches(".*@.*\\.com")) {
            throw GlobalException.newException(ExceptionEnum.EMAIL_INVALID);
        }
    }
}
