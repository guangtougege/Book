package com.atguigu.service.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.service.UserService;

/**
 * UserService接口的实现类
 * 登录业务,注册业务,检查用户名
 * @author shkstart
 * @create 2020-07-28 23:36
 */
public class UserServiceImpl implements UserService {
    //需要操作数据库,所以需要dao来操作,写一个对象
    private UserDao userDao = (UserDao) new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);

    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());

    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.querUserByUsername(username)==null){
            //为空,说明没查到,表明用户名可用
            return false;
        }
        return true;
    }
}



    