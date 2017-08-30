package com.wudi.proxy.test;

import com.wudi.proxy.ServiceProxy;
import com.wudi.proxy.service.UserService;
import com.wudi.proxy.service.impl.UserServiceImpl;

public class Test {

    public static void main(String[] args) {
        UserService userService = (UserService)new ServiceProxy().getProxy(new UserServiceImpl());
        userService.saveUser();
    }

}
