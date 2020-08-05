package com.atguigu.service;

import com.atguigu.bean.User;

/**
 * UserService 接口
 * Service业务层
 * 登录业务,注册业务,检查用户名
 * @author shkstart
 * @create 2020-07-28 23:30
 */
public interface UserService {
    /**
     * 注册用户业务
     *
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录业务
     * @param user
     * @return  如果返回 null，说明登录失败，返回有值，是登录成功
     */
    public User login(User user);

    /**
     * 检查 用户名是否可用
     * @param username
     * @return  返回 true 表示用户名已存在，返回 false 表示用户名可用
     */
    public boolean existsUsername(String username);


}

