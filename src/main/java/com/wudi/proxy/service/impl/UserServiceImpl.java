package com.wudi.proxy.service.impl;

import com.wudi.proxy.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public void saveUser() {
        System.out.println("2：保存用户！");
    }

}
