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
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * 关闭连接池
     *
     * @param conn
     */
    public static void close(Connection conn) {
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}


    