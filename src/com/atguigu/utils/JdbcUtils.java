package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.Properties;

/**
 * 编写工具类 JdbcUtils
 *
 * @author shkstart
 * @create 2020-07-28 20:40
 */
public class JdbcUtils {
    //Druid连接池连接数据库 主要方法
    private static DruidDataSource dataSource;
    //创建一个ThreadLocad使得它在同一个线程的同一个连接下
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();


    //初始化,使用静态代码块创建数据库连接池
    static {
        try {
            Properties properties = new Properties();
            //读取jdbc.配置文件properties
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中加载数据
            properties.load(inputStream);
            //创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接池连接
     *
     * @return 如果返回null连接失败
     */

    public static Connection getConnection() {
        Connection conn = conns.get();
        if (conn == null) {

            try {
                //第一次连接为空,从数据库连接池里取
                conn = dataSource.getConnection();
                //获取后,保存到ThreadLocad对象中,供连接使用
                conns.set(conn);
                //设置手动连接管理事务
                conn.setAutoCommit(false);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;

    }
    /**
     * 提交事务,并关闭释放连接
     */
    public static void conmmitAndClose(){
        Connection connection = conns.get();
        //如果不为空,说明之前使用过连接操作数据库
        if (connection != null) {

            try {
                //提交事务
                connection.commit();
                //同时关闭连接
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //执行remove操作,
        conns.remove();

    }
    /**
     * 回滚事务,并关闭连接
     */
    public static void rollbackAndClose() {
        Connection connection = conns.get();
        //如果不为空,说明之前使用过连接操作数据库
        if (connection != null) {

            try {
                //回滚事务
                connection.rollback();
                //同时关闭连接
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //执行remove操作,
        conns.remove();

    }



//    /**
//     * 关闭连接池
//     *
//     * @param conn
//     */
//    public static void close(Connection conn) {
//        if (conn != null) {
//            try {
//                conn.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//
//    }
}


    