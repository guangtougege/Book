package com.atguigu.test;

import com.atguigu.bean.User;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.dao.UserDao;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2020-07-28 22:44
 */
public class UserDaoTest {
    UserDaoImpl userDao = new UserDaoImpl();

    @Test
    public void querUserByUsername() {

        if (userDao.querUserByUsername("admin") == null) {
            System.out.println("用户名可用");
        } else {
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("admin", "admin") == null) {
            System.out.println("用户名或密码错误,登录失败");
        }else {
            System.out.println("登录成功");
        }
    }

        @Test
        public void saveUser (){
            System.out.println(userDao.saveUser(new User(2,"wzg168", "123456", "wzg168@qq.com")));
        }
    }