package com.atguigu.filter;

import com.atguigu.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * 事务过滤器
 */
public class TransactionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
            //提交事务
            JdbcUtils.conmmitAndClose();
        }catch (Exception e) {
            //回滚事务
            JdbcUtils.rollbackAndClose();
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
