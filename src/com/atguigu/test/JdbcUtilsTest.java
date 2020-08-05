package com.atguigu.test;

import com.atguigu.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2020-07-28 21:19
 */
public class JdbcUtilsTest {

    @Test
    public void testjdbcUt() {
        for (int i = 0; i <100 ; i++) {
            Connection conn = JdbcUtils.getConnection();
            System.out.println(conn);
            JdbcUtils.close(conn);
        }



    }
}