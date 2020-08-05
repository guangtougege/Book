package com.atguigu.test;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2020-07-28 23:43
 */
public class UserServiceTest {
 UserService userService = new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null,"asdadsf","456661","asdsa@sdsd.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(1,"amtss","1234567",null)));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("amtss")){
            System.out.println("用户名已存在,不可用");
        }else {
            System.out.println("用户名可用");
        }
    }
}