package com.atguigu.dao;

import com.atguigu.bean.User;

/**
 * 用户操作的接口
 *
 * @author shkstart
 * @create 2020-07-28 22:17
 */
public interface UserDao {
    /**
     * 注册中验证用户名,使用查询
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 如果返回 null,说明没有这个用户。反之亦然
     */
    public User querUserByUsername(String username);

    /**
     * 登录界面根据用户名和密码去查询用户
     * 查询不到,无法登录
     * 根据 用户名和密码查询用户信息
     * @param username
     * @param password
     * @return 如果返回 null,说明用户名或密码错误,反之亦然
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 注册好的用户信息保存到数据库
     * 保存用户信息
     *
     * @param user
     * @return 返回-1 表示操作失败，其他是 sql 语句影响的行数
     */
    public int saveUser(User user);


}

